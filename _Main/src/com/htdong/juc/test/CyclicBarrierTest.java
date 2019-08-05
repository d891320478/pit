package com.htdong.juc.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author htdong
 * @date 2019年8月5日 下午2:44:44
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        final CyclicBarrier cb = new CyclicBarrier(2, new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "after");
            }
        });
        ExecutorService pool = Executors.newFixedThreadPool(2);

        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "task1.1");
                try {
                    cb.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                }
                System.out.println(Thread.currentThread().getName() + "task1.1 finish.");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "task1.2");
                try {
                    cb.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                }
                System.out.println(Thread.currentThread().getName() + "task1.2 finish.");
            }
        });
        pool.shutdown();
    }
}
