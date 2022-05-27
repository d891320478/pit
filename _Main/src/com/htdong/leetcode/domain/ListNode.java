package com.htdong.leetcode.domain;

/**
 *
 * @author htdong
 * @date 2018年4月8日 下午2:34:57
 */

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return val + (next != null ? "->" + next.toString() : "");
    }
}
