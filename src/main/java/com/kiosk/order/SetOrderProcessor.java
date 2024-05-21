package com.kiosk.order;

import com.kiosk.menu.Drink;
import com.kiosk.menu.Side;
import com.kiosk.menu.Toast;
import com.kiosk.menu.drink.*;
import com.kiosk.menu.side.PotatoPop;

public class SetOrderProcessor {
    private Menu menu;
    private InputHandler inputHandler;
    private ToastOptionSelector toastOptionSelector;
    private Order order;

    public SetOrderProcessor(Menu menu, InputHandler inputHandler, ToastOptionSelector toastOptionSelector, Order order) {
        this.menu = menu;
        this.inputHandler = inputHandler;
        this.toastOptionSelector = toastOptionSelector;
        this.order = order;
    }

    public void processSetOrder(Toast toast) {
        int quantity = 0;
        int finalToastPrice = toast.getPrice() + 2700;
        boolean frenchBread = false;
        boolean scrambledEgg = false;
        String toastSetName = toast.getName() + " 세트";

        if (toast.canChooseBread()) {
            frenchBread = inputHandler.getBooleanInput("빵을 선택하세요 (1. 기본, 2. 프렌치빵(+500원)): ");
            if (frenchBread) {
                toastSetName += " (프렌치빵)";
                finalToastPrice += 500;
            }
        }

        if (toast.canChooseEgg()) {
            scrambledEgg = inputHandler.getBooleanInput("계란을 선택하세요 (1. 기본, 2. 스크램블(+600원)): ");
            if (scrambledEgg) {
                toastSetName += " (스크램블)";
                finalToastPrice += 600;
            }
        }

        Side[] sideMenu = { new PotatoPop(true) };
        System.out.println("사이드를 선택하세요:");
        for (int i = 0; i < sideMenu.length; i++) {
            System.out.println((i + 1) + ". " + sideMenu[i].getName() + " (+" + sideMenu[i].getSetPrice() + "원)");
        }

        Side side = null;
        while (true) {
            int choice = inputHandler.getIntInput("선택: ");
            if (choice >= 1 && choice <= sideMenu.length) {
                side = sideMenu[choice - 1];
                if (side.canChooseKetchup()) {
                    boolean ketchup = inputHandler.getBooleanInput("케첩을 추가하시겠습니까? (1. X, 2. O): ");
                    ((PotatoPop) side).setKetchup(ketchup);
                    if (!ketchup) toastSetName += " (케첩 X)";
                }
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
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
        System.out.println("음료를 선택하세요:");
        for (int i = 0; i < drinkMenu.length; i++) {
            System.out.println((i + 1) + ". " + drinkMenu[i].getName() + " (+" + drinkMenu[i].getSetPrice() + "원)");
        }

        Drink drink = null;
        while (true) {
            int choice = inputHandler.getIntInput("선택: ");
            if (choice >= 1 && choice <= drinkMenu.length) {
                drink = drinkMenu[choice - 1];
                if (drink.getName().contains("아메리카노") || drink.getName().contains("아이스티")) {
                    finalToastPrice += 800;
                } else if (drink.getName().contains("오렌지 주스")) {
                    finalToastPrice += 600;
                }
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
            }
        }

        toastSetName += " (" + drink.getName() + ")";
        quantity = inputHandler.getQuantity();
        int totalPrice = finalToastPrice * quantity;

        System.out.println(toastSetName + " - " + finalToastPrice + "원 x " + quantity + "개 = " + (totalPrice) + "원");
        System.out.println("1. 담기 2. 주문하기 3. 취소");

        while (true) {
            int choice = inputHandler.getIntInput("선택: ");
            switch (choice) {
                case 1:
                    menu.addItemToCart(toastSetName, finalToastPrice, quantity);
                    System.out.println(toastSetName + " " + quantity + "개가 장바구니에 담겼습니다.");
                    order.showMenu();
                    return;
                case 2:
                    menu.addItemToCart(toastSetName, finalToastPrice, quantity);
                    System.out.println(toastSetName + " " + quantity + "개가 장바구니에 담겼습니다.");
                    menu.showReceipt();
                    new PaymentProcessor(menu).processPayment(menu.getTotalPrice());
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
