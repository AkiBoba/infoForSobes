package src.threads;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import static java.lang.System.*;

public class Threads {
    static boolean findOk = false;

    public static void main(String[] args) {
        Random random = new Random();
        int num = random.ints(0, 10000000).findAny().getAsInt();
        LocalDateTime now = LocalDateTime.now();
        Thread thread1 = new Thread(new Runnable() {
            int randNum;
            @Override
            public void run() {
                while (num != randNum) {
                    randNum = new Random().ints(0, 10000000).findAny().getAsInt();
                    findOk = num == randNum;
                }
                out.println(String.format("randNum = %s, num = %s", randNum, num));
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            long diff = 0;
            LocalDateTime someSecondsLater;
            @Override
            public void run() {
                while (thread1.isAlive()) {
                    someSecondsLater = LocalDateTime.now();
                    diff = ChronoUnit.MILLIS.between(now, someSecondsLater);
                }
                out.println("diff " + diff);
            }
        });
        thread2.start();
    }
}
