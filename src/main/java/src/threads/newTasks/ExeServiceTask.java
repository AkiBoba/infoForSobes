package src.threads.newTasks;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class ExeServiceTask {
    public static void main(String[] args) {
        long timeStart = System.currentTimeMillis();
        Random random = new Random();
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        new Thread(() -> {
            List<Integer> list = Collections.nCopies(1_000_000, 1);
            executorService.execute(() -> {
                int sum = list.stream().map(n -> n+=1).filter(n -> (n%2==0)).reduce(0, Integer::sum);
                System.out.println(sum);
                countDownLatch.countDown();
                });
            executorService.execute(() -> {
                List<Integer> list2 = Collections.nCopies(1_000_000, 1);
                int sum = list2.stream().map(n -> n+=6).filter(n -> (n%7==0)).reduce(0, Integer::sum);
                System.out.println(sum);
                countDownLatch.countDown();
                });
            executorService.execute(() -> {
                List<Integer> list1 = Collections.nCopies(1000, 1000);
                long count = list1.stream().map(n -> n = random.nextInt(1000)).collect(Collectors.toList()).stream().filter(n -> n%2 ==0).count();
                System.out.println(count);
                countDownLatch.countDown();
                });
            }).start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
        System.out.println(String.format("ended in time : %s", System.currentTimeMillis() - timeStart));
    }
}
