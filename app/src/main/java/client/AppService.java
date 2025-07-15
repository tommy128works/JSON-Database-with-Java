package client;


import java.io.*;
import java.net.Socket;

public class AppService {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 34522;

    public AppService() {
        try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output  = new DataOutputStream(socket.getOutputStream())
        ) {
            String msg = "Message from client";
            output.writeUTF(msg); // send a message to the server
            String receivedMsg = input.readUTF(); // read the reply from the server

            System.out.println("Received from the server: " + receivedMsg);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void testSocket() {


    }


}
