package src.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExeService3 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Runnable task1 = () -> {
            int sum = 0;
            for (int i = 0; i < 1000000; i++) {
                sum += i;
            }
            System.out.println(sum);
            countDownLatch.countDown();
        };

        Runnable task2 = () -> {
            int sum = 0;
            for (int i = 0; i < 1000000; i++) {
                if (i%7 ==0) sum += i;
            }
            System.out.println(sum);
            countDownLatch.countDown();
        };

        Runnable task3 = () -> {
            Random random = new Random();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                list.add(random.nextInt(1001));
            }
            System.out.println(list.stream().filter(n -> n%2 == 0).count());
            countDownLatch.countDown();
        };

        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);
        long startTime = System.currentTimeMillis();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(String.format("time work 3: %s", System.currentTimeMillis() - startTime ));
        executorService.shutdown();
    }

}