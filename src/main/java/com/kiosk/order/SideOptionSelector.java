package com.kiosk.order;

import com.kiosk.menu.side.Side;
import com.kiosk.util.Constants;

// 사이드 옵션 선택 관리
public class SideOptionSelector {
    private final InputHandler inputHandler;

    // 생성자: 입력 핸들러 초기화
    public SideOptionSelector(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    // 사이드 옵션 선택
    public void selectSideOptions(Side side) {
        if (side.canChooseKetchup()) { // 케첩을 선택할 수 있는 경우
            boolean ketchup = inputHandler.getBooleanInput(Constants.KETCHUP_PROMPT);
            side.setKetchup(ketchup);
            if (!ketchup) {
                String name = side.getName();
                if (!name.contains(Constants.KETCHUP_EXCLUDED_SUFFIX)) {
                    side.setName(name + Constants.KETCHUP_EXCLUDED_SUFFIX);
                }
            }
        }
    }
}
