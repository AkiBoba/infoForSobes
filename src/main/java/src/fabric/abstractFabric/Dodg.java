package src.fabric.abstractFabric;

public class Dodg implements CarFabric {
    @Override
    public void createSUV() {
        System.out.println("Dodg SUV");
    }

    @Override
    public void createTRUCK() {
        System.out.println("Dodg TRUCK");
    }
}
