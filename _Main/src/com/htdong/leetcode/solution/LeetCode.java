package com.htdong.leetcode.solution;

/**
 * @author htdong
 * @date 2018年4月8日 下午2:36:19
 */

public class LeetCode {
    public static void main(String[] args) {
        boolean[] f = new boolean[200000001];
        f[0] = f[1] = true;
        f[2] = false;
        for (int i = 2; i <= 200000000; ++i) {
            if (!f[i]) {
                for (int j = i + i; j < 200000000; j += i) {
                    f[j] = true;
                }
                if (g(i)) {
                    System.out.print(i + ",");
                    if (i > 100000000) {
                        break;
                    }
                }
            }
        }
    }

    private static boolean g(int i) {
        return new StringBuffer().append(i).reverse().toString().equals(i + "");
    }
}
