package client;

import server.TextUI;

public class Main {
    public static void main(String[] args) {
        System.out.println("Client");
        System.out.println(0);
        AppService service = new AppService();
        System.out.println(1);

//        TextUI ui = new TextUI(service);
//        ui.start();
    }
}
