package src.interfaceClass;

public class Programmer implements Worker, Driver {
    @Override
    public void work() {
        System.out.println("Programmer work");
    }

    @Override
    public void drive() {
        System.out.println("Programmer drive");
    }
}
