package com.kiosk.order;

import com.kiosk.menu.Toast;
import com.kiosk.util.Constants;

public class ToastOrderProcessor {
    private InputHandler inputHandler;
    private Menu menu;
    private ToastOptionSelector toastOptionSelector;
    private PaymentProcessor paymentProcessor;
    private Order order;

    public ToastOrderProcessor(InputHandler inputHandler, Menu menu, ToastOptionSelector toastOptionSelector, PaymentProcessor paymentProcessor, Order order) {
        this.inputHandler = inputHandler;
        this.menu = menu;
        this.toastOptionSelector = toastOptionSelector;
        this.paymentProcessor = paymentProcessor;
        this.order = order;
    }

    public void processToastOrder() {
        MenuDisplayer menuDisplayer = new MenuDisplayer();
        menuDisplayer.showToastMenu();
        Toast[] toastMenu = menuDisplayer.getToasts();

        while (true) {
            int choice = inputHandler.getIntInput("주문할 토스트의 번호를 입력하세요: ");
            if (choice >= 1 && choice <= toastMenu.length) {
                Toast selectedToast = toastMenu[choice - 1];
                System.out.println("\n" + selectedToast.getName() + " 토스트를 선택하셨습니다.");
                selectToastOption(selectedToast);
                return;
            } else {
                System.out.println(Constants.INPUT_ERROR);
            }
        }
    }

    private void processOrder(Toast toast) {
        toastOptionSelector.selectToastOptions(toast);
        int quantity = inputHandler.getQuantity();
        int finalPrice = toast.getPrice();

        int totalPrice = finalPrice * quantity;

        System.out.println(toast.getName() + " - " + finalPrice + "원 x " + quantity + "개 = " + (totalPrice) + "원");
        System.out.println("1. 담기 2. 주문하기 3. 취소");

        while (true) {
            int choice = inputHandler.getIntInput(Constants.SELECT_PROMPT);
            switch (choice) {
                case 1:
                    menu.addItemToCart(toast.getName(), finalPrice, quantity);
                    System.out.println(toast.getName() + " " + quantity + "개가 장바구니에 담겼습니다.");
                    order.showMenu();
                    return;
                case 2:
                    menu.addItemToCart(toast.getName(), finalPrice, quantity);
                    System.out.println(toast.getName() + " " + quantity + "개가 장바구니에 담겼습니다.");
                    menu.showReceipt();
                    paymentProcessor.processPayment(menu.getTotalPrice());
                    return;
                case 3:
                    order.showMenu();
                    return;
                default:
                    System.out.println(Constants.INPUT_ERROR);
            }
        }
    }

    private void selectToastOption(Toast toast) {
        while (true) {
            System.out.println(Constants.SET_MENU_PROMPT + toast.getPrice() + "원");
            System.out.println(Constants.SET_MENU_PROMPT2 + (toast.getPrice() + 2700) + "원");

            int choice = inputHandler.getIntInput(Constants.SELECT_PROMPT);
            if (choice == 1) {
                processOrder(toast);
                return;
            } else if (choice == 2) {
                System.out.println("\n" + toast.getName() + " 세트를 선택하셨습니다.");
                new SetOrderProcessor(menu, inputHandler, toastOptionSelector, order).processSetOrder(toast);
                return;
            } else {
                System.out.println(Constants.INPUT_ERROR);
            }
        }
    }
}
