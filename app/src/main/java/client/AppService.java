package client;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class AppService {
    private String address;
    private int port;
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    public AppService() {
        try {
            this.address = "127.0.0.1";
            this.port = 2222;
            this.socket = new Socket(InetAddress.getByName(address), port);
            this.input = new DataInputStream(socket.getInputStream());
            this.output = new DataOutputStream(socket.getOutputStream());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
//            e.printStackTrace();
        }

    }

    public void testSocket() {
        String send = "Message from client";

        try {
            output.writeUTF(send);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            String receive = input.readUTF();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }


}
