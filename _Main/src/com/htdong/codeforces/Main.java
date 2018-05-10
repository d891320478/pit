package com.htdong.codeforces;

import java.util.Scanner;

/**
 *
 * @author htdong
 * @date 2018年4月20日 上午11:52:19
 */

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.nextLine();
        int m = Integer.parseInt(n);
        for (int i = (int) Math.sqrt(m) + 5; i > 0; --i) {
            if (i * i > m) {
                continue;
            }
            String c = (i * i) + "";
            if (check(n, c)) {
                System.out.println(n.length() - c.length());
                in.close();
                return;
            }
        }
        System.out.println(-1);
        in.close();
    }

    private static boolean check(String n, String c) {
        int i = 0, j = 0;
        for (; i < c.length() && j < n.length(); ++j) {
            if (n.charAt(j) == c.charAt(i)) {
                ++i;
            }
        }
        return i >= c.length();
    }
}
