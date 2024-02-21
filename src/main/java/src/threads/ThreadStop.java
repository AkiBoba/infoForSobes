package src.threads;

public class ThreadStop {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(
                () -> {
                    int count = 0;
                    while (!Thread.currentThread().isInterrupted()) {
                        System.out.println(count++);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
        );
        thread.start();
        Thread.sleep(1000);
        if (!thread.isInterrupted()) {
            thread.interrupt();
            System.out.println("stop");
        }
    }
}
