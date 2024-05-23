package com.kiosk.order;

import com.kiosk.menu.side.Side;
import com.kiosk.util.Constants;

// 사이드 주문 프로세스 관리
public class SideOrderProcessor {
    private final InputHandler inputHandler;
    private final Menu menu;

    public SideOrderProcessor(InputHandler inputHandler, Menu menu) {
        this.inputHandler = inputHandler;
        this.menu = menu;
    }

    public void processSideOrder() {
        MenuDisplayer menuDisplayer = new MenuDisplayer();
        menuDisplayer.showSideMenu();
        Side[] sideMenu = menuDisplayer.getSides();

        // 사이드 선택
        while (true) {
            int choice = inputHandler.getIntInput(Constants.SIDE_PROMPT);
            if (choice >= 1 && choice <= sideMenu.length) {
                Side selectedSide = sideMenu[choice - 1];
                System.out.println("\n" + selectedSide.getName() + Constants.SIDE_SELECT_MESSAGE + "\n");
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
        System.out.println("\n" + side.getName() + " - " + side.getPrice() + "원 x " + quantity + "개 = " + (side.getPrice() * quantity) + "원");
        System.out.println(Constants.CART_ACTIONS_PROMPT);

        menu.handleOrderOptions(side.getName(), side.getPrice(), quantity);
    }
}
