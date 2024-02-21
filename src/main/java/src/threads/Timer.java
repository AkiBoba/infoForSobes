package src.threads;

public class Timer {
    public static void main(String[] args) {
        new Thread(
                () -> {
                    for (int i = 1; i <= 100; i++) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.print("\rLoading : " + i  + "%");

                    }
                }
        ).start();
    }
}
