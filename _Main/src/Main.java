public class Main {

    public static Object lock = new Object();

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

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> f1());
        Thread t2 = new Thread(() -> f2());
        t2.start();
        t1.start();
        Thread.sleep(10000);
    }
}