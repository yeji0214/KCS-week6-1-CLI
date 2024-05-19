public class PotatoPop extends Side {
    private boolean ketchup;

    public PotatoPop(boolean ketchup) {
        super("포테이토 팝", 2200);
        this.ketchup = ketchup;
    }

    public boolean hasKetchup() {
        return ketchup;
    }

    @Override
    public String getName() {
        return super.getName() + (ketchup ? " (케첩 O)" : " (케첩 X)");
    }
}
