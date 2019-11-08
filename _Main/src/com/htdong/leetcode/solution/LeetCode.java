package com.htdong.leetcode.solution;

/**
 * @author htdong
 * @date 2018年4月8日 下午2:36:19
 */

public class LeetCode {
    public static void main(String[] args) {
        Solution.Node head = new Solution.Node(1, null, null, null);
        Solution.Node next = head;
        next = next.next = new Solution.Node(2, next, null, null);
        next = next.next = new Solution.Node(3, next, null, null);
        next.next = new Solution.Node(4, next, null, null);
        next = next.child = new Solution.Node(7, next, null, null);
        next = next.next = new Solution.Node(8, next, null, null);
        Solution.Node rlt = new Solution().flatten(head);
        while (rlt != null) {
            System.out.println(rlt + " " + rlt.next + " " + rlt.prev + " " + rlt.child);
            rlt = rlt.next;
        }
    }
}
