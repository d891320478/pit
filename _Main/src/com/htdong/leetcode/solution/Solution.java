package com.htdong.leetcode.solution;

/**
 *
 * @author htdong
 * @date 2018年4月8日 下午2:35:54
 */

public class Solution {

    public boolean splitArraySameAverage(int[] a) {
        if (a.length == 1) {
            return false;
        }
        int ans = 0;
        int n = a.length;
        for (int i = 0; i < n; ++i) {
            ans += a[i];
        }
        for (int i = 1; i <= (n + 1) / 2; ++i) {
            if (ans * i % n == 0) {
                if (check(a, i, ans * i / n)) {
                    System.out.println(ans * i / n);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(int[] a, int n, int sum) {
        boolean[][] d = new boolean[n + 5][sum + 5];
        d[0][0] = true;
        for (int i = 0; i < a.length; ++i)
            for (int j = Math.min(n, i + 1); j > 0; --j)
                for (int k = a[i]; k <= sum; ++k)
                    if (d[j - 1][k - a[i]]) {
                        d[j][k] = true;
                    }
        return d[n][sum];
    }

}
