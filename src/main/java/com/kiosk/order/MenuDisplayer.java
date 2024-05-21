package com.kiosk.order;

import com.kiosk.menu.Toast;
import com.kiosk.menu.Side;
import com.kiosk.menu.Drink;
import com.kiosk.menu.toast.*;

public class MenuDisplayer {
    private final String border = "**************************************************";
    private Toast[] toasts;

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
    public void showSideMenu(Side[] sideMenu) {
        System.out.println(border);
        System.out.println("<Side>");
        System.out.println();
        for (int i = 0; i < sideMenu.length; i++) {
            System.out.println((i + 1) + ". " + sideMenu[i].getName() + " - " + sideMenu[i].getPrice() + "원");
        }
        System.out.println();
    }

    // 음료 메뉴 보여주기
    public void showDrinkMenu(Drink[] drinkMenu) {
        System.out.println(border);
        System.out.println("<Drink>");
        System.out.println();
        for (int i = 0; i < drinkMenu.length; i++) {
            System.out.println((i + 1) + ". " + drinkMenu[i].getName() + " - " + drinkMenu[i].getPrice() + "원");
        }
        System.out.println();
    }
}
