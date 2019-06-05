import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author htdong
 */

public class Main {

    public static void main(String[] args) throws IOException {
        ConditionTest test = new ConditionTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.funcA();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.funcB();
            }
        }).start();
    }
}

class ConditionTest {
    private ReentrantLock lock;
    private Condition cond;
    
    public ConditionTest() {
        lock = new ReentrantLock();
        cond = lock.newCondition();
    }
    
    public void funcA() {
        lock.lock();
        try {
            cond.await();
            System.out.println("funcA");
        } catch (InterruptedException e) {
        } finally {
            lock.unlock();
        }
    }
    
    public void funcB() {
        lock.lock();
        try {
            System.out.println("funcB");
            cond.signal();
        } finally {
            lock.unlock();
        }
    }
}