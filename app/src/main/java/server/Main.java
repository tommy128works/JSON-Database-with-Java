package server;

public class Main {
    public static void main(String[] args) {
        System.out.println("Server!");

        AppService service = new AppService();
        TextUI ui = new TextUI(service);
        ui.start();





//        for investigating work directory
//        String path = System.getProperty("user.dir") + "/src/client/data/";
//        System.out.println(path);
    }
}
