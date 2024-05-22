package com.kiosk.order;

import com.kiosk.menu.Toast;
import com.kiosk.util.Constants;

// 토스트 옵션 선택 관리
public class ToastOptionSelector {
    private final InputHandler inputHandler;

    public ToastOptionSelector(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void selectToastOptions(Toast toast) {
        if (toast.canChooseBread()) { // 프렌치빵으로 변경 가능한 토스트인 경우
            boolean frenchBread = inputHandler.getBooleanInput(Constants.BREAD_OPTION_PROMPT);
            if (frenchBread) {
                toast.setName(toast.getName() + Constants.FRENCH_BREAD_SUFFIX);
                toast.setPrice(toast.getPrice() + Constants.FRENCH_BREAD_EXTRA_COST);
            }
        }

        if (toast.canChooseEgg()) {
            boolean scrambledEgg = inputHandler.getBooleanInput(Constants.EGG_OPTION_PROMPT);
            if (scrambledEgg) { // 스크램블로 변경 가능한 토스트인 경우
                toast.setName(toast.getName() + Constants.SCRAMBLED_EGG_SUFFIX);
                toast.setPrice(toast.getPrice() + Constants.SCRAMBLED_EGG_EXTRA_COST);
            }
        }
    }
}
