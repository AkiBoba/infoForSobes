package src.classes.shape;

public class Shape {
    private int a;
    private int b;

    public Shape(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getPerimeter() {
        return a + b;
    }
}
