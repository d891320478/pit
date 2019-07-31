package com.htdong.juc.test;
import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static void main(String[] args) throws IOException {
        ConditionTest test = new ConditionTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.funcA();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.funcB();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.funcC();
            }
        }).start();
    }
}

class ConditionTest {
    private ReentrantLock lock;
    private Condition cond;

    public ConditionTest() {
        lock = new ReentrantLock();
        cond = lock.newCondition();
    }

    public void funcA() {
        lock.lock();
        try {
            cond.await();
            System.out.println("funcA");
        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }
    }

    public void funcB() {
        lock.lock();
        try {
            System.out.println("funcB");
            cond.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void funcC() {
        lock.lock();
        try {
            // cond.await();
            System.out.println("funcC");
            // } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }
    }
}