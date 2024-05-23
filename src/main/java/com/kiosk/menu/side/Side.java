package com.kiosk.menu.side;

import com.kiosk.menu.MenuItem;

public class Side extends MenuItem {
    private int setPrice;
    private boolean ketchup; // PotatoPop의 속성 추가

    public Side(String name, int price, int setPrice) {
        super(name, price, 1);
        this.setPrice = setPrice;
    }

    // 새로운 생성자 추가 (PotatoPop에서 사용한 생성자)
    public Side(String name, int price, int setPrice, boolean ketchup) {
        super(name, price, 1);
        this.setPrice = setPrice;
        this.ketchup = ketchup;
    }

    public boolean canChooseKetchup() {
        return true; // 기본적으로 케첩 선택 가능
    }

    public int getSetPrice() {
        return setPrice;
    }

    public boolean hasKetchup() {
        return ketchup;
    }

    @Override
    public String getName() {
        return super.getName() + (ketchup ? "" : " (케첩 X)");
    }

    public void setKetchup(boolean ketchup) {
        this.ketchup = ketchup;
    }
}
