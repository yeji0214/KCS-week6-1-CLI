package com.kiosk.order;

import com.kiosk.menu.Drink;
import com.kiosk.menu.Side;
import com.kiosk.menu.Toast;
import com.kiosk.menu.drink.*;
import com.kiosk.menu.side.PotatoPop;
import com.kiosk.util.Constants;

// 세트 주문 프로세스 관리
public class SetOrderProcessor {
    private final Menu menu;
    private final InputHandler inputHandler;
    private final ToastOptionSelector toastOptionSelector;
    private final SideOptionSelector sideOptionSelector;
    private final PaymentProcessor paymentProcessor;
    private final Side[] sides;
    private final Drink[] drinks;
    private final Order order;

    public SetOrderProcessor(Menu menu, InputHandler inputHandler, ToastOptionSelector toastOptionSelector, SideOptionSelector sideOptionSelector, PaymentProcessor paymentProcessor, Side[] sides, Drink[] drinks, Order order) {
        this.menu = menu;
        this.inputHandler = inputHandler;
        this.toastOptionSelector = toastOptionSelector;
        this.sideOptionSelector = sideOptionSelector;
        this.paymentProcessor = paymentProcessor;
        this.sides = sides;
        this.drinks = drinks;
        this.order = order;
    }

    public void processSetOrder(Toast toast) {
        int quantity; // 수량
        int finalToastPrice; // 세트의 총 가격
        int totalPrice; // 최종 가격 (가격 * 수량)
        Side side = null; // 선택된 사이드
        Drink drink = null; // 선택된 음료

        String toastSetName = toast.getName() + Constants.SET_MENU; // 세트로 이름 변경
        toastOptionSelector.selectToastOptions(toast); // 토스트 빵이나 계란 옵션 선택

        finalToastPrice = toast.getPrice() + Constants.SET_PRICE; // 기본 세트 가격 더해주기

        // 사이드 메뉴 보여주기
        System.out.println(Constants.SELECT_SIDE_PROMPT);
        for (int i = 0; i < sides.length; i++) {
            System.out.println((i + 1) + ". " + sides[i].getName() + " (+" + sides[i].getSetPrice() + "원)");
        }

        // 사이드 선택 & 옵션 선택
        while (true) {
            int choice = inputHandler.getIntInput(Constants.SELECT_PROMPT);
            if (choice >= 1 && choice <= sides.length) {
                side = sides[choice - 1];
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

        // 음료 메뉴 보여주기
        System.out.println(Constants.SELECT_DRINK_PROMPT);
        for (int i = 0; i < drinks.length; i++) {
            System.out.println((i + 1) + ". " + drinks[i].getName() + " (+" + drinks[i].getSetPrice() + "원)");
        }

        // 음료 선택 & 추가 금액 적용
        while (true) {
            int choice = inputHandler.getIntInput(Constants.SELECT_PROMPT);
            if (choice >= 1 && choice <= drinks.length) {
                drink = drinks[choice - 1];
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

        toastSetName += " (" + drink.getName() + ")"; // 최종 메뉴 이름
        quantity = inputHandler.getQuantity(); // 수량
        totalPrice = finalToastPrice * quantity; // 최종 가격

        System.out.println(toastSetName + " - " + finalToastPrice + "원 x " + quantity + "개 = " + (totalPrice) + "원");
        System.out.println(Constants.CART_ACTIONS_PROMPT);

        menu.handleOrderOptions(toastSetName, finalToastPrice, quantity);
    }
}