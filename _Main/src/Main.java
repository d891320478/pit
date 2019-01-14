import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author htdong
 */

public class Main {

    public static void main(String[] args) {
        int[] amount = new int[10];
        for (int i = 0; i < 10; ++i) {
            amount[i] = 10000;
        }
        Lock lock = new ReentrantLock();
        Random random = new Random();
        while (true) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        lock.lock();
                        try {
                            int x = random.nextInt(10);
                            int y = random.nextInt(10);
                            amount[x] -= 10;
                            amount[y] += 10;
                            System.out.println(count(amount));
                            try {
                                Thread.sleep((int) (1000 * Math.random()));
                            } catch (InterruptedException e) {
                            }
                        } finally {
                            lock.unlock();
                        }
                    }
                }
            });
            t.start();
        }
    }

    private static int count(int[] a) {
        int c = 0;
        for (int i = 0; i < a.length; ++i) {
            c += a[i];
        }
        return c;
    }
}