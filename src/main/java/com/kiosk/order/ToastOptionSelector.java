package com.kiosk.order;

import com.kiosk.menu.Toast;

public class ToastOptionSelector {
    private final InputHandler inputHandler = new InputHandler();

    public void selectToastOptions(Toast toast) {
        if (toast.canChooseBread()) {
            boolean frenchBread = inputHandler.getBooleanInput("빵을 선택하세요 (1. 기본, 2. 프렌치빵(+500원)): ");
            if (frenchBread) {
                toast.setName(toast.getName() + " (프렌치빵)");
                toast.setPrice(toast.getPrice() + 500);
            }
        }

        if (toast.canChooseEgg()) {
            boolean scrambledEgg = inputHandler.getBooleanInput("계란을 선택하세요 (1. 기본, 2. 스크램블(+600원)): ");
            if (scrambledEgg) {
                toast.setName(toast.getName() + " (스크램블)");
                toast.setPrice(toast.getPrice() + 600);
            }
        }
    }
}
