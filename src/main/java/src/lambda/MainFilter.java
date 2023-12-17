package src.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class MainFilter {

    static List<Integer> getFiltered(List<Integer> list, Filter filter ) {
        List<Integer> result = new ArrayList<>();
        list.forEach(num -> {
            if (filter.test(num)) {
                result.add(num);
            }
        });
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        List<Integer> result = MainFilter.getFiltered(list,
                number -> (number % 2 == 0)
        );

        List<String> result1 = list.stream()
                        .filter(n -> (n % 2 == 0))
                                .map(n -> String.format("Number: %s", n))
                .filter(s -> s.endsWith("0"))
                .collect(Collectors.toList());


        out.println(result1);

    }

}
