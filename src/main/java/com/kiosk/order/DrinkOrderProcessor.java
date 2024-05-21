package com.kiosk.order;

import com.kiosk.menu.Drink;
import com.kiosk.menu.Side;
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
            int choice = inputHandler.getIntInput("주문할 음료의 번호를 입력하세요: ");
            if (choice >= 1 && choice <= drinkMenu.length) {
                Drink selectedDrink = drinkMenu[choice - 1];
                System.out.println("\n" + selectedDrink.getName() + " 음료를 선택하셨습니다.");
                processOrder(selectedDrink);
                return;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
            }
        }
    }

    private void processOrder(Drink drink) {
        int quantity = inputHandler.getQuantity();
        System.out.println(drink.getName() + " - " + drink.getPrice() + "원 x " + quantity + "개 = " + (drink.getPrice() * quantity) + "원");
        System.out.println("1. 담기 2. 주문하기 3. 취소");

        while (true) {
            int choice = inputHandler.getIntInput("선택: ");
            switch (choice) {
                case 1:
                    menu.addItemToCart(drink.getName(), drink.getPrice(), quantity);
                    System.out.println(drink.getName() + " " + quantity + "개가 장바구니에 담겼습니다.");
                    order.showMenu();
                    return;
                case 2:
                    menu.addItemToCart(drink.getName(), drink.getPrice(), quantity);
                    System.out.println(drink.getName() + " " + quantity + "개가 장바구니에 담겼습니다.");
                    menu.showReceipt();
                    paymentProcessor.processPayment(menu.getTotalPrice());
                    return;
                case 3:
                    order.showMenu();
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
            }
        }
    }
}
