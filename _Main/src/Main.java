import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author htdong
 */

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] a = new int[1001][1001];
        a[1][0] = 1;
        for (int i = 2; i <= 1000; ++i) {
            for (int j = 0, cnt = 0, k = 0; j <= 1000; ++j) {
                cnt += a[i - 1][j];
                if (k <= j - i) {
                    cnt -= a[i - 1][k];
                    ++k;
                }
                a[i][j] = cnt;
            }
        }
        for (int i = 1; i <= 10; ++i) {
            for (int j = 0; j <= 10; ++j) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

}