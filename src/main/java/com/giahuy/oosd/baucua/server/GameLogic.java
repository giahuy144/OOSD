package main.java.com.giahuy.oosd.baucua.server;

import main.java.com.giahuy.oosd.baucua.common.Animal;
import java.util.*;

public class GameLogic {

    public static List<Animal> rollDice() {
        Random r = new Random();
        List<Animal> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            result.add(Animal.values()[r.nextInt(6)]);
        }
        return result;
    }

    public static int calculate(Map<Animal, Integer> bets, List<Animal> result) {
        int total = 0;
        for (Animal a : bets.keySet()) {
            int count = Collections.frequency(result, a);
            total += bets.get(a) * count;
        }
        return total;
    }

}
