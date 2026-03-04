package com.htdong.leetcode.solution;

/**
 * @author htdong
 * @date 2018年4月8日 下午2:36:19
 */
public class LeetCode {

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        System.out.println(new Solution().countSubarrays(new int[] {25, 60, 17, 48}, 109));
        System.out.println("time = " + (System.currentTimeMillis() - t1));
    }
}