package com.htdong.leetcode.main;

import com.htdong.leetcode.solution.Solution;

/**
 * 
 * @author htdong
 * @date 2018年4月8日 下午2:36:19
 */

public class LeetCode {
    public static void main(String[] args) {
        int n = 6;
        int[][] e = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 }, { 2, 5 } };
        int[] ans = new Solution().sumOfDistancesInTree(n, e);
        for (int i : ans) {
            System.out.println(i);
        }
    }
}
