public class Menu {
    private int totalPrice;
    private int currentPrice;

    public Menu() {
        totalPrice = 0;
        currentPrice = 0;
    }

    public int getPrice() {
        return currentPrice;
    }

    public void setPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }
}
