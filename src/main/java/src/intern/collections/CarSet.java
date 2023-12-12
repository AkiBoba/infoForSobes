package src.intern.collections;

import java.sql.Array;
import java.util.Iterator;
import java.util.Random;

public class CarSet implements CarSetInterface {
    private int capacity = 16;
    private double loading = 0.75;
    private Entry[] set = new Entry[capacity];
    private int size = 0;
    private Random random = new Random();

    @Override
    public boolean add(Car car) {
        if (size > 0 && size/capacity > loading) createNewArray();
        int address = getAddress(car);
        if (set[address] == null) {
            set[address] = new Entry(car, null);
            size++;
            return true;
        }
        Entry temp = set[address];
        if (!temp.car.equals(car) && temp.next == null) {
            temp.next = new Entry(car, null);
            size++;
            return true;
        }
        if (!temp.car.equals(car) && temp.next != null) {
            Entry last = temp;
            if (!findEnters(car, address)) {
                last.next = new Entry(car, null);
                size++;
            }
            return true;
        }
        return false;
    }

    private void createNewArray() {
        capacity *=2;
        System.arraycopy(set, 0, set, 0, capacity);
    }

    @Override
    public boolean remove(Car car) {
        boolean result = false;
        for (int i = 0; i < capacity; i++) {
            int index = 0;
            if (set[i] != null) {
                Entry last = set[i];
                Entry prevLast = null;
                while (last.next != null) {
                    index++;
                    prevLast = last;
                    last = last.next;
                    if (last.car.equals(car)) {
                        if (index == 0 && last.next != null) set[i] = last.next;
                        if (index > 0 && last.next != null) {
                            prevLast.next = last.next;
                        }
                        if (index > 0 && last.next == null) prevLast.next = null;
                        result = true;
                        break;
                    }
                }
            }
            if (result) {
                size--;
                break;
            };
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        set = new Entry[capacity];
    }

    @Override
    public boolean contains(Car car) {
        boolean result = false;
        for (int i = 0; i < capacity; i++) {
            if (findEnters(car, i)) return true;
        }
        return result;
    }

    private boolean findEnters(Car car, int address) {
        boolean result = false;
        if (set[address] != null) {
            Entry last = set[address];
            while (last.next != null) {
                last = last.next;
                if (last.car.equals(car)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public Iterator<Car> iterator() {
        return new Iterator() {
            int index = 0;
            int indexArray = 0;
            Entry entry = null;
            Car car = null;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Car next() {
                while (set[indexArray] == null) {
                    indexArray++;
                }
                if (entry == null) entry = set[indexArray];
                car = entry.car;
                entry = entry.next;
                if (entry == null) {
                    indexArray++;
                }
                index++;
                return car;
            }
        };
    }

    private class Entry {
        private Car car;
        private Entry next;

        public Entry(Car car, Entry next) {
            this.car = car;
            this.next = next;
        }
    }

    private int getAddress(Car car) {
        if (car.getBrand().length() + car.getSerial() >= capacity) {
            return random.ints(capacity).findAny().getAsInt();
        }
        return Math.abs(car.getBrand().length() + car.getSerial());
    }
}
