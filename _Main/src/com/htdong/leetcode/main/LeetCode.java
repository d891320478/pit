package com.htdong.leetcode.main;

import com.htdong.leetcode.solution.TopVotedCandidate;

/**
 * 
 * @author htdong
 * @date 2018年4月8日 下午2:36:19
 */

public class LeetCode {
    public static void main(String[] args) {
        int p[] = { 0, 0, 1, 1, 2 };
        int t[] = { 0, 67, 69, 74, 87 };
        new TopVotedCandidate(p, t);
    }
}
