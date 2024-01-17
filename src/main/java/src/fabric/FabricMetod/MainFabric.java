package src.fabric.FabricMetod;

public class MainFabric {
    public static void main(String[] args) {
        FabricMetod fabricCar = new CarFabric();
        FabricMetod fabricMoto = new MotoFabric();
        fabricCar.create();
        fabricMoto.create();
    }
}
