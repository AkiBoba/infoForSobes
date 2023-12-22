package src.threads;

public class Bank {
    private int cash = 1000;
    Object monitor = new Object();
    synchronized void dec(String name, int sum) {
            System.out.println(String.format("%s подошел к банку", name));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (cash >= sum) {
                System.out.println(String.format("%s вывел %s рублей и осталось %s", name, sum, (cash - sum)));
                cash -= sum;
                System.out.println(cash);
            } else
                System.out.println("No cash");

    }

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        Thread thread = new Thread(() -> {
            bank.dec("Ivan", 1000);

        });
        Thread thread1 = new Thread(() -> {
            bank.dec("Diman", 90);

        });
        thread1.start();
        thread.start();

//        thread1.join();
//        thread.join();
    }
}
