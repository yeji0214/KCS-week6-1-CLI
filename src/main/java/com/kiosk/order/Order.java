package com.kiosk.order;

import com.kiosk.util.Constants;

// 전반적 주문 프로세스 관리
public class Order {
    private Menu menu;
    private InputHandler inputHandler;
    private ToastOrderProcessor toastOrderProcessor;
    private ToastOptionSelector toastOptionSelector;
    private SideOrderProcessor sideOrderProcessor;
    private SideOptionSelector sideOptionSelector;
    private DrinkOrderProcessor drinkOrderProcessor;
    private PaymentProcessor paymentProcessor;

    public Order() {
        menu = new Menu();
        inputHandler = new InputHandler();
        toastOptionSelector = new ToastOptionSelector(inputHandler);
        sideOptionSelector = new SideOptionSelector(inputHandler);
        paymentProcessor = new PaymentProcessor(menu, inputHandler);
        toastOrderProcessor = new ToastOrderProcessor(inputHandler, menu, toastOptionSelector, paymentProcessor, this);
        sideOrderProcessor = new SideOrderProcessor(inputHandler, menu, sideOptionSelector, paymentProcessor, this);
        drinkOrderProcessor = new DrinkOrderProcessor(inputHandler, menu, paymentProcessor, this);
    }

    public void start() {
        greeting();
        getUserInput();
    }

    // 인사말
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

    // 주문 여부 입력받기
    private void getUserInput() {
        while (true) {
            int choice = inputHandler.getIntInput(Constants.SELECT_PROMPT);
            if (choice == 1) { // 주문하는 경우
                showMenu(); // 메뉴판 보여주기
                break;
            } else if (choice == 2) { // 주문하지 않는 경우
                System.out.println(Constants.THANK_YOU_MESSAGE);
                System.exit(0);
            } else {
                System.out.println(Constants.INPUT_ERROR);
            }
        }
    }

    public void showMenu() {
        MenuDisplayer menuDisplayer = new MenuDisplayer();
        menuDisplayer.showMainMenu(); // 메뉴 카테고리 보여주기
        while (true) {
            int choice = inputHandler.getIntInput(Constants.MENU_PROMPT);
            if (choice == 1) { // 토스트 선택
                toastOrderProcessor.processToastOrder();
                break;
            } else if (choice == 2) { // 사이드 선택
                sideOrderProcessor.processSideOrder();
                break;
            } else if (choice == 3) { // 음료 선택
                drinkOrderProcessor.processDrinkOrder();
                break;
            } else {
                System.out.println(Constants.INPUT_ERROR);
            }
        }
    }
}