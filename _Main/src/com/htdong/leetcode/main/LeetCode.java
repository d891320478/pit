package com.htdong.leetcode.main;

import com.htdong.leetcode.solution.Solution;

/**
 * 
 * @author htdong
 * @date 2018年4月8日 下午2:36:19
 */

public class LeetCode {
    public static void main(String[] args) {
        String[] a = { "amazon", "apple", "facebook", "google", "leetcode" };
        String[] b = { "e", "o" };
        System.out.println(new Solution().wordSubsets(a, b));
    }
}
