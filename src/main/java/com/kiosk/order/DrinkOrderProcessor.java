package com.kiosk.order;

import com.kiosk.menu.drink.Drink;
import com.kiosk.util.Constants;

// 음료 주문 프로세스 관리
public class DrinkOrderProcessor {
    private final InputHandler inputHandler; // 사용자 입력을 처리하는 객체
    private final Menu menu; // 메뉴 객체

    // 생성자: 입력 핸들러와 메뉴 객체를 초기화
    public DrinkOrderProcessor(InputHandler inputHandler, Menu menu) {
        this.inputHandler = inputHandler;
        this.menu = menu;
    }

    // 음료 주문을 처리하는 메서드
    public void processDrinkOrder() {
        MenuDisplayer menuDisplayer = new MenuDisplayer(); // 메뉴 출력 객체 생성
        menuDisplayer.showDrinkMenu(); // 음료 메뉴 출력
        Drink[] drinkMenu = menuDisplayer.getDrinks(); // 음료 메뉴 배열 가져오기

        // 음료 선택 반복
        while (true) {
            int choice = inputHandler.getIntInput(Constants.DRINK_PROMPT);
            if (choice == 0) {
                // 카페인 함량 표 보여주기
                menuDisplayer.showDrinkCaffeine();
            }
            else if (choice >= 1 && choice <= drinkMenu.length) {
                Drink selectedDrink = drinkMenu[choice - 1]; // 선택된 음료
                System.out.println("\n" + selectedDrink.getName() + Constants.DRINK_SELECT_MESSAGE);
                processOrder(selectedDrink); // 음료 주문 처리
                return;
            } else {
                System.out.println(Constants.INPUT_ERROR); // 잘못된 입력 처리
            }
        }
    }

    // 실제 주문을 처리하는 메서드
    private void processOrder(Drink drink) {
        int quantity = inputHandler.getQuantity(); // 수량 입력 받기
        System.out.println("\n" + drink.getName() + " - " + drink.getPrice() + "원 x " + quantity + "개 = " + (drink.getPrice() * quantity) + "원");
        System.out.println(Constants.CART_ACTIONS_PROMPT);

        // 메뉴에 주문 항목 추가
        menu.handleOrderOptions(drink.getName(), drink.getPrice(), quantity);
    }
}