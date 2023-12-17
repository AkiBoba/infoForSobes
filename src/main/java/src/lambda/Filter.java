package src.lambda;

@FunctionalInterface
public interface Filter<T extends Integer> {
    boolean test(T number);
}
