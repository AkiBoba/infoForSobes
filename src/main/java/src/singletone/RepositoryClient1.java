package src.singletone;

public class RepositoryClient1 {
    private final Repository repository = Repository.getInstants();
    void getInfoFromRepo() {
        repository.getInfo();
    }

}
