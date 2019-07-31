package com.htdong.juc.test;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) {
        final CountDownLatch cdl = new CountDownLatch(2);
        new Thread(new Thread1(cdl)).start();
        new Thread(new Thread2(cdl)).start();
        try {
            cdl.await();
        } catch (InterruptedException e) {
        }
        System.out.println("main.end");
    }
}

class Thread1 implements Runnable {

    private CountDownLatch cdl;

    public Thread1(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    @Override
    public void run() {
        System.out.println("t1.start");
        cdl.countDown();
        System.out.println("t1.end");
    }

}

class Thread2 implements Runnable {

    private CountDownLatch cdl;

    public Thread2(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    @Override
    public void run() {
        System.out.println("t2.start");
        cdl.countDown();
        System.out.println("t2.countDown");
        try {
            cdl.await();
        } catch (InterruptedException e) {
        }
        System.out.println("t2.end");
    }

}