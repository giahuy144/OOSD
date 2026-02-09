package main.java.com.giahuy.oosd.OCSF.client;

public class Main {

    public static void main(String[] args) {
        try {
            ObservableClient client =
                    new ObservableClient("localhost", 5555);
            client.openConnection();
            System.out.println("Client đã kết nối server");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}