package com.kiosk.order;

import com.kiosk.menu.MenuItem;
import java.util.ArrayList;
import java.util.List;
import com.kiosk.util.Constants;

// 메뉴 항목 관리 (장바구니, 영수증, 총 가격)
public class Menu {
    private final List<MenuItem> cart = new ArrayList<>();
    private final InputHandler inputHandler;
    private final PaymentProcessor paymentProcessor;
    private final Order order;
    private int totalPrice = 0;

    public Menu(InputHandler inputHandler, PaymentProcessor paymentProcessor, Order order) {
        this.inputHandler = inputHandler;
        this.paymentProcessor = paymentProcessor;
        this.order = order;
    }

    public void addItemToCart(String name, int price, int quantity) {
        cart.add(new MenuItem(name, price, quantity));
        totalPrice += price * quantity;
    }

    public void showReceipt() {
        System.out.println(Constants.BORDER);
        System.out.println(Constants.RECEIPT_TITLE);
        for (MenuItem item : cart) {
            System.out.println(item.getName() + " - " + item.getPrice() + "원 x " + item.getQuantity() + "개 = " + (item.getPrice() * item.getQuantity()) + "원");
        }
        System.out.println(Constants.TOTAL_AMOUNT + totalPrice + "원");
    }

    public void handleOrderOptions(String name, int price, int quantity) {
        while (true) {
            int choice = inputHandler.getIntInput(Constants.SELECT_PROMPT);
            switch (choice) {
                case 1:
                    addItemToCart(name, price, quantity);
                    System.out.println(name + " " + quantity + Constants.CART_MESSAGE);
                    order.showMenu();
                    return;
                case 2:
                    addItemToCart(name, price, quantity);
                    System.out.println(name + " " + quantity + Constants.CART_MESSAGE);
                    showReceipt();
                    paymentProcessor.processPayment(getTotalPrice());
                    return;
                case 3:
                    order.showMenu();
                    return;
                default:
                    System.out.println(Constants.INPUT_ERROR);
            }
        }
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}