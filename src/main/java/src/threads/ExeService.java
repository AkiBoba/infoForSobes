package src.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExeService {
    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            int sum = 0;
            for (int i = 0; i < 1000000; i++) {
                sum += i;
            }
            System.out.println(sum);
        });

        Thread thread2 = new Thread(() -> {
            int sum = 0;
            for (int i = 0; i < 1000000; i++) {
                if (i%7 ==0) sum += i;
            }
            System.out.println(sum);
        });

        Thread thread3 = new Thread(() -> {
            Random random = new Random();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                list.add(random.nextInt(1001));
            }
            list.forEach(System.out::println);
        });
        long startTime = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(String.format("time work : %s", System.currentTimeMillis() - startTime ));
    }



}
