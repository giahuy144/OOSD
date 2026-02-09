package main.java.com.giahuy.oosd.baucua.server;

import main.java.com.giahuy.oosd.OCSF.server.AbstractServer;
import main.java.com.giahuy.oosd.OCSF.server.ConnectionToClient;
import main.java.com.giahuy.oosd.baucua.common.Animal;
import main.java.com.giahuy.oosd.baucua.common.BetRequest;
import main.java.com.giahuy.oosd.baucua.common.ResultResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BaucuaServer extends AbstractServer {

    private Map<ConnectionToClient, BetRequest> bets = new HashMap<>();
//Mỗi client
//Cược của client trong 1 lượt
    public BaucuaServer(int port) {
        super(port);
        startGameLoop();
    }

    @Override
    protected  synchronized void handleMessageFromClient(
            Object msg, ConnectionToClient client) {
//gọi hàm này khi client gửi object
        if (msg instanceof BetRequest) {
            bets.put(client, (BetRequest) msg);
//Lưu cược của client
//Client không gửi → không có trong map → bỏ lượt
        }
    }

    private void startGameLoop () {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10000);
                    //10 giây (1 lượt chơi)
                    List<Animal> dice = GameLogic.rollDice();
                    //Server tung xúc xắc 1 lần cho tất cả
                    for (Thread t : getClientConnections()) {
                        //Duyệt toàn bộ client
                        ConnectionToClient client = (ConnectionToClient) t;

                        BetRequest bet = bets.get(client);
                        int win = 0;
                        //Có cược → tính
                        //Không cược → win = 0
                        if (bet != null) {
                            win = GameLogic.calculate(bet.getBets(), dice);
                        }

                        client.sendToClient(
                                new ResultResponse(dice, win)
                        );
                    }
                    bets.clear();
                        //Xoá cược -> chuẩn bị lượt mới
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
