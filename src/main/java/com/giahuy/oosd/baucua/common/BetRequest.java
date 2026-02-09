package main.java.com.giahuy.oosd.baucua.common;

import java.io.Serializable;
import java.util.Map;

public class BetRequest implements Serializable {
    private Map<Animal, Integer> bets;
//    Object client gửi lên server
//    Chứa các cược

    public BetRequest(Map<Animal, Integer> bets) {
        this.bets = bets;
    }

    public Map<Animal, Integer> getBets() {
        return bets;
    }
}
