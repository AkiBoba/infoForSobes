package src.threads;

public class ABC {
Object monitor = new Object();
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        Thread thread1 = new Thread(a);
        Thread thread2 = new Thread(b);
        Thread thread3 = new Thread(c);
        thread1.start();
        thread2.start();
        thread3.start();

    }

    public void soutStr(String ch) {
        synchronized (monitor) {
            System.out.print(ch);
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class A implements Runnable {
    ABC abc = new ABC();
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            abc.soutStr("A");
            notify();
//            try {
//                abc.monitor.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}

class B implements Runnable {
    ABC abc = new ABC();
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            abc.soutStr("B");
//            try {
//                abc.monitor.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}

class C implements Runnable {
    ABC abc = new ABC();
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            abc.soutStr("C");
//                notifyAll();
        }
    }
}
