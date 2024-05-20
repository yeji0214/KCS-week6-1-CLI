package com.kiosk.menu;

public abstract class Side extends MenuItem {
    public Side(String name, int price) {
        super(name, price, 1);
    }

    public boolean canChooseKetchup() {
        return false;
    }
}
