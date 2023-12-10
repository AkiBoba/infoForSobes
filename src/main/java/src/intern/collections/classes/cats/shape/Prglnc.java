package src.intern.collections.classes.cats.shape;

public class Prglnc extends Shape {
    private int a;
    private int b;

    public Prglnc(int a, int b) {
        super(a, b);
    }

    @Override
    public int getPerimeter() {
        return super.getPerimeter()*2;
    }
}
