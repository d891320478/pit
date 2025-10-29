
/**
 * @author dht31261
 * @date 2025年7月1日 11:23:08
 */
public class ThreadTest {

    private static Object lock = new Object();

    public static void f1() {
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
            }
            System.out.println("f1");
        }
    }

    public static void f2() {
        synchronized (lock) {
            lock.notify();
            System.out.println("f2");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> f1());
        Thread t2 = new Thread(() -> f2());
        t1.start();
        t2.start();
    }
}