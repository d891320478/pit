import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

    public static void main(String[] args) {
        // Thread t1 = new Thread(() -> f1());
        // Thread t2 = new Thread(() -> f2());
        // t2.start();
        // t1.start();
        // Thread.sleep(10000);
        Map<String, Integer> map = new HashMap<>();
        try (Scanner in1 = new Scanner(new File("/Users/dht31261/Desktop/mobile.txt"));
            Scanner in2 = new Scanner(new File("/Users/dht31261/Desktop/mobile1.txt"));
            FileWriter out = new FileWriter(new File("/Users/dht31261/Desktop/out.txt"));) {
            while (in1.hasNextLine()) {
                String s = in1.nextLine();
                map.put(s, 1 + (map.containsKey(s) ? map.get(s) : 0));
            }
            while (in2.hasNextLine()) {
                String s = in2.nextLine();
                map.put(s, 1 + (map.containsKey(s) ? map.get(s) : 0));
            }
            for (Map.Entry<String, Integer> iter : map.entrySet()) {
                out.write(iter.getKey());
                out.write(",");
                out.write(iter.getValue().toString());
                out.write("\n");
                System.out.println(iter.getKey() + "," + iter.getValue());
            }
            out.flush();
        } catch (IOException e1) {
        }
    }
}