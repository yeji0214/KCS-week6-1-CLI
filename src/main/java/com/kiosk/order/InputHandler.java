package com.kiosk.order;

import java.util.Scanner;
import com.kiosk.util.Constants;

public class InputHandler {
    private final Scanner scanner = new Scanner(System.in);

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

    public int getQuantity() {
        while (true) {
            System.out.print(Constants.QUANTITY_PROMPT);
            if (scanner.hasNextInt()) {
                int quantity = scanner.nextInt();
                if (quantity >= 1 && quantity <= 10) {
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
