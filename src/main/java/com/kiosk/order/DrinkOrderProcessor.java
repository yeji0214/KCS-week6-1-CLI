package com.kiosk.order;

import com.kiosk.menu.Drink;
import com.kiosk.util.Constants;

// 음료 주문 프로세스 관리
public class DrinkOrderProcessor {
    private InputHandler inputHandler;
    private Menu menu;

    public DrinkOrderProcessor(InputHandler inputHandler, Menu menu) {
        this.inputHandler = inputHandler;
        this.menu = menu;
    }

    public void processDrinkOrder() {
        MenuDisplayer menuDisplayer = new MenuDisplayer();
        menuDisplayer.showDrinkMenu();
        Drink[] drinkMenu = menuDisplayer.getDrinks();

        // 음료 선택
        while (true) {
            int choice = inputHandler.getIntInput(Constants.DRINK_PROMPT);
            if (choice >= 1 && choice <= drinkMenu.length) {
                Drink selectedDrink = drinkMenu[choice - 1];
                System.out.println("\n" + selectedDrink.getName() + Constants.DRINK_SELECT_MESSAGE);
                processOrder(selectedDrink);
                return;
            } else {
                System.out.println(Constants.INPUT_ERROR);
            }
        }
    }

    private void processOrder(Drink drink) {
        int quantity = inputHandler.getQuantity();
        System.out.println(drink.getName() + " - " + drink.getPrice() + "원 x " + quantity + "개 = " + (drink.getPrice() * quantity) + "원");
        System.out.println(Constants.CART_ACTIONS_PROMPT);

        menu.handleOrderOptions(drink.getName(), drink.getPrice(), quantity);
    }
}
