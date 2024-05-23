package com.kiosk.order;

import com.kiosk.menu.MenuItem;
import com.kiosk.menu.toast.Toast;
import com.kiosk.menu.side.Side;
import com.kiosk.menu.drink.Drink;
import com.kiosk.menu.drink.*;
import com.kiosk.util.Constants;

import java.util.Dictionary;
import java.util.Objects;

// 메뉴 출력
public class MenuDisplayer {
    private final Toast[] toasts;
    private final Side[] sides;
    private final Drink[] drinks;

    // 생성자에서 모든 메뉴 객체 생성
    public MenuDisplayer() {
        toasts = new Toast[]{
                new Toast("감자 스페셜", 4700, false, true),
                new Toast("불고기 스페셜", 5200, true, false),
                new Toast("더블치즈 불고기", 5200, true, true),
                new Toast("치킨 스페셜", 4800, true, false),
                new Toast("핫 베이컨 치킨", 5900, false, true),
                new Toast("햄치즈", 3400, true, true),
                new Toast("프렌치 햄치즈", 3800, false, true),
                new Toast("햄스페셜", 3800, true, true),
                new Toast("베이컨 베스트", 4200, true, true),
                new Toast("그릴드 불고기", 4600, false, false),
                new Toast("그릴드 불갈비", 4900, false, true),
                new Toast("베이컨 포테이토 피자", 5400, false, false),
                new Toast("딥치즈 베이컨", 4500, false, false),
                new Toast("딥치즈 베이컨 포테이토", 5200, false, false),
                new Toast("햄치즈 포테이토", 4300, true, true),
                new Toast("허니갈릭 햄치즈", 3900, false, true),
                new Toast("콘치즈", 4600, false, true),
                new Toast("새우", 4900, false, false),
                new Toast("칠리새우", 4900, false, true)
        };

        sides = new Side[]{
                new Side("포테이토 팝", 2200, 0, true)
        };

        drinks = new Drink[]{
                new CaffeineDrink("아메리카노 hot", 2900, 800, 150),
                new CaffeineDrink("아메리카노 ice", 2900, 800, 150),
                new NonCaffeineDrink("아이스티", 2900, 800),
                new CaffeineDrink("콜라", 2000, 0, 35),
                new CaffeineDrink("콜라 제로", 2000, 0, 34),
                new NonCaffeineDrink("사이다", 2000, 0),
                new NonCaffeineDrink("사이다 제로", 2000, 0),
                new NonCaffeineDrink("오렌지 주스", 2600, 600)
        };
    }

    // 메인 메뉴 (카테고리) 보여주기
    public void showMainMenu() {
        String title = Constants.MAIN_MENU_TITLE;
        String categoryToast = Constants.CATEGORY_TOAST;
        String categorySide = Constants.CATEGORY_SIDE;
        String categoryDrink = Constants.CATEGORY_DRINK;

        System.out.println(Constants.BORDER);
        System.out.println(title);
        System.out.println();
        System.out.println(categoryToast);
        System.out.println(categorySide);
        System.out.println(categoryDrink);
        System.out.println();
    }

    // 토스트 메뉴 보여주기
    public void showToastMenu() {
        printMenu(Constants.TOAST_MENU_TITLE, toasts);
    }

    // 사이드 메뉴 보여주기
    public void showSideMenu() {
        printMenu(Constants.SIDE_MENU_TITLE, sides);
    }

    // 음료 메뉴 보여주기
    public void showDrinkMenu() {
        printMenu(Constants.DRINK_MENU_TITLE, drinks);
    }

    // 음료 카페인 함량 보여주기
    public void showDrinkCaffeine() {
        System.out.println(Constants.BORDER);
        System.out.println(Constants.DRINK_CAFFEINE_CONTENT_TITLE);
        System.out.println();
        for (int i = 0; i < drinks.length; i++) {
            if (drinks[i] instanceof CaffeineDrink) {
                System.out.println((i + 1) + ". " + drinks[i].getName() + " - " + ((CaffeineDrink) drinks[i]).getCaffeineContent() + "mg");
            }
            else {
                System.out.println((i + 1) + ". " + drinks[i].getName() + " - 0mg");
            }
        }

        System.out.println();
    }

    // 메뉴판 출력
    private void printMenu(String title, MenuItem[] menu) {
        System.out.println(Constants.BORDER);
        System.out.println(title);
        System.out.println();
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i].getName() + " - " + menu[i].getPrice() + "원");
        }
        if (Objects.equals(title, Constants.DRINK_MENU_TITLE)) {
            System.out.println(Constants.VIEW_CAFFEINE_CONTENT_OPTION);
        }
        System.out.println();
    }

    public Toast[] getToasts() {
        return toasts;
    }

    public Side[] getSides() {
        return sides;
    }

    public Drink[] getDrinks() {
        return drinks;
    }
}