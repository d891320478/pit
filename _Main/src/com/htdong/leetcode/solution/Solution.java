package com.htdong.leetcode.solution;

/**
 * @author htdong
 * @date 2018年4月8日 下午2:35:54
 */

public class Solution {

    public String orderlyQueue(String s, int k) {
        String ans = s;
        while (true) {
            boolean flag = false;
            for (int i = 0; i < k; ++i) {
                String t = s.substring(0, i) + s.substring(i + 1) + s.substring(i, i + 1);
                if (t.compareTo(ans) < 0) {
                    ans = t;
                    flag = true;
                }
            }
            if (flag) {
                s = ans;
            } else {
                break;
            }
        }
        return ans;
    }

    public int maxProfit(int[] p, int fee) {
        int[] d = new int[p.length];
        int[] e = new int[p.length];
        for (int i = 0; i < p.length; ++i) {
            e[i] = p[i] + fee;
        }
        // TODO
        // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
        for (int i = 1; i < p.length; ++i) {
            d[i] = d[i - 1];
            // d[i] = max(d[i], p[i]-p[k]-fee+d[k-1])
        }
        return d[p.length - 1];
    }
}