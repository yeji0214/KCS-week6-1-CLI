package com.kiosk.order;

import com.kiosk.menu.MenuItem;
import com.kiosk.menu.toast.Toast;
import com.kiosk.menu.side.Side;
import com.kiosk.menu.drink.Drink;
import com.kiosk.menu.drink.*;
import com.kiosk.util.Constants;

import java.util.*;

// 메뉴 출력
public class MenuDisplayer {
    private final Toast[] toasts; // 토스트 메뉴 배열
    private final Side[] sides; // 사이드 메뉴 배열
    private final Drink[] drinks; // 음료 메뉴 배열

    // 생성자에서 모든 메뉴 객체 생성
    public MenuDisplayer() {
        // 토스트의 재료 맵
        Map<String, List<String>> ingredientsMap = new HashMap<>();
        ingredientsMap.put("Potato Special", Arrays.asList("계란", "콘", "베이컨", "해시브라운", "소스(스윗어니언, 스윗마요)", "양배추", "치즈"));
        ingredientsMap.put("Bulgogi Special", Arrays.asList("계란", "콘", "직화불고기", "소스(불고기, 스윗마요)", "양배추", "치즈"));
        ingredientsMap.put("Double Cheese Bulgogi", Arrays.asList("계란", "콘", "직화불고기", "치즈(모짜렐라, 체다)"));
        ingredientsMap.put("Chicken Special", Arrays.asList("치킨패티", "햄", "피클", "양배추", "소스(칠리)"));
        ingredientsMap.put("Hot Bacon Chicken", Arrays.asList("치킨패티", "계란", "콘", "치즈", "베이컨", "소스(스파이스칠리, 칠리)"));
        ingredientsMap.put("Ham Cheese", Arrays.asList("계란", "콘", "치즈", "햄"));
        ingredientsMap.put("French Ham Cheese", Arrays.asList("프렌치빵", "계란", "콘", "치즈", "햄", "슈가파우더"));
        ingredientsMap.put("Ham Special", Arrays.asList("계란", "콘", "치즈", "햄", "양배추", "피클"));
        ingredientsMap.put("Bacon Best", Arrays.asList("계란", "콘", "치즈", "베이컨", "양배추", "무쌈"));
        ingredientsMap.put("Grilled Bulgogi", Arrays.asList("브라운 브레드", "계란", "콘", "불고기 패티", "치즈", "양배추", "피클", "소스(불고기)"));
        ingredientsMap.put("Grilled Bulgalbi", Arrays.asList("브라운 브레드", "계란", "콘", "불갈비 패티", "치즈", "양배추", "피클", "소스(칠리, 바베큐)"));
        ingredientsMap.put("Bacon Potato Pizza", Arrays.asList("계란", "콘", "치즈(모짜렐라, 체다)", "베이컨", "해쉬브라운", "무쌈", "소스(피자)"));
        ingredientsMap.put("Deep Cheese Bacon", Arrays.asList("계란", "콘", "치즈(모짜렐라)", "베이컨", "소스(딥치즈)"));
        ingredientsMap.put("Deep Cheese Bacon Potato", Arrays.asList("계란", "콘", "치즈(모짜렐라)", "베이컨", "해쉬브라운", "소스(딥치즈)"));
        ingredientsMap.put("Ham Cheese Potato", Arrays.asList("계란", "콘", "치즈", "햄", "해쉬브라운"));
        ingredientsMap.put("Honey Garlic Ham Cheese", Arrays.asList("브라운 브레드", "계란", "콘", "치즈", "햄", "소스(허니갈릭)"));
        ingredientsMap.put("Corn Cheese", Arrays.asList("브라운 브레드", "계란", "콘", "치즈(피자)", "스테이크햄", "콘치즈 시즈닝", "소스(콘버터)"));
        ingredientsMap.put("Shrimp", Arrays.asList("계란", "콘", "치즈", "새우패티", "양배추", "피클", "소스(머스터드)"));
        ingredientsMap.put("Chili Shrimp", Arrays.asList("계란", "콘", "새우패티", "양배추", "피클", "소스(칠리, 핫스모크)"));

        // 토스트 메뉴 객체 생성
        toasts = new Toast[]{
                new Toast("감자 스페셜", 4700, false, true, ingredientsMap.get("Potato Special")),
                new Toast("불고기 스페셜", 5200, true, false, ingredientsMap.get("Bulgogi Special")),
                new Toast("더블치즈 불고기", 5200, true, true, ingredientsMap.get("Double Cheese Bulgogi")),
                new Toast("치킨 스페셜", 4800, true, false, ingredientsMap.get("Chicken Special")),
                new Toast("핫 베이컨 치킨", 5900, false, true, ingredientsMap.get("Hot Bacon Chicken")),
                new Toast("햄치즈", 3400, true, true, ingredientsMap.get("Ham Cheese")),
                new Toast("프렌치 햄치즈", 3800, false, true, ingredientsMap.get("French Ham Cheese")),
                new Toast("햄스페셜", 3800, true, true, ingredientsMap.get("Ham Special")),
                new Toast("베이컨 베스트", 4200, true, true, ingredientsMap.get("Bacon Best")),
                new Toast("그릴드 불고기", 4600, false, false, ingredientsMap.get("Grilled Bulgogi")),
                new Toast("그릴드 불갈비", 4900, false, true, ingredientsMap.get("Grilled Bulgalbi")),
                new Toast("베이컨 포테이토 피자", 5400, false, false, ingredientsMap.get("Bacon Potato Pizza")),
                new Toast("딥치즈 베이컨", 4500, false, false, ingredientsMap.get("Deep Cheese Bacon")),
                new Toast("딥치즈 베이컨 포테이토", 5200, false, false, ingredientsMap.get("Deep Cheese Bacon Potato")),
                new Toast("햄치즈 포테이토", 4300, true, true, ingredientsMap.get("Ham Cheese Potato")),
                new Toast("허니갈릭 햄치즈", 3900, false, true, ingredientsMap.get("Honey Garlic Ham Cheese")),
                new Toast("콘치즈", 4600, false, true, ingredientsMap.get("Corn Cheese")),
                new Toast("새우", 4900, false, false, ingredientsMap.get("Shrimp")),
                new Toast("칠리새우", 4900, false, true, ingredientsMap.get("Chili Shrimp"))
        };

        // 사이드 메뉴 객체 생성
        sides = new Side[]{
                new Side("포테이토 팝", 2200, 0, true)
        };

        // 음료 메뉴 객체 생성
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

    // 토스트 재료 보여주기
    public void showToastIngredients() {
        System.out.println(Constants.BORDER);
        System.out.println(Constants.TOAST_INGREDIENTS_TITLE);
        System.out.println();
        for (int i = 0; i < toasts.length; i++) {
            System.out.println((i + 1) + ". " + toasts[i].getName() + " - " + String.join(", ", toasts[i].getIngredients()));
        }
        System.out.println();
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
        if (Objects.equals(title, Constants.TOAST_MENU_TITLE)) {
            System.out.println(Constants.VIEW_TOAST_INGREDIENTS_OPTION);
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