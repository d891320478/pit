import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

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
    // count_over_time(checkStatus{appName="czt_openapi", ip="cztapp.scdzzw.cn", job="checkStatus", result="fail"}[5m])

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Thread t1 = new Thread(() -> f1());
        // Thread t2 = new Thread(() -> f2());
        // t2.start();
        // t1.start();
        // Thread.sleep(10000);
        System.out.print(URLEncoder.encode("https://www.urlencoder.org/", Charset.defaultCharset()));
    }
}