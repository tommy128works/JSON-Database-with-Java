package client;

import java.util.Scanner;

public class TextUI {
    private final Scanner scanner;
    private final AppService service;

    public TextUI(AppService service) {
        this.scanner = new Scanner(System.in);
        this.service = service;
    }

    public void start() {
        System.out.println("Client started!");

    }

}
