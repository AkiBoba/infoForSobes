package src.interfaceClass;

public class Cooker implements Worker, Driver {
    @Override
    public void work() {
        System.out.println("Cooker work");
    }

    @Override
    public void drive() {
        System.out.println("Cooker drive");
    }
}
