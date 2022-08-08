import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

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

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Thread t1 = new Thread(() -> f1());
        // Thread t2 = new Thread(() -> f2());
        // t2.start();
        // t1.start();
        // Thread.sleep(10000);
        byte[] b = Base64.getDecoder().decode(
            "ZGVmIGh0dHAoYXBwLCB1cmwsIHBhcmFtcywgaGVhZGVyKSB7CiAgICBkZWYgaHR0cCA9IG5ldyBVUkwodXJsKS5vcGVuQ29ubmVjdGlvbigpIGFzIEh0dHBVUkxDb25uZWN0aW9uCiAgICBodHRwLmNvbm5lY3QoKQogICAgaWYgKGh0dHAucmVzcG9uc2VDb2RlID09IDIwMCkgewogICAgICAgIHJldHVybiBodHRwLmlucHV0U3RyZWFtLmdldFRleHQoJ1VURi04JykgPT0gInN1Y2Nlc3MiID8gInN1Y2Nlc3MiIDogImZhaWwiCiAgICB9CiAgICByZXR1cm4gImZhaWwiCn0KCmh0dHAoYXBwLCB1cmwsIHBhcmFtcywgaGVhZGVyKQ==");
        try (FileOutputStream write = new FileOutputStream("/Users/dht31261/Desktop/1.txt")) {
            write.write(b);
            write.flush();
        }
    }
}