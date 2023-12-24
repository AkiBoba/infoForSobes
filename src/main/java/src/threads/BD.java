package src.threads;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class BD {
    Object monitor = new Object();
    BlockingDeque<Thread> list = new LinkedBlockingDeque<>();
    public void add(Thread thread) {
//        synchronized (monitor) {
//        while (list.size() == 3) {
//            try {
//                monitor.wait();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
        list.add(thread);
//        }
    }

    public Thread take() {
        Thread thread = list.poll();
//        monitor.notify();
        return thread;
    }
}
