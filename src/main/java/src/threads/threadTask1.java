package src.threads;

import java.util.Arrays;

public class threadTask1 {
    static void withOutCouncurrency() {
        float[] intWOC = new float[11000000];
        Arrays.fill(intWOC, 1);
        long nowTime = System.currentTimeMillis();
        for (int i = 0; i < 11000000; i++) {
            intWOC[i] = (float) (intWOC[i]*Math.sin(0.2f+i/5)*Math.cos(.2f+i/5)*Math.cos(.4f+i/2));
        }
        System.out.println(System.currentTimeMillis() - nowTime);

    }

    static void forForArr(float[] arr) {
        for (int i = 0; i < 5500000; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(.2f + i / 5) * Math.cos(.4f + i / 2));
        }
    }
    static void withCouncurrency() {
        float[] intWithOC = new float[11000000];
        Arrays.fill(intWithOC, 1);
        long nowTime = System.currentTimeMillis();
        float[] tempArr = new float[5500000];
        System.arraycopy(intWithOC, 0, tempArr,0, tempArr.length);
        Thread threads1 = new Thread(() -> forForArr(intWithOC));
        Thread threads2 = new Thread(() -> forForArr(tempArr));
        threads1.start();
        threads2.start();
        try {
            threads1.join();
            threads2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(tempArr, 0, intWithOC, 5500000, tempArr.length);

        System.out.println(System.currentTimeMillis() - nowTime);
        System.out.println(intWithOC[10999999]);
        System.out.println(tempArr[5499999]);

    }
    public static void main(String[] args) {
        withOutCouncurrency();
        withCouncurrency();
    }
}
