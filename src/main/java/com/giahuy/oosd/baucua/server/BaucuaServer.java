package main.java.com.giahuy.oosd.baucua.server;

import main.java.com.giahuy.oosd.OCSF.server.AbstractServer;
import main.java.com.giahuy.oosd.OCSF.server.ConnectionToClient;
import main.java.com.giahuy.oosd.baucua.common.Animal;
import main.java.com.giahuy.oosd.baucua.common.BetRequest;
import main.java.com.giahuy.oosd.baucua.common.ResultResponse;

import java.io.IOException;
import java.util.List;
import static main.java.com.giahuy.oosd.baucua.server.GameLogic.calculate;
import static main.java.com.giahuy.oosd.baucua.server.GameLogic.rollDice;

public class BaucuaServer extends AbstractServer {

    public BaucuaServer(int port) {
        super(port);
    }

    @Override
    protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
        if (msg instanceof BetRequest) {
            BetRequest req = (BetRequest) msg;

            List<Animal> result = rollDice();
            int win = calculate(req.getBets(), result);

            try {
                client.sendToClient(new ResultResponse(result, win));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
