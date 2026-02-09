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

    public BaucuaServer(int port) {
        super(port);
        startGameLoop();
    }

    @Override
    protected synchronized void handleMessageFromClient(
            Object msg, ConnectionToClient client) {

        if (msg instanceof BetRequest) {
            bets.put(client, (BetRequest) msg);
            System.out.println("Nhận cược từ client: " + client.getId());
        }
    }

    private void startGameLoop() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10000); // 1 lượt = 10s

                    List<Animal> dice = GameLogic.rollDice();
                    System.out.println("Xúc xắc: " + dice);

                    for (Thread t : getClientConnections()) {
                        ConnectionToClient client = (ConnectionToClient) t;
                        BetRequest bet = bets.get(client);

                        int winMoney = 0;
                        if (bet != null) {
                            winMoney = GameLogic.calculate(
                                    bet.getBets(), dice);
                        }

                        client.sendToClient(
                                new ResultResponse(dice, winMoney)
                        );
                    }

                    bets.clear(); // chuẩn bị lượt mới
                    System.out.println("---- KẾT THÚC LƯỢT ----");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

