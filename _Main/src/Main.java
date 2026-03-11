import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<>();
        q.add(3);
        q.add(1);
        q.add(2);
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }
}