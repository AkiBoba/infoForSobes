package src.intern.collections;

public interface CarSetInterface extends Iterable {
    boolean add(Car car);
    boolean remove(Car car);
    int size();
    void clear();
    boolean contains(Car car);
}
