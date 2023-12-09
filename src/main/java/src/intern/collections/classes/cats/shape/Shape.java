package src.intern.collections.classes.cats.shape;

public class Shape {
    private int a;
    private int b;

    public Shape(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getPerimetr() {
        return a + b;
    }
}
