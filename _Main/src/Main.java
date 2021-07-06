import java.util.Scanner;

/**
 * @author htdong
 */

public class Main {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
    }

    private Object lock = new Object();

    public void f1() throws InterruptedException {
        synchronized (lock) {
            lock.wait();
            System.out.println("1");
        }
    }

    public void f2() {
        synchronized (lock) {
            lock.notifyAll();
            System.out.println("2");
        }
    }
}