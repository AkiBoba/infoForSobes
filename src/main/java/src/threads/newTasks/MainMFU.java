package src.threads.newTasks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainMFU {
    public static void main(String[] args) {
        MFU mfu = new MFU();
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService service = Executors.newFixedThreadPool(1);
                service.execute(() -> mfu.print(3));
                service.execute(() -> mfu.scan(3));
        service.shutdown();
        new Thread(() -> {
            new Thread(() -> mfu.print(3)).start();
            new Thread(() -> mfu.scan(3)).start();
        }).start();
    }

}
