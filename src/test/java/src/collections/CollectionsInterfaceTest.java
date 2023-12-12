package src.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.intern.collections.CollectionsInterface;
import src.intern.collections.MyArrayList;
import src.intern.collections.MyLinkedList;
import src.intern.collections.MyNode;

import static org.junit.jupiter.api.Assertions.*;

class CollectionsInterfaceTest {
    private CollectionsInterface list = new MyLinkedList();

    @BeforeEach
    void setUp() {
        list = new MyLinkedList();
    }

    @Test
    void add() {
        int expectedElement = 4;
        add4();
        assertEquals(expectedElement, list.get(3));
    }

    @Test
    void testAddByIndex() {
        add4();
        int expected = 88;
        list.add(3, expected);
        int check = (int) list.get(3);
        assertEquals(expected, check);
    }

    @Test
    void removeByIndexTest() {
        add3();
        int expectedElement = 2;
        list.remove(2);
        assertEquals(expectedElement, list.get(1));
    }

    @Test
    void removeByIndexInSizeTest() {
        add3();
        int expectedElement = 3;
        list.remove(1);
        assertEquals(expectedElement, list.get(2));
    }

    @Test
    void testRemove() {
        int expectedElement = 3;
        add3();
        list.remove(1);
        assertEquals(expectedElement, list.get(1));
    }

    @Test
    void getByIndex() {
        int index = 11;
        int expectedElement = 3;
        add12();
        assertEquals(expectedElement, list.get(index));
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

    @Test
    void ifRemoveElementReturnSize10() {
        int expectedSize = 10;
        int two = 2;
        add12();
        list.removeObject(two);
        list.removeObject(two);
        assertEquals(expectedSize, list.getSize());
    }

    @Test
    void ifRemoveElementReturnTrue() {
        int two = 3;
        add3();
        assertTrue(list.removeObject(two));
    }

    @Test
    void ifRemoveElementReturnFalse() {
        int two = 4;
        add12();
        assertTrue(list.removeObject(two));
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
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(fore);
    }
}