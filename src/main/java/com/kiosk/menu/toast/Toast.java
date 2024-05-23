package com.kiosk.menu.toast;

import com.kiosk.menu.MenuItem;
import java.util.List;

public class Toast extends MenuItem {
    private boolean canChooseBread;
    private boolean canChooseEgg;
    private List<String> ingredients;

    public Toast(String name, int price, boolean canChooseBread, boolean canChooseEgg, List<String> ingredients) {
        super(name, price, 1);
        this.canChooseBread = canChooseBread;
        this.canChooseEgg = canChooseEgg;
        this.ingredients = ingredients;
    }

    public boolean canChooseBread() {
        return canChooseBread;
    }

    public boolean canChooseEgg() {
        return canChooseEgg;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
}
