import java.util.Scanner;

public class Order {
    private String border = "**************************************************";
    private Menu menu = new Menu();

    public Order() {
        greeting();
    }

    private void greeting() {
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
        getUserInput();
    }

    private void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (true) {
            System.out.print("선택: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice == 1) {
                    showMenu();
                    break;
                } else if (choice == 2) {
                    System.out.println("이용해 주셔서 감사합니다. 다음에 또 방문해 주세요!");
                    System.exit(0);
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                scanner.next(); // 잘못된 입력을 소비하고 넘어갑니다.
            }
        }
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

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

        while (true) {
            System.out.print("주문할 카테고리의 번호를 입력하세요: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
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
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                scanner.next(); // 잘못된 입력을 소비하고 넘어갑니다.
            }
        }
    }

    public void showToastMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        String title = "<Toast>";
        String potatoSpecialToast = "1. 감자 스페셜";
        String bulgogiSpecialToast = "2. 불고기 스페셜";
        String doubleCheeseBulgogiToast = "3. 더블치즈 불고기";
        String chickenSpecialToast = "4. 치킨 스페셜";
        String hotBaconChickenToast = "5. 핫 베이컨 치킨";
        String hamCheeseToast = "6. 햄치즈 토스트";
        String frenchHamCheeseToast = "7. 프랜치 햄치즈";
        String hamSpecialToast = "8. 햄스페셜 토스트";
        String baconBestToast = "9. 베이컨 베스트";
        String grilledBulgogiToast = "10. 그릴드 불고기";
        String grilledBulgalbiToast = "11. 그릴드 불갈비";
        String baconPotatoPizzaToast = "12. 베이컨 포테이토 피자";
        String deepCheeseBaconToast = "13. 딥치즈 베이컨";
        String deepCheeseBaconPotatoToast = "14. 딥치즈 베이컨 포테이토";
        String hamCheesePotatoToast = "15. 햄치즈 포테이토";
        String honeyGarlicHamCheeseToast = "16. 허니갈릭 햄치즈";
        String cornCheeseToast = "17. 콘치즈 토스트";
        String shrimpToast = "18. 새우 토스트";
        String chiliShrimpToast = "19. 칠리새우 토스트";

        System.out.println(border);
        System.out.println(title);
        System.out.println();
        System.out.println(potatoSpecialToast);
        System.out.println(bulgogiSpecialToast);
        System.out.println(doubleCheeseBulgogiToast);
        System.out.println(chickenSpecialToast);
        System.out.println(hotBaconChickenToast);
        System.out.println(hamCheeseToast);
        System.out.println(frenchHamCheeseToast);
        System.out.println(hamSpecialToast);
        System.out.println(baconBestToast);
        System.out.println(grilledBulgogiToast);
        System.out.println(grilledBulgalbiToast);
        System.out.println(baconPotatoPizzaToast);
        System.out.println(deepCheeseBaconToast);
        System.out.println(deepCheeseBaconPotatoToast);
        System.out.println(hamCheesePotatoToast);
        System.out.println(honeyGarlicHamCheeseToast);
        System.out.println(cornCheeseToast);
        System.out.println(shrimpToast);
        System.out.println(chiliShrimpToast);
        System.out.println();

        while (true) {
            System.out.print("주문할 토스트의 번호를 입력하세요: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        processOrder(new PotatoSpecialToast());
                        return;
                    case 2:
                        processOrder(new BulgogiSpecialToast());
                        return;
                    case 3:
                        processOrder(new DoubleCheeseBulgogiToast());
                        return;
                    case 4:
                        processOrder(new ChickenSpecialToast());
                        return;
                    case 5:
                        processOrder(new HotBaconChickenToast());
                        return;
                    case 6:
                        processOrder(new HamCheeseToast());
                        return;
                    case 7:
                        processOrder(new FrenchHamCheeseToast());
                        return;
                    case 8:
                        processOrder(new HamSpecialToast());
                        return;
                    case 9:
                        processOrder(new BaconBestToast());
                        return;
                    case 10:
                        processOrder(new GrilledBulgogiToast());
                        return;
                    case 11:
                        processOrder(new GrilledBulgalbiToast());
                        return;
                    case 12:
                        processOrder(new BaconPotatoPizzaToast());
                        return;
                    case 13:
                        processOrder(new DeepCheeseBaconToast());
                        return;
                    case 14:
                        processOrder(new DeepCheeseBaconPotatoToast());
                        return;
                    case 15:
                        processOrder(new HamCheesePotatoToast());
                        return;
                    case 16:
                        processOrder(new HoneyGarlicHamCheeseToast());
                        return;
                    case 17:
                        processOrder(new CornCheeseToast());
                        return;
                    case 18:
                        processOrder(new ShrimpToast());
                        return;
                    case 19:
                        processOrder(new ChiliShrimpToast());
                        return;
                    default:
                        System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                scanner.next(); // 잘못된 입력을 소비하고 넘어갑니다.
            }
        }
    }

    public void showSideMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        String title = "<Side>";
        String potatoPop = "1. 포테이토 팝";

        System.out.println(border);
        System.out.println(title);
        System.out.println();
        System.out.println(potatoPop);

        while (true) {
            System.out.print("주문할 사이드의 번호를 입력하세요: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice == 1) {
                    processOrder(new PotatoPop());
                    return;
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                scanner.next(); // 잘못된 입력을 소비하고 넘어갑니다.
            }
        }
    }

    public void showDrinkMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        String title = "<Drink>";
        String americanoHot = "1. 아메리카노 hot";
        String americanoIce = "2. 아메리카노 ice";
        String icedTea = "3. 아이스티";
        String cola = "4. 콜라";
        String colaZero = "5. 콜라 제로";
        String sprite = "6. 사이다";
        String spriteZero = "7. 사이다 제로";
        String orangeJuice = "8. 오렌지 주스";

        System.out.println(border);
        System.out.println(title);
        System.out.println();
        System.out.println(americanoHot);
        System.out.println(americanoIce);
        System.out.println(icedTea);
        System.out.println(cola);
        System.out.println(colaZero);
        System.out.println(sprite);
        System.out.println(spriteZero);
        System.out.println(orangeJuice);

        while (true) {
            System.out.print("주문할 음료의 번호를 입력하세요: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        processOrder(new AmericanoHot());
                        return;
                    case 2:
                        new AmericanoIce();
                        processOrder(new AmericanoIce());
                        return;
                    case 3:
                        new IcedTea();
                        processOrder(new IcedTea());
                        return;
                    case 4:
                        new Cola();
                        processOrder(new Cola());
                        return;
                    case 5:
                        new ColaZero();
                        processOrder(new ColaZero());
                        return;
                    case 6:
                        new Sprite();
                        processOrder(new Sprite());
                        return;
                    case 7:
                        new SpriteZero();
                        processOrder(new SpriteZero());
                        return;
                    case 8:
                        new OrangeJuice();
                        processOrder(new OrangeJuice());
                        return;
                    default:
                        System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                scanner.next(); // 잘못된 입력을 소비하고 넘어갑니다.
            }
        }
    }

    private void processOrder(Toast toast) {
        Scanner scanner = new Scanner(System.in);
        String toastName = toast.getName();
        int quantity = 0;
        boolean frenchBread = false;
        boolean scrambledEgg = false;

        if (toast.canChooseBread()) {
            while (true) {
                System.out.print("빵을 선택하세요 (1. 기본, 2. 프렌치빵(+500원)): ");
                if (scanner.hasNextInt()) {
                    int choice = scanner.nextInt();
                    if (choice == 1) {
                        frenchBread = false;
                        break;
                    } else if (choice == 2) {
                        frenchBread = true;
                        toastName += " (프렌치빵)";
                        break;
                    } else {
                        System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                    }
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                    scanner.next();
                }
            }
        }

        if (toast.canChooseEgg()) {
            while (true) {
                System.out.print("계란을 선택하세요 (1. 기본, 2. 스크램블(+600원)): ");
                if (scanner.hasNextInt()) {
                    int choice = scanner.nextInt();
                    if (choice == 1) {
                        scrambledEgg = false;
                        break;
                    } else if (choice == 2) {
                        scrambledEgg = true;
                        toastName += " (스크램블)";
                        break;
                    } else {
                        System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                    }
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                    scanner.next();
                }
            }
        }

        while (true) {
            System.out.print("수량을 입력하세요 (1-10): ");
            if (scanner.hasNextInt()) {
                quantity = scanner.nextInt();
                if (quantity >= 1 && quantity <= 10) {
                    break;
                } else {
                    System.out.println("잘못된 입력입니다. 수량은 1에서 10 사이여야 합니다.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                scanner.next();
            }
        }

        int finalPrice = toast.getPrice();
        if (frenchBread) finalPrice += 500;
        if (scrambledEgg) finalPrice += 600;

        System.out.println(toastName + " - " + finalPrice + "원 x " + quantity + " = " + (finalPrice * quantity) + "원");
        System.out.println("1. 담기 2. 주문하기 3. 취소");

        while (true) {
            System.out.print("선택: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        menu.addItemToCart(toastName, finalPrice, quantity, frenchBread, scrambledEgg);
                        showMenu();
                        return;
                    case 2:
                        menu.addItemToCart(toastName, finalPrice, quantity, frenchBread, scrambledEgg);
                        menu.showReceipt();
                        System.exit(0);
                    case 3:
                        showMenu();
                        return;
                    default:
                        System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                scanner.next();
            }
        }
    }

    private void processOrder(Side side) {
        Scanner scanner = new Scanner(System.in);
        String sideName = side.getName();
        int quantity = 0;

        while (true) {
            System.out.print("옵션을 선택하세요 (1. 케첩 O, 2. 케첩 X): ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice == 1) {
                    sideName += " (케첩 O)";
                    break;
                } else if (choice == 2) {
                    sideName += " (케첩 X)";
                    break;
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                scanner.next();
            }
        }

        while (true) {
            System.out.print("수량을 입력하세요 (1-10): ");
            if (scanner.hasNextInt()) {
                quantity = scanner.nextInt();
                if (quantity >= 1 && quantity <= 10) {
                    break;
                } else {
                    System.out.println("잘못된 입력입니다. 수량은 1에서 10 사이여야 합니다.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                scanner.next();
            }
        }

        int finalPrice = side.getPrice();

        System.out.println(sideName + " - " + finalPrice + "원 x " + quantity + " = " + (finalPrice * quantity) + "원");
        System.out.println("1. 담기 2. 주문하기 3. 취소");

        while (true) {
            System.out.print("선택: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        menu.addItemToCart(sideName, finalPrice, quantity);
                        showMenu();
                        return;
                    case 2:
                        menu.addItemToCart(sideName, finalPrice, quantity);
                        menu.showReceipt();
                        System.exit(0);
                    case 3:
                        showMenu();
                        return;
                    default:
                        System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                scanner.next();
            }
        }
    }

    private void processOrder(Drink drink) {
        Scanner scanner = new Scanner(System.in);
        String drinkName = drink.getName();
        int price = drink.getPrice();
        int quantity = 0;

        while (true) {
            System.out.print("수량을 입력하세요 (1-10): ");
            if (scanner.hasNextInt()) {
                quantity = scanner.nextInt();
                if (quantity >= 1 && quantity <= 10) {
                    break;
                } else {
                    System.out.println("잘못된 입력입니다. 수량은 1에서 10 사이여야 합니다.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                scanner.next(); // 잘못된 입력을 소비하고 넘어갑니다.
            }
        }

        System.out.println(drinkName + " - " + price + "원 x " + quantity + " = " + (price * quantity) + "원");
        System.out.println("1. 담기 2. 주문하기 3. 취소");

        while (true) {
            System.out.print("선택: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        menu.addItemToCart(drinkName, price, quantity);
                        showMenu();
                        return;
                    case 2:
                        menu.addItemToCart(drinkName, price, quantity);
                        menu.showReceipt();
                        System.exit(0);
                    case 3:
                        showMenu();
                        return;
                    default:
                        System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                scanner.next();
            }
        }
    }

    public static void main(String[] args) {
        new Order();
    }
}