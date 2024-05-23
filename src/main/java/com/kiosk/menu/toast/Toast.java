package com.kiosk.menu.toast;

import com.kiosk.menu.MenuItem;

public class Toast extends MenuItem {
    private boolean canChooseBread;
    private boolean canChooseEgg;

    public Toast(String name, int price, boolean canChooseBread, boolean canChooseEgg) {
        super(name, price, 1);
        this.canChooseBread = canChooseBread;
        this.canChooseEgg = canChooseEgg;
    }

    public boolean canChooseBread() {
        return canChooseBread;
    }

    public boolean canChooseEgg() {
        return canChooseEgg;
    }
}