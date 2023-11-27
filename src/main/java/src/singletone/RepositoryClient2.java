package src.singletone;

public class RepositoryClient2 {

    private final Repository repository = Repository.getInstants();
    void getInfoFromRepo() {
        repository.getInfo();
    }
}
