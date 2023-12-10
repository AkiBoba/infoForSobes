package src.interfaceClass;

public class OficanteImp implements Oficante {
    @Override
    public void getOrder(String menu) {
        System.out.println("This is your " + menu);
    }
}
