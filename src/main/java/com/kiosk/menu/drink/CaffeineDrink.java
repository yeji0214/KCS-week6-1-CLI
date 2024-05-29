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

    public String caffeineWarning() {
        if (caffeineContent > 100) {
            return " (주의: 고카페인 함량!)";
        }
        return "";
    }
}
