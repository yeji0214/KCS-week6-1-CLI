package com.kiosk.order;

import com.kiosk.menu.Side;
import com.kiosk.menu.side.PotatoPop;

public class SideOptionSelector {
    private final InputHandler inputHandler;

    public SideOptionSelector(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void selectSideOptions(Side side) {
        if (side.canChooseKetchup()) {
            boolean ketchup = inputHandler.getBooleanInput("케첩을 추가하시겠습니까? (1. X, 2. O): ");
            ((PotatoPop) side).setKetchup(ketchup);
            if (!ketchup) {
                String name = side.getName();
                if (!name.contains("(케첩 X)")) {
                    side.setName(name + " (케첩 X)");
                }
            }
        }
    }
}
