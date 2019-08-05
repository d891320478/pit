package com.htdong.juc.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author htdong
 * @date 2019年8月5日 下午3:39:32
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        final Semaphore sp = new Semaphore(0);

        ExecutorService pool = Executors.newFixedThreadPool(2);

        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "task1.1");
                sp.release();
                System.out.println(Thread.currentThread().getName() + "task1.1 finish.");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "task1.2");
                sp.release();
                System.out.println(Thread.currentThread().getName() + "task1.2 finish.");
            }
        });
        pool.shutdown();
    }

}
