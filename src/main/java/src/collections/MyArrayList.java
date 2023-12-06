package src.collections;

import java.util.Arrays;

public class MyArrayList implements CollectionsInterface {
    Object[] list = new Object[10];
    int size = 0;
    int sizeForCheck = 10;

    @Override
    public void add(Object element) {
        checkSizeOfCollection();
        list[size] = element;
        size++;
    }

    private void checkSizeOfCollection() {
        if (size == sizeForCheck) {
            sizeForCheck = size * 2;
            list = Arrays.copyOf(list, sizeForCheck);
        }
    }

    @Override
    public void add(int index, Object element) {
        checkSizeOfCollection();
        Object[] listForChange = Arrays.copyOfRange(list, index, size);
        list[index] = element;
        System.arraycopy(listForChange, 0, list, index + 1, listForChange.length);
        size++;
    }

    @Override
    public void remove(int index) {
        Object[] listForChange = Arrays.copyOfRange(list, index + 1, size);
        System.arraycopy(listForChange, 0, list, index, listForChange.length);
        list[size] = null;
    }

    @Override
    public void remove(Object element) {
        for (int i = 0; i < size; i++) {
            if (list[i] == element) {
                remove(i);
                return;
            }
        }
    }

    @Override
    public Object get(int index) {
        return list[index];
    }

    @Override
    public int getSize() {
        return size;
    }
}
