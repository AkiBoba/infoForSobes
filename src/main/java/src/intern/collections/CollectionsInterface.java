package src.intern.collections;

public interface CollectionsInterface {
    public int[] list = new int[10];
    void add(Object element);
    void add(int index, Object element);
    boolean remove(int index);
    boolean remove(Object element);
    Object get(int index);
    int getSize();
    void clear();
}
