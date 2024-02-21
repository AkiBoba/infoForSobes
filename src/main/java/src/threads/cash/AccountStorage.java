package src.threads.cash;

import java.util.HashMap;
import java.util.Optional;

public class AccountStorage {
    private final HashMap<Integer, Account> accounts = new HashMap<>();

    public boolean add(Account account) {
        return false;
    }

    public boolean update(Account account) {
        return false;
    }

    public void delete(int id) {

    }

    public Optional<Account> getById(int id) {
        return Optional.empty();
    }

    public boolean transfer(int fromId, int toId, int amount) {
        return false;
    }
}
