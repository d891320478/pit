package com.htdong.leetcode.main;

import com.htdong.leetcode.solution.Solution;

/**
 * 
 * @author htdong
 * @date 2018年4月8日 下午2:36:19
 */

public class LeetCode {
    public static void main(String[] args) {
        String[] s = { "oath", "pea", "eat", "rain" };
        char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' } };
        System.out.println(new Solution().findWords(board, s));
    }
}
