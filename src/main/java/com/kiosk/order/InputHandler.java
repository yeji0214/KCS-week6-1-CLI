package com.kiosk.order;

import java.util.Scanner;
import com.kiosk.util.Constants;

public class InputHandler {
    private final Scanner scanner = new Scanner(System.in);

    // 정수 입력받기
    public int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println(Constants.INPUT_ERROR);
                scanner.next();
            }
        }
    }

    // 옵션 선택 입력받기
    public boolean getBooleanInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice == 1) {
                    return false;
                } else if (choice == 2) {
                    return true;
                } else {
                    System.out.println(Constants.INPUT_ERROR);
                }
            } else {
                System.out.println(Constants.INPUT_ERROR);
                scanner.next();
            }
        }
    }

    // 수량 입력받기
    public int getQuantity() {
        while (true) {
            System.out.print(Constants.QUANTITY_PROMPT);
            if (scanner.hasNextInt()) {
                int quantity = scanner.nextInt();
                if (quantity >= Constants.MIN_QUANTITY && quantity <= Constants.MAX_QUANTITY) {
                    return quantity;
                } else {
                    System.out.println(Constants.INPUT_QUANTITY_ERROR);
                }
            } else {
                System.out.println(Constants.INPUT_ERROR);
                scanner.next();
            }
        }
    }
}
