package main.java.com.giahuy.oosd.baucua.server;

public class ServerMain {
    public static void main(String[] args) {
        try {
            BaucuaServer server = new BaucuaServer(5555);
            server.listen();

            System.out.println("Bầu cua server đang chạy...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
