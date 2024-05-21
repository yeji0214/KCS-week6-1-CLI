package com.kiosk.order;

import com.kiosk.menu.Side;
import com.kiosk.menu.side.PotatoPop;
import com.kiosk.util.Constants;

public class SideOptionSelector {
    private final InputHandler inputHandler;

    public SideOptionSelector(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void selectSideOptions(Side side) {
        if (side.canChooseKetchup()) {
            boolean ketchup = inputHandler.getBooleanInput(Constants.KETCHUP_PROMPT);
            ((PotatoPop) side).setKetchup(ketchup);
            if (!ketchup) {
                String name = side.getName();
                if (!name.contains(Constants.KETCHUP_EXCLUDED_SUFFIX)) {
                    side.setName(name + Constants.KETCHUP_EXCLUDED_SUFFIX);
                }
            }
        }
    }
}
