package com.kiosk.order;

import com.kiosk.menu.toast.Toast;
import com.kiosk.util.Constants;

// 토스트 주문 프로세스 관리
public class ToastOrderProcessor {
    private final InputHandler inputHandler;
    private final Menu menu;
    private final ToastOptionSelector toastOptionSelector;
    private final SetOrderProcessor setOrderProcessor;
    private final MenuDisplayer menuDisplayer;

    // 생성자: 필요한 객체들을 초기화
    public ToastOrderProcessor(InputHandler inputHandler, Menu menu, ToastOptionSelector toastOptionSelector, MenuDisplayer menuDisplayer) {
        this.inputHandler = inputHandler;
        this.menu = menu;
        this.toastOptionSelector = toastOptionSelector;
        this.menuDisplayer = menuDisplayer;
        this.setOrderProcessor = new SetOrderProcessor(menu, inputHandler, toastOptionSelector, menuDisplayer, menuDisplayer.getSides(), menuDisplayer.getDrinks());
    }

    // 토스트 주문 처리
    public void processToastOrder() {
        menuDisplayer.showToastMenu();
        Toast[] toastMenu = menuDisplayer.getToasts();

        // 토스트 선택
        while (true) {
            int choice = inputHandler.getIntInput(Constants.TOAST_PROMPT);
            if (choice == 0) {
                menuDisplayer.showToastIngredients();
            }
            else if (choice >= 1 && choice <= toastMenu.length) {
                Toast selectedToast = toastMenu[choice - 1];
                System.out.println("\n" + selectedToast.getName() + Constants.TOAST_SELECT_MESSAGE + "\n");
                selectToastOption(selectedToast);
                return;
            } else {
                System.out.println(Constants.INPUT_ERROR);
            }
        }
    }

    // 실제 주문을 처리하는 메서드
    private void processOrder(Toast toast) {
        toastOptionSelector.selectToastOptions(toast);
        int quantity = inputHandler.getQuantity();
        int finalPrice = toast.getPrice();

        int totalPrice = finalPrice * quantity;

        System.out.println("\n" + toast.getName() + " - " + finalPrice + "원 x " + quantity + "개 = " + (totalPrice) + "원");
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
                System.out.println("\n" + toast.getName() + Constants.SET_SELECT_MESSAGE + "\n");
                setOrderProcessor.processSetOrder(toast);
                return;
            } else {
                System.out.println(Constants.INPUT_ERROR);
            }
        }
    }
}
