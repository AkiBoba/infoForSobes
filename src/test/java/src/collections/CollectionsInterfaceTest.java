package src.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.intern.collections.CollectionsInterface;
import src.intern.collections.MyArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CollectionsInterfaceTest {
    private CollectionsInterface list = new MyArrayList();
    int size = 0;

    @BeforeEach
    void setUp() {
        list = new MyArrayList();
    }

    @Test
    void add() {
        int expectedElement = 3;
        add4();
        int checkEl = (int) list.get(3);
        assertEquals(expectedElement, checkEl);
    }

    @Test
    void testAdd() {
        int expectedSize = 1;
        list.add(1);
        assertEquals(expectedSize, list.getSize());
    }

    @Test
    void remove() {
        add3();
        int expectedElement = 3;
        list.remove(1);
        assertEquals(expectedElement, list.get(1));
    }

    @Test
    void testRemove() {
        int expectedElement = 3;
        add3();
        list.remove(list.get(1));
        assertEquals(expectedElement, list.get(1));
    }

    @Test
    void get() {
        int expectedElement = 3;
        add3();
        list.get(2);
        assertEquals(expectedElement, list.get(2));
    }

    @Test
    void getSize() {
        int expectedSize = 12;
        add12();
        assertEquals(expectedSize, list.getSize());
    }

    @Test
    void clear() {
        int expectedSize = 10;
        add12();
        list.clear();
        assertEquals(expectedSize, list.getSize());
    }

    @Test
    void outOfBoundThrowEx() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    private void add12() {
        int one = 1;
        int two = 2;
        int three = 3;
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(one);
        list.add(two);
        list.add(three);
    }

    private void add3() {
        int one = 1;
        int two = 2;
        int three = 3;
        list.add(one);
        list.add(two);
        list.add(three);
    }

    private void add4() {
        int one = 1;
        int two = 2;
        int three = 3;
        int fore = 4;
        list.add(0, one);
        list.add(1, two);
        list.add(2, three);
        list.add(1, fore);
    }
}