package src.generics.fruits;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusketTest {
    public Busket<Apple> appleBusket = new Busket<Apple>();
    public Busket<Orange> orangeBusket = new Busket<Orange>();
    public Busket<Fruit> fruitBusket = new Busket<Fruit>();

    @Test
    void getWeightApples() {
        appleBusket.add(new Apple(3));
        appleBusket.add(new Apple(4));
        appleBusket.add(new Apple(1));
        assertEquals(8, appleBusket.getWeight());
    }

    @Test
    void getWeightOrange() {
        orangeBusket.add(new Orange(3));
        orangeBusket.add(new Orange(4));
        orangeBusket.add(new Orange(1));
        assertEquals(8, orangeBusket.getWeight());
    }

    @Test
    void getWeightFruits() {
        fruitBusket.add(new Orange(3));
        fruitBusket.add(new Apple(4));
        fruitBusket.add(new Fruit(1));
        assertEquals(8, fruitBusket.getWeight());
    }

    @Test
    void add() {
    }

    @Test
    void compare() {
        orangeBusket.add(new Orange(3));
        orangeBusket.add(new Orange(4));
        fruitBusket.add(new Orange(3));
        fruitBusket.add(new Apple(1));
        assertEquals(1, Busket.compare(orangeBusket, fruitBusket));
    }

    @Test
    void transfer() {
        appleBusket.add(new Apple(3));
        appleBusket.add(new Apple(4));
        appleBusket.add(new Apple(1));
        assertEquals(0, fruitBusket.getWeight());
        Busket.transfer(appleBusket, fruitBusket);
        assertEquals(8, fruitBusket.getWeight());
        assertEquals(0, appleBusket.getWeight());
    }
}