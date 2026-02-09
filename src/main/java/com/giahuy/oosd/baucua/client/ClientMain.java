package main.java.com.giahuy.oosd.baucua.client;

import main.java.com.giahuy.oosd.baucua.common.*;
import java.util.*;

public class ClientMain {

    public static void main(String[] args) {
        try {
            ClientController client =
                    new ClientController("localhost", 5555);
            client.openConnection();

            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n=== MENU ===");
                System.out.println("1. Vào chơi");
                System.out.println("2. Thoát hẳn");
                System.out.print("Chọn: ");

                String menu = sc.nextLine().trim();

                if (menu.equals("2")) {
                    System.out.println("Thoát client.");
                    client.closeConnection();
                    break;
                }

                if (!menu.equals("1")) {
                    continue;
                }

                // ===== VÀO BÀN CHƠI =====
                while (true) {
                    Map<Animal, Integer> bets = new HashMap<>();

                    System.out.println("\n=== BẦU CUA TÔM CÁ ===");
                    System.out.println("Nhập cược (nhập 0 để kết thúc)");

                    while (true) {
                        System.out.print(
                                "Nhập con (BAU/CUA/TOM/CA/GA/NAI) hoặc 0: ");
                        String input = sc.nextLine().trim().toUpperCase();

                        if (input.equals("0")) break;

                        try {
                            Animal animal = Animal.valueOf(input);

                            System.out.print("Nhập số tiền cược: ");
                            int money = Integer.parseInt(sc.nextLine());

                            if (money <= 0) continue;

                            bets.put(animal,
                                    bets.getOrDefault(animal, 0) + money);

                        } catch (Exception e) {
                            System.out.println("Con không hợp lệ!");
                        }
                    }

                    if (!bets.isEmpty()) {
                        client.sendToServer(new BetRequest(bets));
                        System.out.println("Đã gửi cược: " + bets);
                    } else {
                        System.out.println("Bỏ lượt!");
                    }

                    ClientController.roundFinished = false;
                    System.out.println("Đang chờ kết quả...\n");

                    while (!ClientController.roundFinished) {
                        Thread.sleep(200);
                    }

                    System.out.print("Chơi vòng tiếp? (y/n): ");
                    String choice = sc.nextLine().trim().toLowerCase();

                    if (!choice.equals("y")) {
                        System.out.println("Thoát bàn chơi.");
                        break; // 👈 quay lại MENU
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
