package com.htdong.leetcode.solution;

/**
 * @author htdong
 * @date 2018年4月8日 下午2:36:19
 */
public class LeetCode {

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        System.out.println(new Solution().countStableSubarrays(new int[] {1, 2, 3, 4}, new int[][] {{2, 2}, {3, 3}}));
        System.out.println("time = " + (System.currentTimeMillis() - t1));
    }
}