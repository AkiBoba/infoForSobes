package src.fabric;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FabricImplTest {

    @Test
    void getVehicle() {
        Fabric fabric = new FabricImpl();
        Vehicle vehicle = new Moto();
        assertThat(vehicle.create()).isEqualTo(fabric.getVehicle(2).create());
    }
}