public class Calculator {
    public static void main(String[] args) {
        plus(1, 2);
        plus(10, 11);
        minus(10, 11);
    }

    public static void plus(int first, int second) {
        int result = first + second;
        System.out.println(result);
    }
    public static void minus(int first, int second) {
        int result = first - second;
        System.out.println(result);
    }

}