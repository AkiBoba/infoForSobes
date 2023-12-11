package src.classes.shape.cats;

public class CatFamily {
    protected int legs;  //protected поля будут доступны только наследникам и в пакете и за пакетом
    protected int ayes;
    protected boolean canEatPersone;

    public CatFamily(int legs, int ayes, boolean canEatPerson) {
        this.legs = legs;
        this.ayes = ayes;
        this.canEatPersone = canEatPerson;
    }

    public void eat() {
        System.out.print("Eats ");
    }

    @Override
    public String toString() {
        return "CatFamily{" +
                "legs=" + legs +
                ", ayes=" + ayes +
                ", canEatPersone=" + canEatPersone +
                '}';
    }
}
