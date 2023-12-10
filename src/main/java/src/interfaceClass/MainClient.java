package src.interfaceClass;

public class MainClient {
    public static void main(String[] args) {
        Client client = new Client();
        client.makeOrder(menu -> System.out.println("This is your " + menu), "fish");
    }
}
