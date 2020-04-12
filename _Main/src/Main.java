import java.util.Scanner;

/**
 * @author htdong
 */

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int _t = in.nextInt();
        int cas = 0;
        while (_t-- > 0) {
            ++cas;
            System.out.print("Case #" + cas + ": ");
            int n = in.nextInt();
            in.nextLine();
            String[][] t = new String[n][2];
            for (int i = 0; i < n; ++i) {
                String s = in.nextLine();
                t[i] = s.split("\\*");
            }
            boolean flag = true;
            String ls = t[0][0];
            for (int i = 1; i < n; ++i) {
                if (!ls.startsWith(t[i][0])) {
                    if (t[i][0].startsWith(ls)) {
                        ls = t[i][0];
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            String rs = "";
            if (flag) {
                for (int i = 0; i < n; ++i) {
                    if (t[i].length > 1) {
                        if (!rs.endsWith(t[i][1])) {
                            if (t[i][1].endsWith(rs)) {
                                rs = t[i][1];
                            } else {
                                flag = false;
                                break;
                            }
                        }
                    }
                }
            }
            if (flag) {
                System.out.println(ls + rs);
            } else {
                System.out.println("*");
            }
        }
        in.close();
    }

}