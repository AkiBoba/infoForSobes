package src.intern.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarSetInterfaceTest {

    CarSetInterface set = new CarSet();
    Car carTest = new Car("TEST", 0);

    @BeforeEach
    void setUp() {
        set = new CarSet();
        set.add(new Car("BMV", 1));
        set.add(new Car("VW", 2));
        set.add(new Car("VAZ", 1));
        set.add(new Car("VAZ", 1));
        set.add(new Car("GMC", 3));
        set.add(new Car("HMC", 5));
    }

    @Test
    void add() {
        int expectedSize = 6;
        set.add(carTest);
        assertEquals(expectedSize, set.size());
    }

    @Test
    void remove() {
        int expectedSize = 6;
        set.add(carTest);
        set.remove(carTest);
        assertEquals(expectedSize - 1, set.size());
    }

    @Test
    void size() {
        int expectedSize = 6;
        set.add(carTest);
        assertEquals(expectedSize, set.size());
    }

    @Test
    void clear() {
        int expectedSize = 0;
        set.clear();
        assertEquals(expectedSize, set.size());
    }

    @Test
    void ifContainsReturnTrue() {
        boolean expectedResult = true;
        expectedResult = set.contains(new Car("VAZ", 1));
        assertTrue(expectedResult);
    }

    @Test
    void ifIterateWhenSizeIs0() {
        int size = set.size();
        for(Object car : set) {
            size--;
        }
        assertTrue(size ==0);
    }
}