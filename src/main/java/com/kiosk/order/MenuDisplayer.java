package com.kiosk.order;

import com.kiosk.menu.MenuItem;
import com.kiosk.menu.Toast;
import com.kiosk.menu.Side;
import com.kiosk.menu.Drink;
import com.kiosk.menu.drink.*;
import com.kiosk.menu.side.PotatoPop;
import com.kiosk.menu.toast.*;
import com.kiosk.util.Constants;

// 메뉴 출력
public class MenuDisplayer {
    private Toast[] toasts;
    private Side[] sides;
    private Drink[] drinks;

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
        toasts = new Toast[]{
                new PotatoSpecialToast(),
                new BulgogiSpecialToast(),
                new DoubleCheeseBulgogiToast(),
                new ChickenSpecialToast(),
                new HotBaconChickenToast(),
                new HamCheeseToast(),
                new FrenchHamCheeseToast(),
                new HamSpecialToast(),
                new BaconBestToast(),
                new GrilledBulgogiToast(),
                new GrilledBulgalbiToast(),
                new BaconPotatoPizzaToast(),
                new DeepCheeseBaconToast(),
                new DeepCheeseBaconPotatoToast(),
                new HamCheesePotatoToast(),
                new HoneyGarlicHamCheeseToast(),
                new CornCheeseToast(),
                new ShrimpToast(),
                new ChiliShrimpToast()
        };
        printMenu(Constants.TOAST_MENU_TITLE, toasts);
    }

    // 사이드 메뉴 보여주기
    public void showSideMenu() {
        sides = new Side[]{
                new PotatoPop(true)
        };
        printMenu(Constants.SIDE_MENU_TITLE, sides);
    }

    // 음료 메뉴 보여주기
    public void showDrinkMenu() {
        drinks = new Drink[]{
                new AmericanoHot(),
                new AmericanoIce(),
                new IcedTea(),
                new Cola(),
                new ColaZero(),
                new Sprite(),
                new SpriteZero(),
                new OrangeJuice()
        };
        printMenu(Constants.DRINK_MENU_TITLE, drinks);
    }

    // 메뉴판 출력
    private void printMenu(String title, MenuItem[] memu) {
        System.out.println(Constants.BORDER);
        System.out.println(title);
        System.out.println();
        for (int i = 0; i < memu.length; i++) {
            System.out.println((i + 1) + ". " + memu[i].getName() + " - " + memu[i].getPrice() + "원");
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