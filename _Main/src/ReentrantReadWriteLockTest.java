import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {
    public static void main(String[] args) {
        final Map<String, String> map = new HashMap<>();
        final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        final String key = "key";
        for (int i = 0; i < 4; ++i) {
            final int thr = i;
            new Thread(new Runnable() {

                @Override
                public void run() {
                    lock.readLock().lock();
                    try {
                        String val = map.get(key);
                        if (val == null) {
                            lock.readLock().unlock();
                            lock.writeLock().lock();
                            try {
                                val = map.get(key);
                                if (val == null) {
                                    map.put(key, thr + "");
                                    System.out.println("=== " + thr);
                                }
                                lock.readLock().lock();
                            } finally {
                                lock.writeLock().unlock();
                            }
                        }
                    } finally {
                        lock.readLock().unlock();
                    }
                }
            }).start();
        }
        System.err.println(map.get(key));
    }
}
