public class Side {
    private String name;
    private int price;

    public Side(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean canChooseKetchup() {
        return false; // 기본적으로 케첩 옵션 선택 불가능
    }
}