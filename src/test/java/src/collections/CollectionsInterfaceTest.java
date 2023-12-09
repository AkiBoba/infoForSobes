package src.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.intern.collections.CollectionsInterface;
import src.intern.collections.MyArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CollectionsInterfaceTest {
    private CollectionsInterface list = new MyArrayList();
    int size = 0;

    @BeforeEach
    void setUp() {
        list = new MyArrayList();
    }

    @Test
    void add() {
        int one = 1;
        int two = 2;
        int three = 3;
        int fore = 4;
        int expectedElement = three;
        list.add(0, one);
        list.add(1, two);
        list.add(2, three);
        list.add(1, fore);
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
        int one = 1;
        int two = 2;
        int three = 3;
        list.add(one);
        list.add(two);
        list.add(three);
        int expectedElement = three;
        list.remove(1);
        assertEquals(expectedElement, list.get(1));
    }

    @Test
    void testRemove() {
        int expectedElement = 3;
        int one = 1;
        int two = 2;
        int three = 3;
        list.add(one);
        list.add(two);
        list.add(three);
        list.remove(two);
        assertEquals(expectedElement, three);
    }

    @Test
    void get() {
        int expectedElement = 3;
        int one = 1;
        int two = 2;
        int three = 3;
        list.add(one);
        list.add(two);
        list.add(three);
        list.get(2);
        assertEquals(expectedElement, three);
    }

    @Test
    void getSize() {
        int expectedSize = 12;
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
        assertEquals(expectedSize, list.getSize());
    }
}