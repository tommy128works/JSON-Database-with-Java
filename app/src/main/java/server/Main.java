package server;

public class Main {
    public static void main(String[] args) {
        System.out.println("Server");

        System.out.println(0);
        AppService service = new AppService();
        System.out.println(1);

//        TextUI ui = new TextUI(service);
//        ui.start();

//        for investigating work directory
//        String path = System.getProperty("user.dir") + "/src/client/data/";
//        System.out.println(path);
    }
}
