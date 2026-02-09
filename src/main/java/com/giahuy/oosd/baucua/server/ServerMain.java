package main.java.com.giahuy.oosd.baucua.server;

public class ServerMain {

    public static void main(String[] args) {
        try {
            int port = 5555;

            BaucuaServer server = new BaucuaServer(port);
            server.listen();

            System.out.println("BẦU CUA SERVER ĐANG CHẠY Ở PORT " + port);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
