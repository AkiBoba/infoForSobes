package src.singletone;

public class Test {
    public static void main(String[] args) {
        RepositoryClient1 client1 = new RepositoryClient1();
        client1.getInfoFromRepo();
        RepositoryClient2 client2 = new RepositoryClient2();
        client2.getInfoFromRepo();
    }
}
