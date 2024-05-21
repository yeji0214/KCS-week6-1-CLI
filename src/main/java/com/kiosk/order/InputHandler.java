package com.kiosk.order;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner = new Scanner(System.in);

    public int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
            scanner.next();
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }

    public boolean getBooleanInput(String prompt) {
        System.out.print(prompt);
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice == 1) {
                    return false;
                } else if (choice == 2) {
                    return true;
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                scanner.next();
            }
        }
    }

    public int getQuantity() {
        return getIntInput("수량을 입력하세요 (1-10): ");
    }
}
