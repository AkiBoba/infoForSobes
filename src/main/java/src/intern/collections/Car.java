package src.intern.collections;

import java.util.Objects;

public class Car {
    private String brand;
    private int serial;

    public Car(String brand, int serial) {
        this.brand = brand;
        this.serial = serial;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return serial == car.serial && Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, serial);
    }
}
