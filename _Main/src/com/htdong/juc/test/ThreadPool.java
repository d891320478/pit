package com.htdong.juc.test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author htdong
 * @date 2019年8月2日 上午10:12:56
 */
public class ThreadPool {

    private static Thread threadCoolRun = null;

    public static void main(String[] args) {
        // 1核心线程，最多3线程，多余线程空闲5秒回收，等待队列有界
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>(2));
        pool.execute(new CoolRun());
        pool.execute(new Run1());
        pool.execute(new Run1());
        pool.execute(new Run1());
        if (threadCoolRun != null) {
            threadCoolRun.interrupt();
        }
        pool.shutdown();
    }

    static class CoolRun implements Runnable {
        public void run() {
            threadCoolRun = Thread.currentThread();
            while (!Thread.interrupted()) {
            }
        }
    }

    static class Run1 implements Runnable {
        public void run() {
            System.out.println(Thread.currentThread().getName() + "Run1");
        }
    }
}
