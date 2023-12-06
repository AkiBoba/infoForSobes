import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Arr {
    public static void main(String[] args) {
//        int[] numbers = new int[10];
//        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] = i+10;
//        }
//        List<Integer> list11 =Arrays.stream(numbers).boxed().collect(Collectors.toList());
        LocalDateTime now = LocalDateTime.now();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        LocalDateTime someSecondsLater = LocalDateTime.now();
        long diff = ChronoUnit.MILLIS.between(now, someSecondsLater);
        System.out.println(diff);
        now = LocalDateTime.now();

        List<Integer> list1 = new ArrayList<>(100000);
        for (int i = 0; i < 100000; i++) {
            list1.add(i);
        }
//        list.retainAll()
        someSecondsLater = LocalDateTime.now();
        diff = ChronoUnit.MILLIS.between(now, someSecondsLater);
        System.out.println(diff);

    }
}
