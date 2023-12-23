package src.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class ExeService1 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(4);

        new Thread(() -> {
                new Thread(() -> {
                    int sum = 0;
                    for (int i = 0; i < 1000000; i++) {
                        sum += i;
                    }
                    System.out.println(sum);
                    countDownLatch.countDown();
                }).start();

                new Thread(() -> {
                    int sum = 0;
                    for (int i = 0; i < 1000000; i++) {
                        if (i%7 ==0) sum += i;
                    }
                    System.out.println(sum);
                    countDownLatch.countDown();
                }).start();

                new Thread(() -> {
                    Random random = new Random();
                    List<Integer> list = new ArrayList<>();
                    for (int i = 0; i < 1000; i++) {
                        list.add(random.nextInt(1001));
                    }
                    System.out.println(list.stream().filter(n -> n%2 == 0).count());
                    countDownLatch.countDown();
                }).start();
                countDownLatch.countDown();
            }
        ).start();
            long startTime = System.currentTimeMillis();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(String.format("time work 2: %s", System.currentTimeMillis() - startTime ));
        }



}
