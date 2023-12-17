package src.lambda;

public class FilterImpl {
    boolean filter(Filter filter, int number) {

        return filter.test(number);
    }
}
