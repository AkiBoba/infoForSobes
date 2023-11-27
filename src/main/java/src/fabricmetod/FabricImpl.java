package src.fabricmetod;

public class FabricImpl implements Fabric {
    @Override
    public Vehicle getVehicle(int wheels) {
        Vehicle vehicle = null;
        switch (wheels) {
            case 4: vehicle = new Auto();
            break;
            case 2: vehicle = new Moto();
        }

        return vehicle;
    }
}
