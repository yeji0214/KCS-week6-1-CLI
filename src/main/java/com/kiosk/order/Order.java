package com.kiosk.order;

import com.kiosk.util.Constants;

public class Order {
    private Menu menu;
    private InputHandler inputHandler;
    private ToastOrderProcessor toastOrderProcessor;
    private SideOrderProcessor sideOrderProcessor;
    private DrinkOrderProcessor drinkOrderProcessor;
    private PaymentProcessor paymentProcessor;

    public Order() {
        menu = new Menu();
        inputHandler = new InputHandler();
        ToastOptionSelector toastOptionSelector = new ToastOptionSelector(inputHandler);
        SideOptionSelector sideOptionSelector = new SideOptionSelector(inputHandler);
        paymentProcessor = new PaymentProcessor(menu);
        toastOrderProcessor = new ToastOrderProcessor(inputHandler, menu, toastOptionSelector, paymentProcessor, this);
        sideOrderProcessor = new SideOrderProcessor(inputHandler, menu, sideOptionSelector, paymentProcessor, this);
        drinkOrderProcessor = new DrinkOrderProcessor(inputHandler, menu, paymentProcessor, this);
    }

    public void start() {
        greeting();
        getUserInput();
    }

    private void greeting() {
        System.out.println(Constants.BORDER);
        System.out.println(Constants.STORE_NAME);
        System.out.println(Constants.BORDER);
        System.out.println(Constants.WELCOME_MESSAGE);
        System.out.println(Constants.PROMPT_MESSAGE);
        System.out.println();
        System.out.println(Constants.CHOICE1);
        System.out.println(Constants.CHOICE2);
        System.out.println();
    }

    private void getUserInput() {
        while (true) {
            int choice = inputHandler.getIntInput("선택: ");
            if (choice == 1) {
                showMenu();
                break;
            } else if (choice == 2) {
                System.out.println(Constants.THANK_YOU_MESSAGE);
                System.exit(0);
            } else {
                System.out.println(Constants.INPUT_ERROR);
            }
        }
    }

    public void showMenu() {
        MenuDisplayer menuDisplayer = new MenuDisplayer();
        menuDisplayer.showMainMenu();
        while (true) {
            int choice = inputHandler.getIntInput("주문할 카테고리의 번호를 입력하세요: ");
            if (choice == 1) {
                toastOrderProcessor.processToastOrder();
                break;
            } else if (choice == 2) {
                sideOrderProcessor.processSideOrder();
                break;
            } else if (choice == 3) {
                drinkOrderProcessor.processDrinkOrder();
                break;
            } else {
                System.out.println(Constants.INPUT_ERROR);
            }
        }
    }
}
