import java.io.IOException;

/**
 * 
 * @author htdong
 */
public class Main {

    interface Test {
        boolean check(int x);
    }

    private static void print(int[] a, Test b) {
        for (int i : a) {
            if (b.check(i)) {
                System.err.println(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int[] a = { 1, 2, 3, 4, 5 };
        print(a, (int x) -> x > 2);
    }

}