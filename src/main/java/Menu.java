import java.util.ArrayList;

public class Menu {
    private int totalPrice = 0;
    private StringBuilder receipt = new StringBuilder("< 영수증 >\n");
    private ArrayList<String> cart = new ArrayList<>();

    public void addItemToCart(String itemName, int price, int quantity) {
        int totalItemPrice = price * quantity;
        cart.add(itemName + " x " + quantity);
        totalPrice += totalItemPrice;
        receipt.append(itemName).append(" x ").append(quantity).append(" - ").append(totalItemPrice).append("원\n");
        System.out.println(itemName + " x " + quantity + "이(가) 장바구니에 담겼습니다.");
    }

    public void showReceipt() {
        String border = "**************************************************";
        System.out.println("\n" + border);
        System.out.println(receipt);
        System.out.println("총 가격: " + totalPrice + "원");
        System.out.println(border);
        System.out.println();
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void resetOrder() {
        totalPrice = 0;
        receipt.setLength(0);
        receipt.append("< 영수증 >\n");
        cart.clear();
    }
}
