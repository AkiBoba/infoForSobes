package src.singletone;

public class Repository {
    static Repository instants = null;

    public void getInfo() {
        System.out.println("Getting info from Repository");
    }

    private Repository() {
    }

    void letsRun() {
        System.out.println("Repo is starting");
    }

    static Repository getInstants() {
        if (instants == null) {
            System.out.println("Repo just starting");
            instants = new Repository();
        } else {
            System.out.println("Repo running");
        }
        return instants;
    }
}
