package src.threads;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import static java.lang.System.*;

public class Threads {
    static Random random = new Random();
    static int num = random.ints(0, 100000).findAny().getAsInt();
    static boolean findOk = false;
    static LocalDateTime now = LocalDateTime.now();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            int randNum = num - 1;
            @Override
            public void run() {
                while (num != randNum) {
                    randNum = new Random().ints(0, 100000).findAny().getAsInt();
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
