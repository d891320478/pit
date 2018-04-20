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
        int n = in.nextInt();
        while (n > 0) {
            --n;
            String s = in.next();
            if (s.length() <= 10) {
                System.out.println(s);
            } else {
                System.out.println(s.charAt(0) + "" + (s.length() - 2) + s.charAt(s.length() - 1));
            }
        }
        in.close();
    }
}
