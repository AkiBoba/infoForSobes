package src.threads;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class ABC {
    private final static Object MONITOR = new Object();
    private static String nextLetter = "A";

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                new Thread(() -> {
                    synchronized (MONITOR) {
                        try {
                            while (nextLetter != "A") {
                                MONITOR.wait();
                            }
                            System.out.print("A");
                            nextLetter = "B";
                            MONITOR.notifyAll();
                        } catch (InterruptedException e) {}
                    }
                }).start();
                new Thread(() -> {
                    synchronized (MONITOR) {
                        try {
                            while (nextLetter != "B") {
                                MONITOR.wait();
                            }
                            System.out.print("B");
                            nextLetter = "C";
                            MONITOR.notifyAll();
                        } catch (InterruptedException e) {}
                    }
                }).start();
                new Thread(() -> {
                    synchronized (MONITOR) {
                        try {
                            while (nextLetter != "C") {
                                MONITOR.wait();
                            }
                            System.out.print("C");
                            nextLetter = "A";
                            MONITOR.notifyAll();
                        } catch (InterruptedException e) {}
                    }
                }).start();

            }
        }).start();
    }
}
