package com.kiosk.order;

import java.util.Scanner;

public class PaymentProcessor {
    private final Menu menu;

    public PaymentProcessor(Menu menu) {
        this.menu = menu;
    }

    public void processPayment(int totalPrice) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("결제 방식을 선택하세요:");
        System.out.println("1. 한번에 결제");
        System.out.println("2. 나눠서 결제");

        int paymentChoice = 0;
        while (true) {
            System.out.print("선택: ");
            if (scanner.hasNextInt()) {
                paymentChoice = scanner.nextInt();
                if (paymentChoice == 1 || paymentChoice == 2) {
                    break;
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                scanner.next(); // 잘못된 입력을 소비하고 넘어갑니다.
            }
        }

        int amountPaid = 0;
        switch (paymentChoice) {
            case 1:
                while (amountPaid < totalPrice) {
                    System.out.print("금액을 투입하세요: ");
                    if (scanner.hasNextInt()) {
                        amountPaid = scanner.nextInt();
                        if (amountPaid < totalPrice) {
                            System.out.println("투입 금액이 부족합니다.");
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                        scanner.next(); // 잘못된 입력을 소비하고 넘어갑니다.
                    }
                }
                break;
            case 2:
                while (amountPaid < totalPrice) {
                    System.out.print("금액을 투입하세요: ");
                    if (scanner.hasNextInt()) {
                        int partialPayment = scanner.nextInt();
                        amountPaid += partialPayment;
                        if (amountPaid < totalPrice) {
                            System.out.println("남은 금액: " + (totalPrice - amountPaid) + "원");
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                        scanner.next(); // 잘못된 입력을 소비하고 넘어갑니다.
                    }
                }
                break;
        }

        int change = amountPaid - totalPrice;
        if (change > 0) {
            System.out.println("거스름돈: " + change + "원");
        }
        System.out.println("결제가 완료되었습니다. 감사합니다!");
    }
}
