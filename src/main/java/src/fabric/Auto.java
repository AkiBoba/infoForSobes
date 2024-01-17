package src.fabric;

public class Auto implements Vehicle {
    private final String name = "Automobile";
    @Override
    public String create() {
        return name;
    }
}
