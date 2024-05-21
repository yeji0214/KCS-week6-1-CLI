package com.kiosk.order;

import com.kiosk.menu.Toast;
import com.kiosk.menu.Side;
import com.kiosk.menu.Drink;
import com.kiosk.menu.drink.*;
import com.kiosk.menu.side.PotatoPop;
import com.kiosk.menu.toast.*;

public class MenuDisplayer {
    private final String border = "**************************************************";
    private Toast[] toasts;
    private Side[] sides;
    private Drink[] drinks;

    // 메인 메뉴 (카테고리) 보여주기
    public void showMainMenu() {
        String title = "                      <Menu>";
        String categoryToast = "                     1. 토스트";
        String categorySide = "                     2. 사이드";
        String categoryDrink = "                     3. 음료";

        System.out.println(border);
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

        System.out.println(border);
        System.out.println("<Toast>");
        System.out.println();
        for (int i = 0; i < toasts.length; i++) {
            System.out.println((i + 1) + ". " + toasts[i].getName() + " - " + toasts[i].getPrice() + "원");
        }
        System.out.println();
    }

    public Toast[] getToasts() {
        return toasts;
    }

    // 사이드 메뉴 보여주기
    public void showSideMenu() {
        sides = new Side[]{
                new PotatoPop(true)
        };

        System.out.println(border);
        System.out.println("<Side>");
        System.out.println();
        for (int i = 0; i < sides.length; i++) {
            System.out.println((i + 1) + ". " + sides[i].getName() + " - " + sides[i].getPrice() + "원");
        }
        System.out.println();
    }

    public Side[] getSides() {
        return sides;
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

        System.out.println(border);
        System.out.println("<Drink>");
        System.out.println();
        for (int i = 0; i < drinks.length; i++) {
            System.out.println((i + 1) + ". " + drinks[i].getName() + " - " + drinks[i].getPrice() + "원");
        }
        System.out.println();
    }

    public Drink[] getDrinks() {
        return drinks;
    }
}
