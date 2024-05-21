package com.kiosk.order;

import com.kiosk.menu.drink.*;
import com.kiosk.menu.side.*;
import com.kiosk.menu.toast.*;
import com.kiosk.menu.*;

import java.util.Scanner;

public class Order {
    private final Menu menu = new Menu();
    private final InputHandler inputHandler = new InputHandler();
    private final MenuDisplayer menuDisplayer = new MenuDisplayer();
    private final ToastOptionSelector toastOptionSelector = new ToastOptionSelector();
    private final SetOrderProcessor setOrderProcessor = new SetOrderProcessor(menu, this);
    private final PaymentProcessor paymentProcessor = new PaymentProcessor(menu);

    public void start() {
        greeting();
        getUserInput();
    }

    private void greeting() {
        String border = "**************************************************";
        String storeName = "                  이삭토스트 구파발역점                  ";
        String welcomeMessage = "            어서오세요~ 이삭토스트 구파발역점입니다!          ";
        String promptMessage = "                   주문하시겠어요?                    ";
        String choice1 = "               1. 네!!";
        String choice2 = "               2. 아 잘못 들어왔습니다.";

        System.out.println(border);
        System.out.println(storeName);
        System.out.println(border);
        System.out.println(welcomeMessage);
        System.out.println(promptMessage);
        System.out.println();
        System.out.println(choice1);
        System.out.println(choice2);
        System.out.println();
    }

    private void getUserInput() {
        while (true) {
            int choice = inputHandler.getIntInput("선택: ");
            if (choice == 1) {
                showMenu();
                break;
            } else if (choice == 2) {
                System.out.println("이용해 주셔서 감사합니다. 다음에 또 방문해 주세요!");
                System.exit(0);
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
            }
        }
    }

    public void showMenu() {
        while (true) {
            menuDisplayer.showMainMenu();
            int choice = inputHandler.getIntInput("주문할 카테고리의 번호를 입력하세요: ");
            if (choice == 1) {
                showToastMenu();
                break;
            } else if (choice == 2) {
                showSideMenu();
                break;
            } else if (choice == 3) {
                showDrinkMenu();
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
            }
        }
    }

    public void showToastMenu() {
        Toast[] toastMenu = {
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

        menuDisplayer.showToastMenu(toastMenu);

        while (true) {
            int choice = inputHandler.getIntInput("주문할 토스트의 번호를 입력하세요: ");
            if (choice >= 1 && choice <= toastMenu.length) {
                Toast selectedToast = toastMenu[choice - 1];
                System.out.println("\n" + selectedToast.getName() + " 토스트를 선택하셨습니다.");
                selectToastOption(selectedToast);
                return;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
            }
        }
    }

    public void showSideMenu() {

        Side[] sideMenu = {
                new PotatoPop(true)
        };

        menuDisplayer.showSideMenu(sideMenu);

        while (true) {
            int choice = inputHandler.getIntInput("주문할 사이드의 번호를 입력하세요: ");
            if (choice >= 1 && choice <= sideMenu.length) {
                Side selectedSide = sideMenu[choice - 1];
                System.out.println("\n" + selectedSide.getName() + " 사이드를 선택하셨습니다.");
                if (selectedSide.canChooseKetchup()) {
                    boolean ketchup = inputHandler.getBooleanInput("케첩을 추가하시겠습니까? (1. X, 2. O): ");
                    ((PotatoPop) selectedSide).setKetchup(ketchup);
                }
                processOrder(selectedSide);
                return;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
            }
        }
    }

    public void showDrinkMenu() {
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

        menuDisplayer.showDrinkMenu(drinkMenu);

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

    private void selectToastOption(Toast toast) {
        while (true) {
            System.out.println("1. 단품 - " + toast.getPrice() + "원");
            System.out.println("2. 세트 - " + (toast.getPrice() + 2700) + "원");

            int choice = inputHandler.getIntInput("선택: ");
            if (choice == 1) {
                processOrder(toast);
                return;
            } else if (choice == 2) {
                System.out.println("\n" + toast.getName() + " 세트를 선택하셨습니다.");
                setOrderProcessor.processSetOrder(toast);
                return;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
            }
        }
    }

    private void processOrder(Toast toast) {
        toastOptionSelector.selectToastOptions(toast);
        int quantity = inputHandler.getQuantity();
        System.out.println(toast.getName() + " - " + toast.getPrice() + "원 x " + quantity + "개 = " + (toast.getPrice() * quantity) + "원");
        menu.addItemToCart(toast.getName(), toast.getPrice(), quantity);
        afterOrder(toast.getName(), toast.getPrice(), quantity);
    }

    private void processOrder(Side side) {
        int quantity = inputHandler.getQuantity();
        System.out.println(side.getName() + " - " + side.getPrice() + "원 x " + quantity + "개 = " + (side.getPrice() * quantity) + "원");
        menu.addItemToCart(side.getName(), side.getPrice(), quantity);
        afterOrder(side.getName(), side.getPrice(), quantity);
    }

    private void processOrder(Drink drink) {
        int quantity = inputHandler.getQuantity();
        System.out.println(drink.getName() + " - " + drink.getPrice() + "원 x " + quantity + "개 = " + (drink.getPrice() * quantity) + "원");
        menu.addItemToCart(drink.getName(), drink.getPrice(), quantity);
        afterOrder(drink.getName(), drink.getPrice(), quantity);
    }

    private void afterOrder(String name, int price, int quantity) {
        System.out.println("1. 담기 2. 주문하기 3. 취소");
        while (true) {
            int choice = inputHandler.getIntInput("선택: ");
            switch (choice) {
                case 1:
//                    menu.addItemToCart(name, price, quantity);
                    System.out.println(name + " " + quantity + "개가 장바구니에 담겼습니다.");
                    showMenu();
                    return;
                case 2:
//                    menu.addItemToCart(name, price, quantity);
                    System.out.println(name + " " + quantity + "개가 장바구니에 담겼습니다.");
                    menu.showReceipt();
                    paymentProcessor.processPayment(menu.getTotalPrice());
                    return;
                case 3:
                    showMenu();
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
            }
        }
    }
}