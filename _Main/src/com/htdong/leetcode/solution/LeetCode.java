package com.htdong.leetcode.solution;

/**
 * @author htdong
 * @date 2018年4月8日 下午2:36:19
 */

public class LeetCode {
    public static void main(String[] args) {
        double[] d = new Solution().medianSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3);
        for (double i : d) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
