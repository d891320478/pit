import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author htdong
 */

public class Main {
    public static void main(String[] args) throws IOException {
        final Stack st = new Stack();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("1_" + st.pop());
                } catch (InterruptedException e) {
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("2_" + st.pop());
                } catch (InterruptedException e) {
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                st.push(1);
            }
        }).start();
    }
}

class Stack {
    private List<Integer> list;

    public Stack() {
        list = new LinkedList<>();
    }

    public synchronized void push(Integer a) {
        synchronized (this) {
            list.add(a);
            notify();
        }
    }

    public synchronized Integer pop() throws InterruptedException {
        synchronized (this) {
            while (list.size() <= 0) {
                wait();
            }
            return list.remove(list.size() - 1);
        }
    }
}