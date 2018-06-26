package com.htdong.leetcode.main;

import com.htdong.leetcode.solution.Solution;

/**
 * 
 * @author htdong
 * @date 2018年4月8日 下午2:36:19
 */

public class LeetCode {
    public static void main(String[] args) {
        int[] q = { 10, 20, 5 };
        int[] w = { 70, 50, 30 };
        int m = 2;
        System.out.println(new Solution().mincostToHireWorkers(q, w, m));
    }
}
