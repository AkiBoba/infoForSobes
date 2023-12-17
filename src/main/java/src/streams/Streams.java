package src.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<String> res;
        Predicate<Integer> p1 =  n -> (n % 2 == 0);
        Predicate<Integer> p2 =  n -> (n % 5 == 0);
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        res = list.stream()
                .filter(p1.negate())
                .distinct()
                .map(n -> "Sqrt: " + n)
                .map(s -> s.toLowerCase())
                .collect(Collectors.toList());
        System.out.println(res);

        System.out.println(res.removeIf(el -> el.equals(10)));
        System.out.println(res);

        List<Integer> result = List.of(5, 1, 2);
        List<Integer> list1 = result.stream().map(e->e*2).collect(Collectors.toList());
        System.out.println(list1);
        Scanner scanner = new Scanner(System.in);
    }
}
