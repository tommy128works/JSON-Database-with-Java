package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class AppService {
    private final String[] db;

    private String address;
    private int port;
    private ServerSocket server;
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    public AppService() {
        this.db = new String[1000];

        try {
            this.address = "127.0.0.1";
            this.port = 1111;
            this.server = new ServerSocket(port, 50, InetAddress.getByName(address));
            this.socket = server.accept();
            this.input = new DataInputStream(socket.getInputStream());
            this.output  = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
//            e.printStackTrace();
        }


    }

    public void testSocket() {
        String send = "Message from server";

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

    public String processCommand(String command) {
        String[] words = command.split(" ");

//        for testing
//        for (String word : words) {
//            System.out.println(word);
//        }

        switch (words[0]) {
            case "set":
                return this.setCommand(words);
            case "get":
                return this.getCommand(words);
            case "delete":
                return this.deleteCommand(words);
            default:
                return "Invalid command";
        }
    }

    private String setCommand(String[] words) {
        int index = Integer.parseInt(words[1]);
        if (index > 1000 || index < 1) {
            return "ERROR";
        } else {
            String[] textSlice = Arrays.copyOfRange(words, 2, words.length);
            String text = String.join(" ", textSlice);
            this.db[index - 1] = text;
//            for testing
//            System.out.println(this.db[index - 1]);
            return "OK";
        }
    }

    private String getCommand(String[] words) {
        int index = Integer.parseInt(words[1]);
        if (index > 1000 || index < 1 || this.db[index - 1] == null) {
            return "ERROR";
        } else {
            return this.db[index - 1];
        }
    }

    private String deleteCommand(String[] words) {
        int index = Integer.parseInt(words[1]);
        if (index > 1000 || index < 1) {
            return "ERROR";
        } else {
            this.db[index - 1] = null;
            return "OK";
        }
    }


}
