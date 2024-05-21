package com.kiosk.order;

import com.kiosk.menu.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<MenuItem> cart = new ArrayList<>();
    private int totalPrice = 0;

    public void addItemToCart(String name, int price, int quantity) {
        cart.add(new MenuItem(name, price, quantity));
        totalPrice += price * quantity;
    }

    public void showReceipt() {
        System.out.println("영수증:");
        for (MenuItem item : cart) {
            System.out.println(item.getName() + " - " + item.getPrice() + "원 x " + item.getQuantity() + "개 = " + (item.getPrice() * item.getQuantity()) + "원");
        }
        System.out.println("총 금액: " + totalPrice + "원");
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}