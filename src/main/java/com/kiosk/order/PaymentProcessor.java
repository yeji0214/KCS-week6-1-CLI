package com.kiosk.order;

import java.util.Scanner;
import com.kiosk.util.Constants;

public class PaymentProcessor {
    private final Menu menu;

    public PaymentProcessor(Menu menu) {
        this.menu = menu;
    }

    public void processPayment(int totalPrice) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Constants.PAYMENT_PROMPT);
        System.out.println(Constants.PAYMENT_OPTION1);
        System.out.println(Constants.PAYMENT_OPTION2);

        int paymentChoice = 0;
        while (true) {
            System.out.print(Constants.SELECT_PROMPT);
            if (scanner.hasNextInt()) {
                paymentChoice = scanner.nextInt();
                if (paymentChoice == 1 || paymentChoice == 2) {
                    break;
                } else {
                    System.out.println(Constants.INPUT_ERROR);
                }
            } else {
                System.out.println(Constants.INPUT_ERROR);
                scanner.next();
            }
        }

        int amountPaid = 0;
        switch (paymentChoice) {
            case 1:
                while (amountPaid < totalPrice) {
                    System.out.print(Constants.ENTER_AMOUNT_PROMPT);
                    if (scanner.hasNextInt()) {
                        amountPaid = scanner.nextInt();
                        if (amountPaid < totalPrice) {
                            System.out.println(Constants.PAYMENT_ERROR);
                        } else {
                            break;
                        }
                    } else {
                        System.out.println(Constants.INPUT_ERROR);
                        scanner.next();
                    }
                }
                break;
            case 2:
                while (amountPaid < totalPrice) {
                    System.out.print(Constants.ENTER_AMOUNT_PROMPT);
                    if (scanner.hasNextInt()) {
                        int partialPayment = scanner.nextInt();
                        amountPaid += partialPayment;
                        if (amountPaid < totalPrice) {
                            System.out.println(Constants.REMAINING_AMOUNT + (totalPrice - amountPaid) + "원");
                        } else {
                            break;
                        }
                    } else {
                        System.out.println(Constants.INPUT_ERROR);
                        scanner.next();
                    }
                }
                break;
        }

        int change = amountPaid - totalPrice;
        if (change > 0) {
            System.out.println(Constants.CHANGE_MESSAGE + change + "원");
        }
        System.out.println(Constants.PAYMENT_COMPLETE);
    }
}
