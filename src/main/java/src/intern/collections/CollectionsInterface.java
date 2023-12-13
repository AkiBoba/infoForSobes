package src.intern.collections;

public interface CollectionsInterface <T> {
    public int[] list = new int[10];
    void add(T element);
    void add(int index, T element);
    boolean remove(int index);
    boolean removeObject(T element);
    Object get(int index);
    int getSize();
    void clear();
}
