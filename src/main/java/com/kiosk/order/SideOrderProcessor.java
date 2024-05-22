package com.kiosk.order;

import com.kiosk.menu.Side;
import com.kiosk.util.Constants;

public class SideOrderProcessor {
    private InputHandler inputHandler;
    private Menu menu;
    private SideOptionSelector sideOptionSelector;
    private PaymentProcessor paymentProcessor;
    private Order order;

    public SideOrderProcessor(InputHandler inputHandler, Menu menu, SideOptionSelector sideOptionSelector, PaymentProcessor paymentProcessor, Order order) {
        this.inputHandler = inputHandler;
        this.menu = menu;
        this.sideOptionSelector = sideOptionSelector;
        this.paymentProcessor = paymentProcessor;
        this.order = order;
    }

    public void processSideOrder() {
        MenuDisplayer menuDisplayer = new MenuDisplayer();
        menuDisplayer.showSideMenu();
        Side[] sideMenu = menuDisplayer.getSides();

        while (true) {
            int choice = inputHandler.getIntInput(Constants.SIDE_PROMPT);
            if (choice >= 1 && choice <= sideMenu.length) {
                Side selectedSide = sideMenu[choice - 1];
                System.out.println("\n" + selectedSide.getName() + Constants.SIDE_SELECT_MESSAGE);
                new SideOptionSelector(inputHandler).selectSideOptions(selectedSide);
                processOrder(selectedSide);
                return;
            } else {
                System.out.println(Constants.INPUT_ERROR);
            }
        }
    }

    private void processOrder(Side side) {
        int quantity = inputHandler.getQuantity();
        System.out.println(side.getName() + " - " + side.getPrice() + "원 x " + quantity + "개 = " + (side.getPrice() * quantity) + "원");
        System.out.println(Constants.CART_ACTIONS_PROMPT);

        menu.handleOrderOptions(side.getName(), side.getPrice(), quantity);
    }
}
