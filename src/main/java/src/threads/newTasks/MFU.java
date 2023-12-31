package src.threads.newTasks;

public class MFU {
    Object printMonitor = new Object();
    Object scanMonitor = new Object();
    Object monitor = new Object();

    public void print(int page) {
        synchronized (printMonitor) {
            try {
                for (int i = 0; i < page; i++) {
                        System.out.println("print " + i);
                        Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void scan(int page) {
        synchronized (scanMonitor) {
            try {
                for (int i = 0; i < page; i++) {
                        System.out.println("scan " + i);
                        Thread.sleep(500);
                        notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
