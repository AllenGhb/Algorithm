package sync.extthread.t7;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest extends Thread {

    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        for(int i =0 ; i< 10000;i++){
            System.out.println(count.incrementAndGet());
        }
    }

    public static void main(String[] args) {
        AtomicIntegerTest atomicIntegerTest = new AtomicIntegerTest();
        Thread t1 = new Thread(atomicIntegerTest);
        Thread t2 = new Thread(atomicIntegerTest);
        Thread t3 = new Thread(atomicIntegerTest);
        Thread t4 = new Thread(atomicIntegerTest);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
