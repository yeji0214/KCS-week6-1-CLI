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
        return super.getName() + (ketchup ? "" : " (케첩 X)");
    }

    public void setKetchup(boolean ketchup) {
        this.ketchup = ketchup;
    }

    @Override
    public boolean canChooseKetchup() {
        return true; // 포테이토 팝은 케첩 옵션 선택 가능
    }
}
