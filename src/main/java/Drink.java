public class Drink extends Menu {
    private String name;
    private int price;
    private int setPrice;

    public Drink(String name, int price, int setPrice) {
        this.name = name;
        this.price = price;
        this.setPrice = setPrice;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getSetPrice() {
        return setPrice;
    }
}
