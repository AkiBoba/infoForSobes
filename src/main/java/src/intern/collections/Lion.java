package src.intern.collections;

import src.intern.collections.classes.cats.CatFamily;

public class Lion extends CatFamily {
    public Lion(int legs, int ayes, boolean canEatPersone) {
        super(legs, ayes, canEatPersone);
        this.legs = 3;
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("antelope");
    }
}
