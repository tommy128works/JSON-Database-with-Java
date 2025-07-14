package client;

import server.AppService;
import server.TextUI;

public class Main {
    public static void main(String[] args) {
        System.out.println(0);
        server.AppService service = new AppService();
        System.out.println(1);

//        server.TextUI ui = new TextUI(service);
//        ui.start();
    }
}
