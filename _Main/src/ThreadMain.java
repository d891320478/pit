public class ThreadMain {

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
        new Thread(() -> f1()).start();
        new Thread(() -> f2()).start();
        Thread.sleep(10000);
    }
}