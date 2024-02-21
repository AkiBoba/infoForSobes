package src.threads;


public class ImmutableClass {
    private final int num;

    public ImmutableClass(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
