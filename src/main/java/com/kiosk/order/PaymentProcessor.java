package com.kiosk.order;

import java.util.Scanner;
import com.kiosk.util.Constants;

// 결제 프로세스 관리
public class PaymentProcessor {
    private final InputHandler inputHandler;

    // 생성자: 입력 핸들러 초기화
    public PaymentProcessor(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    // 결제 처리
    public void processPayment(int totalPrice) {
        int paymentChoice = 0; // 결제 방식 (0: 나눠서 결제 1: 한번에 결제)
        int amountPaid = 0; // 지불한 금액

        Scanner scanner = new Scanner(System.in);
        System.out.println(Constants.PAYMENT_PROMPT);
        System.out.println(Constants.PAYMENT_OPTION1);
        System.out.println(Constants.PAYMENT_OPTION2);

        // 결제 방식 입력받기
        boolean paymentMethod = inputHandler.getBooleanInput(Constants.SELECT_PROMPT);

        if (!paymentMethod) {
            paymentChoice = 1;
        }

        switch (paymentChoice) {
            case 0: // 나눠서 결제
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
            case 1: // 한번에 결제
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
        }

        int change = amountPaid - totalPrice;
        if (change > 0) {
            System.out.println(Constants.CHANGE_MESSAGE + change + "원");
        }
        System.out.println("\n" + Constants.PAYMENT_COMPLETE);
    }
}