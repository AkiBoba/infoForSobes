package src.threads;

public class Market {

    public static void main(String[] args) {
        MarketRelise marketRelise = new MarketRelise();
        Produser produser = new Produser(marketRelise);
        Consumer consumer = new Consumer(marketRelise);
        Thread thread1 = new Thread(produser);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " end work");
    }
}

    class MarketRelise {
        int breadCount = 0;
        public synchronized void getBread() {
            while (breadCount < 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            breadCount--;
            notify();
            System.out.println("consumer get 1 bread");
            System.out.println("count of bread is :" + breadCount);
        }
        public synchronized void putBread() {
            breadCount++;
            notify();
            System.out.println("producer put 1 bread");
            System.out.println("count of bread is :" + breadCount);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Produser implements Runnable{
        MarketRelise market;
        public Produser(MarketRelise market) {
            this.market = market;
        }
        @Override
        public void run() {
//                for (int i = 0; i < 10; i++) {
            while (true) {
                    market.putBread();
                }
        }
    }
    class Consumer implements Runnable {
        MarketRelise market;

        public Consumer(MarketRelise market) {
            this.market = market;
        }
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                market.getBread();
            }
        }
    }
