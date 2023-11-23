package src.localClass;

public class Local {
    private String name = "Petr";

    public void getFullName() {
        final String surname = "Arsentev";

        class FullName {

            public void printFullName() {
                System.out.println(name + " " + surname);
            }

        }

        FullName fullName = new FullName();
        fullName.printFullName();
    }

    public static class Loc{

    }

    public class LocP{

    }

    public static void main(String[] args) {

    }
}
