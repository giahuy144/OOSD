package main.java.com.giahuy.oosd.baucua.server;

import main.java.com.giahuy.oosd.baucua.common.Animal;
import java.util.*;

public class GameLogic {

    public static List<Animal> rollDice() {
        Random r = new Random();
//        random 3 lan
        List<Animal> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            result.add(Animal.values()[r.nextInt(6)]);
        }
        return result;
//        Mỗi lần chọn 1 Animal
//        Trả về danh sách 3 con
    }

    public static int calculate(Map<Animal, Integer> bets, List<Animal> result) {
        int total = 0;

        for (Animal a : bets.keySet()) {
            int betMoney = bets.get(a);
            int count = Collections.frequency(result, a);

            if (count > 0) {
                total += betMoney * (count + 1);
            }
        }
        return total;
    }
//        Đếm mỗi con xuất hiện bao nhiêu lần
//        Tiền thắng = tiền cược × số lần xuất hiện

}
