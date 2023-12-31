package src.threads.newTasks;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CiclikBar {
    public static void main(String[] args) {
        Random random = new Random();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println("start");
                try {
                    Thread.sleep(random.nextLong(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
//        executorService.shutdown();
    }
}
