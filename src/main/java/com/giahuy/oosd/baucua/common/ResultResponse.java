package main.java.com.giahuy.oosd.baucua.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ResultResponse implements Serializable {
    private List<Animal> diceResult;
    private int winMoney;

    public ResultResponse(List<Animal> diceResult, int winMoney) {
        this.diceResult = diceResult;
        this.winMoney = winMoney;
    }

    public List<Animal> getDiceResult() {
        return diceResult;
    }

    public int getWinMoney() {
        return winMoney;
    }

    @Override
    public String toString() {
        return "Xúc xắc: " + diceResult +
                " | Tiền thắng: " + winMoney;
    }
}
