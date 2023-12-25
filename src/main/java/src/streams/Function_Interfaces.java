package src.streams;

import java.util.Arrays;
import java.util.Comparator;

public class Function_Interfaces {
    public static void main(String[] args) {
        String[] names = {
                "Ivanerer",
                "Petrs"
        };
        Comparator<String> lengthComparator = (left, right) -> {
            System.out.println("execute comparator");
            return Integer.compare(left.length(), right.length());
        };
        Arrays.sort(names, lengthComparator);
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

    }
}
