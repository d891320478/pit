package com.htdong.leetcode.main;

import com.htdong.leetcode.domain.ListNode;
import com.htdong.leetcode.solution.Solution;

/**
 * 
 * @author htdong
 * @date 2018年4月8日 下午2:36:19
 */

public class LeetCode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        new Solution().isPalindrome(head);
    }
}
