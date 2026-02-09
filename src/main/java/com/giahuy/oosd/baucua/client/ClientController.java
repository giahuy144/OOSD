package main.java.com.giahuy.oosd.baucua.client;

import main.java.com.giahuy.oosd.OCSF.client.AbstractClient;
import main.java.com.giahuy.oosd.baucua.common.ResultResponse;

public class ClientController extends AbstractClient {

    public static volatile boolean roundFinished = false;

    public ClientController(String host, int port) {
        super(host, port);
    }

    @Override
    protected void handleMessageFromServer(Object msg) {
        if (msg instanceof ResultResponse) {
            ResultResponse res = (ResultResponse) msg;

            System.out.println("===== KẾT QUẢ BẦU CUA =====");
            System.out.println("Xúc xắc: " + res.getDiceResult());
            System.out.println("Tiền thắng: " + res.getWinMoney());
            System.out.println("==========================");

            roundFinished = true; // 🔥 báo xong 1 vòng
        }
    }
}
