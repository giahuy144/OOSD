package main.java.com.giahuy.oosd.OCSF.server;

public class Main {

    public static void main(String[] args) {
        int port = 5555;

        ObservableServer server = new ObservableServer(port);
        try {
            server.listen();
            System.out.println("Server đang chạy ở port " + port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}