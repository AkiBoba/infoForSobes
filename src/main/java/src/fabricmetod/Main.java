package src.fabricmetod;

public class Main {
    public static void main(String[] args) {
        Fabric fabric = new FabricImpl();
        System.out.println(fabric.getVehicle(2).create());
        System.out.println(fabric.getVehicle(4).create());
    }
}
