import java.awt.*;
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

        System.out.println(border);
        System.out.println("<Toast>");
        System.out.println();
        for (int i = 0; i < toastMenu.length; i++) {
            System.out.println((i + 1) + ". " + toastMenu[i].getName() + " - " + toastMenu[i].getPrice() + "원");
        }
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (true) {
            System.out.print("주문할 토스트의 번호를 입력하세요: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= toastMenu.length) {
                    Toast selectedToast = toastMenu[choice - 1];
                    System.out.println("\n" + selectedToast.getName() + " 토스트를 선택하셨습니다.");
                    selectToastOption(selectedToast);
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

    private void selectToastOption(Toast toast) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. 단품 - " + toast.getPrice() + "원");
        System.out.println("2. 세트 - " + (toast.getPrice() + 2700) + "원");

        int choice = 0;

        while (true) {
            System.out.print("선택: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice == 1) {
                    processOrder(toast);
                    return;
                } else if (choice == 2) {
                    processSetOrder(toast);
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

    private void processSetOrder(Toast toast) {
        Scanner scanner = new Scanner(System.in);
        int quantity = 0;
        int finalToastPrice = toast.getPrice() + 2700;
        boolean frenchBread = false;
        boolean scrambledEgg = false;
        String toastSetName = toast.getName() + " 세트";

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
                        toastSetName += " (프렌치빵)";
                        finalToastPrice += 500;
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
                        toastSetName += " (스크램블)";
                        finalToastPrice += 600;
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

        System.out.println("사이드를 선택하세요:");
        String sideMenu = "1. 포테이토 팝";
        System.out.println(sideMenu);
        Side side = null;

        while (true) {
            System.out.print("선택: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice == 1) {
                    side = new PotatoPop(true); // 기본으로 케첩을 추가합니다.
                    if (side.canChooseKetchup()) {
                        while (true) {
                            System.out.print("케첩을 추가하시겠습니까? (1. O, 2. X): ");
                            if (scanner.hasNextInt()) {
                                int ketchupChoice = scanner.nextInt();
                                if (ketchupChoice == 1) {
                                    ((PotatoPop) side).setKetchup(true);
                                    break;
                                } else if (ketchupChoice == 2) {
                                    ((PotatoPop) side).setKetchup(false);
                                    toastSetName += " (케첩 X)";
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
                    break;
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                scanner.next(); // 잘못된 입력을 소비하고 넘어갑니다.
            }
        }

        System.out.println("음료를 선택하세요:");
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

        for (int i = 0; i < drinkMenu.length; i++) {
            System.out.println((i + 1) + ". " + drinkMenu[i].getName() + " - " + drinkMenu[i].getPrice() + "원");
        }

        Drink drink = null;

        while (true) {
            System.out.print("선택: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice >= 1 && choice <= drinkMenu.length) {
                    drink = drinkMenu[choice - 1];
                    if (drink.getName().contains("아메리카노") || drink.getName().contains("아이스티")) {
                        finalToastPrice += 800;
                    } else if (drink.getName().contains("오렌지 주스")) {
                        finalToastPrice += 600;
                    }
                    break;
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                scanner.next(); // 잘못된 입력을 소비하고 넘어갑니다.
            }
        }

        toastSetName += " (" + drink.getName() + ")";

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

        int totalPrice = finalToastPrice * quantity;

        System.out.println(toastSetName + " - " + totalPrice + "원 x " + quantity + "개 = " + (totalPrice) + "원");
        System.out.println("1. 담기 2. 주문하기 3. 취소");

        while (true) {
            System.out.print("선택: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        menu.addItemToCart(toastSetName, finalToastPrice, quantity);
                        showMenu();
                        return;
                    case 2:
                        menu.addItemToCart(toastSetName, finalToastPrice, quantity);
                        menu.showReceipt();
                        processPayment(menu.getTotalPrice());
                        return;
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

    public void showSideMenu() {

        Side[] sideMenu = {
                new PotatoPop(true)
        };

        System.out.println(border);
        System.out.println("<Side>");
        System.out.println();
        for (int i = 0; i < sideMenu.length; i++) {
            System.out.println((i + 1) + ". " + sideMenu[i].getName() + " - " + sideMenu[i].getPrice() + "원");
        }
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (true) {
            System.out.print("주문할 사이드의 번호를 입력하세요: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= sideMenu.length) {
                    Side selectedSide = sideMenu[choice - 1];
                    if (selectedSide.canChooseKetchup()) {
                        while (true) {
                            System.out.print("케첩을 추가하시겠습니까? (1. O, 2. X): ");
                            if (scanner.hasNextInt()) {
                                int ketchupChoice = scanner.nextInt();
                                if (ketchupChoice == 1) {
                                    ((PotatoPop) selectedSide).setKetchup(true);
                                    break;
                                } else if (ketchupChoice == 2) {
                                    ((PotatoPop) selectedSide).setKetchup(false);
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
                    processOrder(selectedSide);
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

        System.out.println(border);
        System.out.println("<Drink>");
        System.out.println();
        for (int i = 0; i < drinkMenu.length; i++) {
            System.out.println((i + 1) + ". " + drinkMenu[i].getName() + " - " + drinkMenu[i].getPrice() + "원");
        }
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (true) {
            System.out.print("주문할 음료의 번호를 입력하세요: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= drinkMenu.length) {
                    Drink selectedDrink = drinkMenu[choice - 1];
                    System.out.println("\n" + selectedDrink.getName() + " 음료를 선택하셨습니다.");
                    processOrder(selectedDrink);
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

        System.out.println(toastName + " - " + finalPrice + "원 x " + quantity + "개 = " + (finalPrice * quantity) + "원");
        System.out.println("1. 담기 2. 주문하기 3. 취소");

        while (true) {
            System.out.print("선택: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        menu.addItemToCart(toastName, finalPrice, quantity);
                        showMenu();
                        return;
                    case 2:
                        menu.addItemToCart(toastName, finalPrice, quantity);
                        menu.showReceipt();
                        processPayment(menu.getTotalPrice());
                        return;
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

        System.out.println(sideName + " - " + finalPrice + "원 x " + quantity + "개 = " + (finalPrice * quantity) + "원");
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
                        processPayment(menu.getTotalPrice());
                        return;
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

        System.out.println(drinkName + " - " + price + "원 x " + quantity + "개 = " + (price * quantity) + "원");
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
                        processPayment(menu.getTotalPrice());
                        return;
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

    private void processPayment(int totalPrice) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("결제 방식을 선택하세요:");
        System.out.println("1. 한번에 결제");
        System.out.println("2. 나눠서 결제");

        int paymentChoice = 0;
        while (true) {
            System.out.print("선택: ");
            if (scanner.hasNextInt()) {
                paymentChoice = scanner.nextInt();
                if (paymentChoice == 1 || paymentChoice == 2) {
                    break;
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                scanner.next(); // 잘못된 입력을 소비하고 넘어갑니다.
            }
        }

        int amountPaid = 0;
        switch (paymentChoice) {
            case 1:
                while (amountPaid < totalPrice) {
                    System.out.print("금액을 투입하세요: ");
                    if (scanner.hasNextInt()) {
                        amountPaid = scanner.nextInt();
                        if (amountPaid < totalPrice) {
                            System.out.println("투입 금액이 부족합니다.");
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                        scanner.next(); // 잘못된 입력을 소비하고 넘어갑니다.
                    }
                }
                break;
            case 2:
                while (amountPaid < totalPrice) {
                    System.out.print("금액을 투입하세요: ");
                    if (scanner.hasNextInt()) {
                        int partialPayment = scanner.nextInt();
                        amountPaid += partialPayment;
                        if (amountPaid < totalPrice) {
                            System.out.println("남은 금액: " + (totalPrice - amountPaid) + "원");
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                        scanner.next(); // 잘못된 입력을 소비하고 넘어갑니다.
                    }
                }
                break;
        }

        int change = amountPaid - totalPrice;
        if (change > 0) {
            System.out.println("거스름돈: " + change + "원");
        }
        System.out.println("결제가 완료되었습니다. 감사합니다!");
    }

    public static void main(String[] args) {
        new Order();
    }
}