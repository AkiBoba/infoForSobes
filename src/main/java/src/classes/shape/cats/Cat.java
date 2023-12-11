package src.classes.shape.cats;

public class Cat extends CatFamily {
    public Cat() {
        super(4, 2, false);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("wiskas");

    }
}
