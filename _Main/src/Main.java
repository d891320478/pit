import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author htdong
 */

public class Main {

    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < 10; ++i) {
            q.add(i);
        }
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }
}