package com.kiosk.menu.drink;

public class CaffeineDrink extends Drink {
    private int caffeineContent; // milligrams

    public CaffeineDrink(String name, int price, int setPrice, int caffeineContent) {
        super(name, price, setPrice);
        this.caffeineContent = caffeineContent;
    }

    public int getCaffeineContent() {
        return caffeineContent;
    }
}
