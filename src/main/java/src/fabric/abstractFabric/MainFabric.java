package src.fabric.abstractFabric;

public class MainFabric {
    public static void main(String[] args) {
        CarFabric ford = new Ford();
        CarFabric dodg = new Dodg();
        dodg.createSUV();
        dodg.createTRUCK();
        ford.createTRUCK();
        ford.createSUV();
    }
}
