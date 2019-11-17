/**
 * @author htdong
 */

public class Main {

    static class C {
        public int n;
    }

    public static void main(String[] args) throws InterruptedException {
        C c = new C();
        C d = new C();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (c) {
                    c.n = 100;
                    d.n = 100;
                    while (!Thread.interrupted()) {
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " " + d.n + " " + c.n);
            }
        });
        t2.start();
        t2.join();
        t1.interrupt();
        c.n = 101 * (int) System.currentTimeMillis();
    }
}