package server;

import java.io.*;
import java.net.*;
import java.util.Arrays;

public class AppService {
    private final String[] db;

    private static final int PORT = 34522;

    public AppService() {
        this.db = new String[1000];

        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try (
                        Socket socket = server.accept(); // accept a new client
                        DataInputStream input = new DataInputStream(socket.getInputStream());
                        DataOutputStream output = new DataOutputStream(socket.getOutputStream())
                ) {
                    String msg = input.readUTF(); // read a message from the client
                    output.writeUTF(msg + 1); // resend it to the client
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }


    }

    public void testSocket() {



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
