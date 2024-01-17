package src.fabric.abstractFabric;

public class Ford implements CarFabric {
    @Override
    public void createSUV() {
        System.out.println("Ford SUV");
    }

    @Override
    public void createTRUCK() {
        System.out.println("Ford TRUCK");
    }
}
