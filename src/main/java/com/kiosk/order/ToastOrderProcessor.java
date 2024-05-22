package com.kiosk.order;

import com.kiosk.menu.Toast;
import com.kiosk.util.Constants;

// 토스트 주문 프로세스 관리
public class ToastOrderProcessor {
    private InputHandler inputHandler;
    private Menu menu;
    private ToastOptionSelector toastOptionSelector;
    private SetOrderProcessor setOrderProcessor;

    public ToastOrderProcessor(InputHandler inputHandler, Menu menu, ToastOptionSelector toastOptionSelector, MenuDisplayer menuDisplayer) {
        this.inputHandler = inputHandler;
        this.menu = menu;
        this.toastOptionSelector = toastOptionSelector;
        this.setOrderProcessor = new SetOrderProcessor(menu, inputHandler, toastOptionSelector, menuDisplayer.getSides(), menuDisplayer.getDrinks());
    }

    public void processToastOrder() {
        MenuDisplayer menuDisplayer = new MenuDisplayer();
        menuDisplayer.showToastMenu();
        Toast[] toastMenu = menuDisplayer.getToasts();

        // 토스트 선택
        while (true) {
            int choice = inputHandler.getIntInput(Constants.TOAST_PROMPT);
            if (choice >= 1 && choice <= toastMenu.length) {
                Toast selectedToast = toastMenu[choice - 1];
                System.out.println("\n" + selectedToast.getName() + Constants.TOAST_SELECT_MESSAGE);
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
        System.out.println(Constants.CART_ACTIONS_PROMPT);

        menu.handleOrderOptions(toast.getName(), finalPrice, quantity);
    }

    // 단품 / 세트 선택
    private void selectToastOption(Toast toast) {
        while (true) {
            System.out.println(Constants.SET_MENU_PROMPT + toast.getPrice() + "원");
            System.out.println(Constants.SET_MENU_PROMPT2 + (toast.getPrice() + Constants.SET_PRICE) + "원");

            int choice = inputHandler.getIntInput(Constants.SELECT_PROMPT);
            if (choice == 1) { // 단품
                processOrder(toast);
                return;
            } else if (choice == 2) { // 세트
                System.out.println("\n" + toast.getName() + Constants.SET_SELECT_MESSAGE);
                setOrderProcessor.processSetOrder(toast);
                return;
            } else {
                System.out.println(Constants.INPUT_ERROR);
            }
        }
    }
}
