package src.interfaceClass;

public class Director implements Worker {
    @Override
    public void work() {
        System.out.println("Director work");
    }
}
