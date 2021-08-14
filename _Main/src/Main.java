/**
 * @author htdong
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        new Thread(Main::f1).start();
        Thread.sleep(3000);
        new Thread(Main::f2).start();
    }

    static Object lock = new Object();

    public static void f1() {
        synchronized (lock) {
            System.out.println("f11");
            try {
                lock.wait();
            } catch (InterruptedException e) {
            }
            System.out.println("f12");
        }
    }

    public static void f2() {
        synchronized (lock) {
            System.out.println("f21");
            lock = new Object();
            lock.notifyAll();
            System.out.println("f22");
        }
    }
}