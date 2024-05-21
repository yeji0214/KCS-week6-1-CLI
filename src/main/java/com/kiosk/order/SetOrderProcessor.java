package com.kiosk.order;

import com.kiosk.menu.Drink;
import com.kiosk.menu.Side;
import com.kiosk.menu.Toast;
import com.kiosk.menu.drink.*;
import com.kiosk.menu.side.PotatoPop;
import com.kiosk.util.Constants;

public class SetOrderProcessor {
    private final Menu menu;
    private final InputHandler inputHandler;
    private final ToastOptionSelector toastOptionSelector;
    private final SideOptionSelector sideOptionSelector;
    private final Order order;

    public SetOrderProcessor(Menu menu, InputHandler inputHandler, ToastOptionSelector toastOptionSelector, SideOptionSelector sideOptionSelector, Order order) {
        this.menu = menu;
        this.inputHandler = inputHandler;
        this.toastOptionSelector = toastOptionSelector;
        this.sideOptionSelector = sideOptionSelector;
        this.order = order;
    }

    public void processSetOrder(Toast toast) {
        int quantity = 0;
        String toastSetName = toast.getName() + Constants.SET_MENU;
        toastOptionSelector.selectToastOptions(toast);

        int finalToastPrice = toast.getPrice() + Constants.SET_PRICE;


        Side[] sideMenu = { new PotatoPop(true) };
        System.out.println(Constants.SELECT_SIDE_PROMPT);
        for (int i = 0; i < sideMenu.length; i++) {
            System.out.println((i + 1) + ". " + sideMenu[i].getName() + " (+" + sideMenu[i].getSetPrice() + "원)");
        }

        Side side = null;
        while (true) {
            int choice = inputHandler.getIntInput(Constants.SELECT_PROMPT);
            if (choice >= 1 && choice <= sideMenu.length) {
                side = sideMenu[choice - 1];
                if (side.canChooseKetchup()) {
                    boolean ketchup = inputHandler.getBooleanInput(Constants.KETCHUP_PROMPT);
                    ((PotatoPop) side).setKetchup(ketchup);
                    if (!ketchup) toastSetName += Constants.KETCHUP_EXCLUDED_SUFFIX;
                }
                break;
            } else {
                System.out.println(Constants.INPUT_ERROR);
            }
        }

        Drink[] drinkMenu = {
                new AmericanoHot(),
                new AmericanoIce(),
                new IcedTea(),
                new Cola(),
                new ColaZero(),
                new Sprite(),
                new SpriteZero(),
                new OrangeJuice()
        };
        System.out.println(Constants.SELECT_DRINK_PROMPT);
        for (int i = 0; i < drinkMenu.length; i++) {
            System.out.println((i + 1) + ". " + drinkMenu[i].getName() + " (+" + drinkMenu[i].getSetPrice() + "원)");
        }

        Drink drink = null;
        while (true) {
            int choice = inputHandler.getIntInput(Constants.SELECT_PROMPT);
            if (choice >= 1 && choice <= drinkMenu.length) {
                drink = drinkMenu[choice - 1];
                if (drink.getName().contains(Constants.AMERICANO) || drink.getName().contains(Constants.ICEDTEA)) {
                    finalToastPrice += Constants.AMERICANO_ICED_TEA_EXTRA_COST;
                } else if (drink.getName().contains(Constants.ORANGE_JUICE)) {
                    finalToastPrice += Constants.ORANGE_JUICE_EXTRA_COST;
                }
                break;
            } else {
                System.out.println(Constants.INPUT_ERROR);
            }
        }

        toastSetName += " (" + drink.getName() + ")";
        quantity = inputHandler.getQuantity();
        int totalPrice = finalToastPrice * quantity;

        System.out.println(toastSetName + " - " + finalToastPrice + "원 x " + quantity + "개 = " + (totalPrice) + "원");
        System.out.println(Constants.CART_ACTIONS_PROMPT);

        while (true) {
            int choice = inputHandler.getIntInput(Constants.SELECT_PROMPT);
            switch (choice) {
                case 1:
                    menu.addItemToCart(toastSetName, finalToastPrice, quantity);
                    System.out.println(toastSetName + " " + quantity + Constants.CART_MESSAGE);
                    order.showMenu();
                    return;
                case 2:
                    menu.addItemToCart(toastSetName, finalToastPrice, quantity);
                    System.out.println(toastSetName + " " + quantity + Constants.CART_MESSAGE);
                    menu.showReceipt();
                    new PaymentProcessor(menu).processPayment(menu.getTotalPrice());
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
