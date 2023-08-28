package com.htdong.leetcode.solution;

import com.htdong.leetcode.algorithm.Base;

/**
 * @author htdong
 * @date 2019年11月7日 下午4:56:49
 */
public class Solution extends Base {
    public int findNonMinOrMax(int[] a) {
        int mn = a[0];
        int mx = a[0];
        for (int i = 1; i < a.length; ++i) {
            mn = Math.min(mn, a[i]);
            mx = Math.max(mx, a[i]);
        }
        int ans = -1;
        for (int i = 0; i < a.length; ++i) {
            if (a[i] != mn && a[i] != mx) {
                ans = a[i];
                break;
            }
        }
        return ans;
    }
}