package src.threads;

public class DebugConcurrentDemo {
    public static void main(String[] args) {
        String name = "1 thread";
        String name1 = "2 thread";
        Thread t1 = new Thread(() -> {
            try {
                for (int i = 3; i > 0; i--) {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted ");
            }
            System.out.println(Thread.currentThread().getName() + " closed.");
        }, name);
        Thread t2 = new Thread(() -> {
            try {
                for (int i = 10; i < 13; i++) {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted ");
            }
            System.out.println(Thread.currentThread().getName() + " closed.");
        }, name1);
        t1.start();
        t2.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("main thread interrupted ");
        }
        System.out.println("main thread closed.");
    }
}