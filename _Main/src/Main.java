import java.util.Scanner;

/**
 * @author htdong
 */

public class Main {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        int sum = 0;
        int mut = 1;
        for (int i = 0; i < n; ++i) {
            int a = in.nextInt();
            sum = ((sum + a) % 2 + 2) % 2;
            mut = (mut * a % 2 + 2) % 2;
            System.out.printf("%d%d\n", sum, mut);
        }
    }
}