import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author htdong
 */

public class Main {
    public static void main(String[] args) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= 10000; ++i) {
            q.add(i);
        }
        q = null;
        System.gc();
        Scanner in = new Scanner(System.in);
        in.nextLine();
        in.close();
    }
}