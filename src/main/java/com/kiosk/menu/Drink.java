package com.kiosk.menu;

public abstract class Drink extends MenuItem {
    private int setPrice;

    public Drink(String name, int price, int setPrice) {
        super(name, price, 1);
        this.setPrice = setPrice;
    }

    public int getSetPrice() {
        return setPrice;
    }
}
