package src.generics.fruits;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Busket<T extends Fruit> {
    private List<T> busket = new ArrayList<>();

    public int getWeight() {
        int weight = 0;
        for (T fruit: busket) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public void add(T fruit) {
        this.busket.add(fruit);
    }

    static int compare(Busket srcBusket, Busket distBusket) {
        if (srcBusket.getWeight() > distBusket.getWeight()) return 1;
        if (srcBusket.getWeight() < distBusket.getWeight()) return -1;
        return 0;
    }

    static void transfer(Busket<? extends Fruit> srcBusket, Busket<? super Fruit> distBusket) {
        distBusket.busket.addAll(srcBusket.busket);
        srcBusket.busket.clear();
    }

}
