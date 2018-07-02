package com.htdong.leetcode.solution;

/**
 *
 * @author htdong
 * @date 2018年4月8日 下午2:35:54
 */

public class Solution {

    public int shortestSubarray(int[] a, int k) {
        int[] b = new int[a.length + 1];
        b[0] = 0;
        for (int i = 0; i < a.length; ++i) {
            b[i + 1] = b[i] + a[i];
        }
        int ans = -1;
        
        return ans;
    }
}
