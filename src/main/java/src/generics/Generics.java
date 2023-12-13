package src.generics;

import java.util.ArrayList;
import java.util.List;

public class Generics {
    public <U> void copyOfCollections(List<U> src, List<U> dist) {
        dist.addAll(src);
        src.clear();
    }

    public static void main(String[] args) {
        List<String> src = new ArrayList<>();
        List<String> dist = new ArrayList<>();
        src.add("1");
        src.add("2");
        src.add("3");
        Generics generics = new Generics();
        System.out.println(src);
        generics.copyOfCollections(src, dist);
        System.out.println(dist);
        System.out.println(src);
    }
}
