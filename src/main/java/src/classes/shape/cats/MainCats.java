package src.classes.shape.cats;

import src.intern.collections.Lion;

public class MainCats {
    public static void main(String[] args) {
        CatFamily cat = new Cat();
        CatFamily lion = new Lion(4,3,true);
        lion.ayes = 3;
        cat.eat();
        lion.eat();
    }
}
