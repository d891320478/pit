import java.util.Scanner;

/**
 * 
 * @author htdong
 */

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = { 1, 2, 4, 7, 8 };
        int[] b = { 9, 9, 7, 3, 2 };
        for (int i = 0; i < a.length; ++i) {
            a[i] *= b[i];
        }
        int ans = 0;
        for (int i = 0; i < a.length; ++i) {
            for (int j = i; j < a.length; ++j) {
                for (int k = i; k <= j; ++k) {
                    ans += a[k];
                }
            }
        }
        System.out.println(ans);
        in.close();
    }
}