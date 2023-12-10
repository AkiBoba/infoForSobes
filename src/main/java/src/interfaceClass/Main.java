package src.interfaceClass;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(new Director());
        workers.add(new Programmer());
        workers.add(new Cooker());
        ArrayList<Driver> drivers = new ArrayList<>();
        drivers.add(new Programmer());
        drivers.add(new Cooker());
        workers.forEach(Worker::work);
        drivers.forEach(Driver::drive);
    }
}
