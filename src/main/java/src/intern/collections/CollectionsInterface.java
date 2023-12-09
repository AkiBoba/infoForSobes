package src.intern.collections;

public interface CollectionsInterface {
    public int[] list = new int[10];
    void add(Object element);
    void add(int index, Object element);
    void remove(int index);
    void remove(Object element);
    Object get(int index);
    int getSize();
}
