package server;

import java.util.Arrays;

public class AppService {
    private final String[] db;

    public AppService() {
        this.db = new String[1000];
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
                break;
            case "delete":
                break;
            default:
                return "Invalid command";
        }
        return null;
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
}
