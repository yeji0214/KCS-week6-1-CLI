public class Toast {
    private String name;
    private int price;
    private boolean canChooseBread;
    private boolean canChooseEgg;

    public Toast(String name, int price, boolean canChooseBread, boolean canChooseEgg) {
        this.name = name;
        this.price = price;
        this.canChooseBread = canChooseBread;
        this.canChooseEgg = canChooseEgg;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean canChooseBread() {
        return canChooseBread;
    }

    public boolean canChooseEgg() {
        return canChooseEgg;
    }
}
