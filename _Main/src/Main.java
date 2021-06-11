import java.util.Scanner;

/**
 * @author htdong
 */

public class Main {

    private static Scanner in = new Scanner(System.in);
    private static int[][][][][][] vis = new int[7][7][7][7][7][7];
    private static int[] a = new int[6];

    public static void main(String[] args) {
        int _t = in.nextInt();
        while (_t-- > 0) {
            int n = in.nextInt();
            for (int i = 0; i < 6; ++i) {
                a[i] = i < n ? in.nextInt() : 0;
            }
            System.out.println(vis[a[0]][a[1]][a[2]][a[3]][a[4]][a[5]] == 1 ? "orzwym6912" : "orzwang9897");
        }
    }
}