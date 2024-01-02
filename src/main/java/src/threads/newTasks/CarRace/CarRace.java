package src.threads.newTasks.CarRace;

//1 подготовиться к гонке
//2 Проехать участок обычной дороги
//3 Проехать через тоннель
//4 Проехать участок обычной дороги
// Условия
// 10 участников
// у каждой машины разное время подготовки к заезду, но стартоват должны одновременно
//в тоннеле могут ехать одновеменно только 3 авто
//когда все 10 закончат заезд, нужно вывести номер победителя и затраченное ими время и список всех авто с рез заезда
//У каждой машины должно быть свое случайное время, за которое она готовиться к гонке и за которое проезжает каждый из маршрутов

import jdk.jshell.execution.Util;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

public class CarRace {

    public static void main(String[] args) {
//        long startTime = 0;
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Map<String, ConcurrentHashMap<String, Long>> results = new ConcurrentHashMap();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(() -> {
                ConcurrentHashMap<String, Long> threadResults = new ConcurrentHashMap<>();
                try {
                    Thread.currentThread().setName("Car " + index);
                    long readyTime = Math.round(Math.random()*1000 + 1000);
                    threadResults.put("readyTime", readyTime);
                    Thread.sleep(readyTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
//                results.put(Thread.currentThread().getName(), threadResults);
                try {
                    cyclicBarrier.await();
                    long startTime = System.currentTimeMillis();
//                    System.out.println(Thread.currentThread().getName() + " start race in " + formatter.format(System.currentTimeMillis()));
                    threadResults.put("startTime", startTime);
                    long roadRaceStart = System.currentTimeMillis();
                    long roadRaceFinish = System.currentTimeMillis() + Math.round(Math.random()*1000 + 1000) - roadRaceStart;
                    threadResults.put("1stPartOfRoadTime", roadRaceFinish);
                    System.out.println(Thread.currentThread().getName() + " Wait for tunnel");
                    semaphore.acquire();
                    roadRaceStart = System.currentTimeMillis();
                    roadRaceFinish = System.currentTimeMillis() + Math.round(Math.random()*10000 + 1000) - roadRaceStart;
                    threadResults.put("tunnelTime", roadRaceFinish);
                    System.out.println(Thread.currentThread().getName() + " starts tunnel");
                    System.out.println(Thread.currentThread().getName() + " finish tunnel");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                }

                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
        for (Map.Entry sets : results.entrySet()) {
            for (Map.Entry set : results.get(sets.getKey()).entrySet()) {
                System.out.print(sets.getKey() + " " + set.getKey() + " " + set.getValue()+ "\n");
//                System.out.print(" " + set.getKey() + " " + set.getValue() + );
            }

        }
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list1 = new CopyOnWriteArrayList();

    }
}
