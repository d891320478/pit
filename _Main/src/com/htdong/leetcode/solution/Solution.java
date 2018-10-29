package com.htdong.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author htdong
 * @date 2018年4月8日 下午2:35:54
 */

public class Solution {

    public static int MOD = 1000000007;

    public static int idx(int l, int r) {
        return (l + r) | (l != r ? 1 : 0);
    }

    public int maxProfit(int[] p) {
        int n = p.length;
        // System.out.println(n);
        int[] dp = new int[n + 5];
        int[] tr = new int[n + 5];
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j < i; ++j) {
                dp[i] = Math.max(dp[i], p[i - 1] - p[j - 1]);
                if (j - 2 >= 0) {
                    dp[i] = Math.max(dp[i], p[i - 1] - p[j - 1] + tr[j - 2]);
                }
            }
            ans = Math.max(ans, dp[i]);
            tr[i] = ans;
        }
        return ans;
    }
}