package com.kiosk.menu;

public abstract class Side extends MenuItem {
    private int setPrice;

    public Side(String name, int price, int setPrice) {
        super(name, price, 1);
        this.setPrice = setPrice;
    }

    public boolean canChooseKetchup() {
        return false;
    }

    public int getSetPrice() {
        return setPrice;
    }
}
