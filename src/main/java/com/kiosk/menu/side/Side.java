package com.kiosk.menu.side;

import com.kiosk.menu.MenuItem;

public class Side extends MenuItem {
    private int setPrice;
    private boolean canChooseKetchup;
    private boolean ketchup; // PotatoPop의 속성 추가

//    public Side(String name, int price, int setPrice) {
//        super(name, price, 1);
//        this.setPrice = setPrice;
//    }

    // 새로운 생성자 추가 (PotatoPop에서 사용한 생성자)
    public Side(String name, int price, int setPrice, boolean canChooseKetchup) {
        super(name, price, 1);
        this.setPrice = setPrice;
        this.canChooseKetchup = canChooseKetchup;
        this.ketchup = this.canChooseKetchup;
    }

    public boolean canChooseKetchup() {
        return canChooseKetchup;
    }

    public int getSetPrice() {
        return setPrice;
    }

    @Override
    public String getName() {
        return super.getName() + (ketchup ? "" : " (케첩 X)");
    }

    public void setKetchup(boolean ketchup) {
        this.ketchup = ketchup;
    }
}
