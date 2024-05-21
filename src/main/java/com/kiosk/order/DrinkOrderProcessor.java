package com.kiosk.order;

import com.kiosk.menu.Drink;
import com.kiosk.util.Constants;

public class DrinkOrderProcessor {
    private InputHandler inputHandler;
    private Menu menu;
    private PaymentProcessor paymentProcessor;
    private Order order;

    public DrinkOrderProcessor(InputHandler inputHandler, Menu menu, PaymentProcessor paymentProcessor, Order order) {
        this.inputHandler = inputHandler;
        this.menu = menu;
        this.paymentProcessor = paymentProcessor;
        this.order = order;
    }

    public void processDrinkOrder() {
        MenuDisplayer menuDisplayer = new MenuDisplayer();
        menuDisplayer.showDrinkMenu();
        Drink[] drinkMenu = menuDisplayer.getDrinks();

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

        while (true) {
            int choice = inputHandler.getIntInput(Constants.SELECT_PROMPT);
            switch (choice) {
                case 1:
                    menu.addItemToCart(drink.getName(), drink.getPrice(), quantity);
                    System.out.println(drink.getName() + " " + quantity + Constants.CART_MESSAGE);
                    order.showMenu();
                    return;
                case 2:
                    menu.addItemToCart(drink.getName(), drink.getPrice(), quantity);
                    System.out.println(drink.getName() + " " + quantity + Constants.CART_MESSAGE);
                    menu.showReceipt();
                    paymentProcessor.processPayment(menu.getTotalPrice());
                    return;
                case 3:
                    order.showMenu();
                    return;
                default:
                    System.out.println(Constants.INPUT_ERROR);
            }
        }
    }
}
