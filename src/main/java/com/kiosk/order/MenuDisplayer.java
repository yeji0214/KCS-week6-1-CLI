package com.kiosk.order;

import com.kiosk.menu.Toast;
import com.kiosk.menu.Side;
import com.kiosk.menu.Drink;

public class MenuDisplayer {
    private final String border = "**************************************************";

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

    public void showToastMenu(Toast[] toastMenu) {
        System.out.println(border);
        System.out.println("<Toast>");
        System.out.println();
        for (int i = 0; i < toastMenu.length; i++) {
            System.out.println((i + 1) + ". " + toastMenu[i].getName() + " - " + toastMenu[i].getPrice() + "원");
        }
        System.out.println();
    }

    public void showSideMenu(Side[] sideMenu) {
        System.out.println(border);
        System.out.println("<Side>");
        System.out.println();
        for (int i = 0; i < sideMenu.length; i++) {
            System.out.println((i + 1) + ". " + sideMenu[i].getName() + " - " + sideMenu[i].getPrice() + "원");
        }
        System.out.println();
    }

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
