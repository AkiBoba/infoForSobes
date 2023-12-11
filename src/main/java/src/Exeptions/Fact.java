package src.Exeptions;

public class Fact {
    public int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N could not be less than 0");
        }
        int rsl = 1;
        for (int index = 2; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}