package src.threads;

import java.util.concurrent.Semaphore;

public class SemaphoreS {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        Runnable task = () -> {
            try {
                semaphore.acquire();
                Sout(Thread.currentThread().getName());
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(task).start();
        Thread.sleep(3000);
        semaphore.release(1);
    }

    private static void Sout(String name) {
        System.out.println("Thread done " + name);

    }
}
