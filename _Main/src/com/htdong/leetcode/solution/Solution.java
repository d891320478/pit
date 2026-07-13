package com.htdong.leetcode.solution;

import com.htdong.algorithm.Base;

/**
 * @author htdong
 * @date 2019年11月7日 下午4:56:49
 */
public class Solution extends Base {

    public int maxValidPairSum(int[] a, int k) {
        int n = a.length;
        int[] b = new int[n];
        b[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            b[i] = Math.max(b[i + 1], a[i]);
        }
        int mx = 0;
        for (int i = 0; i + k < n; ++i) {
            mx = Math.max(mx, a[i] + b[i + k]);
        }
        return mx;
    }
}