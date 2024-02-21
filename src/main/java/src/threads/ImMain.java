package src.threads;

public class ImMain {
    public static void main(String[] args) {
        ImmutableClass immutableClass10 = new ImmutableClass(10);
        int n = immutableClass10.getNum();
        System.out.println(n);
    }
}
