import java.util.ArrayList;

public class Menu {
    private int totalPrice = 0;
    private StringBuilder receipt = new StringBuilder("< 영수증 >\n");
    private ArrayList<String> cart = new ArrayList<>();

    public void addItemToCart(String itemName, int price) {
        cart.add(itemName);
        totalPrice += price;
        receipt.append(itemName).append(" - ").append(price).append("원\n");
        System.out.println(itemName + "이(가) 장바구니에 담겼습니다.");
    }

    public void showReceipt() {
        String border = "**************************************************";
        System.out.println("\n" + border);
        System.out.println(receipt);
        System.out.println("총 가격: " + totalPrice + "원");
        System.out.println(border);
        System.out.println("이용해 주셔서 감사합니다.");
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
