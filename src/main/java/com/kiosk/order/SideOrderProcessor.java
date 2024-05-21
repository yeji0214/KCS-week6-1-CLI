package com.kiosk.order;

import com.kiosk.menu.Side;
import com.kiosk.menu.Toast;
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
            int choice = inputHandler.getIntInput("주문할 사이드의 번호를 입력하세요: ");
            if (choice >= 1 && choice <= sideMenu.length) {
                Side selectedSide = sideMenu[choice - 1];
                System.out.println("\n" + selectedSide.getName() + " 사이드를 선택하셨습니다.");
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
        System.out.println("1. 담기 2. 주문하기 3. 취소");

        while (true) {
            int choice = inputHandler.getIntInput("선택: ");
            switch (choice) {
                case 1:
                    menu.addItemToCart(side.getName(), side.getPrice(), quantity);
                    System.out.println(side.getName() + " " + quantity + "개가 장바구니에 담겼습니다.");
                    order.showMenu();
                    return;
                case 2:
                    menu.addItemToCart(side.getName(), side.getPrice(), quantity);
                    System.out.println(side.getName() + " " + quantity + "개가 장바구니에 담겼습니다.");
                    menu.showReceipt();
                    paymentProcessor.processPayment(menu.getTotalPrice());
                    return;
                case 3:
                    order.showMenu();
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
            }
        }
    }
}
