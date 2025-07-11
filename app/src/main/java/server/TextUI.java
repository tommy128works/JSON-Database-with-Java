package server;

import java.util.Scanner;

public class TextUI {
    private final Scanner scanner;
    private final AppService service;
    private boolean isRunning;

    public TextUI(AppService service) {
        this.scanner = new Scanner(System.in);
        this.service = service;
        this.isRunning = true;
    }

    public void start() {
        while (this.isRunning) {
            this.receiveCommand();
        }
    }

    private void receiveCommand() {
        String input = this.scanner.nextLine();
        // for simplicity, it is assumed the user will input correct commands

        if (input.equals("exit")) {
            this.isRunning = false;
        }

        // get AppService to process input and return a value to print
        System.out.println(this.service.processCommand(input));


    }

}
