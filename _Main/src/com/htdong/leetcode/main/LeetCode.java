package com.htdong.leetcode.main;

/**
 * 
 * @author htdong
 * @date 2018年4月8日 下午2:36:19
 */

public class LeetCode {
    public static void main(String[] args) {
        long ans = 0;
        for (long i = 9990000; i < 10000000; ++i) {
            for (long j = 9990000; j < 10000000; ++j) {
                if (check(i * j)) {
                    ans = Math.max(i * j, ans);
                    if (i * j == 9966006699L) {
                        System.out.println(i + " " + j);
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static boolean check(Long k) {
        if (k.toString().equals(new StringBuffer().append(k.toString()).reverse().toString())) {
            return true;
        }
        return false;
    }
}
