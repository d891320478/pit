/**
 * @author htdong
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.err.println(Thread.currentThread().getId());
            }
        };
        Thread t = new Thread(run);
        t.start();
        t.join();
        t.start();
    }
}