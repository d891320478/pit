/**
 * @author htdong
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        new Thread(Main::f1).start();
        Thread.sleep(1000);
        new Thread(Main::f2).start();
    }

    private static Object lock = new Object();

    public static void f1() {
        synchronized (lock) {
            try {
                lock.wait();
                System.out.println("1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void f2() {
        synchronized (lock) {
            lock.notifyAll();
            System.out.println("2");
        }
    }
}