import java.util.Scanner;

public class Order {
    private String border = "**************************************************";
    private Menu menu = new Menu();

    public Order() {
        greeting();
    }

    private void greeting() {
        String storeName = "                  이삭토스트 구파발점                  ";
        String welcomeMessage = "            어서오세요~ 이삭토스트 구파발점입니다!          ";
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
                        new PotatoSpecialToast();
                        addItemToCart("감자 스페셜", 5000); // 예시 가격
                        return;
                    case 2:
                        new BulgogiSpecialToast();
                        addItemToCart("불고기 스페셜", 6000); // 예시 가격
                        return;
                    case 3:
                        new DoubleCheeseBulgogiToast();
                        addItemToCart("더블치즈 불고기", 7000); // 예시 가격
                        return;
                    case 4:
                        new ChickenSpecialToast();
                        addItemToCart("치킨 스페셜", 6500); // 예시 가격
                        return;
                    case 5:
                        new HotBaconChickenToast();
                        addItemToCart("핫 베이컨 치킨", 5500); // 예시 가격
                        return;
                    case 6:
                        new HamCheeseToast();
                        addItemToCart("햄치즈 토스트", 4000); // 예시 가격
                        return;
                    case 7:
                        new FrenchHamCheeseToast();
                        addItemToCart("프랜치 햄치즈", 4500); // 예시 가격
                        return;
                    case 8:
                        new HamSpecialToast();
                        addItemToCart("햄스페셜 토스트", 5000); // 예시 가격
                        return;
                    case 9:
                        new BaconBestToast();
                        addItemToCart("베이컨 베스트", 5500); // 예시 가격
                        return;
                    case 10:
                        new GrilledBulgogiToast();
                        addItemToCart("그릴드 불고기", 6000); // 예시 가격
                        return;
                    case 11:
                        new GrilledBulgalbiToast();
                        addItemToCart("그릴드 불갈비", 6500); // 예시 가격
                        return;
                    case 12:
                        new BaconPotatoPizzaToast();
                        addItemToCart("베이컨 포테이토 피자", 7000); // 예시 가격
                        return;
                    case 13:
                        new DeepCheeseBaconToast();
                        addItemToCart("딥치즈 베이컨", 7500); // 예시 가격
                        return;
                    case 14:
                        new DeepCheeseBaconPotatoToast();
                        addItemToCart("딥치즈 베이컨 포테이토", 8000); // 예시 가격
                        return;
                    case 15:
                        new HamCheesePotatoToast();
                        addItemToCart("햄치즈 포테이토", 5500); // 예시 가격
                        return;
                    case 16:
                        new HoneyGarlicHamCheeseToast();
                        addItemToCart("허니갈릭 햄치즈", 6000); // 예시 가격
                        return;
                    case 17:
                        new CornCheeseToast();
                        addItemToCart("콘치즈 토스트", 5000); // 예시 가격
                        return;
                    case 18:
                        new ShrimpToast();
                        addItemToCart("새우 토스트", 6500); // 예시 가격
                        return;
                    case 19:
                        new ChiliShrimpToast();
                        addItemToCart("칠리새우 토스트", 7000); // 예시 가격
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
                    new PotatoPop();
                    addItemToCart("포테이토 팝", 3000); // 예시 가격
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
                        new AmericanoHot();
                        addItemToCart("아메리카노 hot", 2000); // 예시 가격
                        return;
                    case 2:
                        new AmericanoIce();
                        addItemToCart("아메리카노 ice", 2000); // 예시 가격
                        return;
                    case 3:
                        new IcedTea();
                        addItemToCart("아이스티", 2500); // 예시 가격
                        return;
                    case 4:
                        new Cola();
                        addItemToCart("콜라", 1500); // 예시 가격
                        return;
                    case 5:
                        new ColaZero();
                        addItemToCart("콜라 제로", 1500); // 예시 가격
                        return;
                    case 6:
                        new Sprite();
                        addItemToCart("사이다", 1500); // 예시 가격
                        return;
                    case 7:
                        new SpriteZero();
                        addItemToCart("사이다 제로", 1500); // 예시 가격
                        return;
                    case 8:
                        new OrangeJuice();
                        addItemToCart("오렌지 주스", 2500); // 예시 가격
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

    private void addItemToCart(String itemName, int price) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(itemName + " - " + price + "원");
        System.out.println("1. 담기 2. 주문하기 3. 취소");

        while (true) {
            System.out.print("선택: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        menu.addItemToCart(itemName, price);
                        showMenu();
                        return;
                    case 2:
                        menu.addItemToCart(itemName, price);
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
                scanner.next(); // 잘못된 입력을 소비하고 넘어갑니다.
            }
        }
    }

    public static void main(String[] args) {
        new Order();
    }
}
