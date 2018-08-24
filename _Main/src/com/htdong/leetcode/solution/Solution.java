package com.htdong.leetcode.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.htdong.leetcode.domain.ListNode;

/**
 *
 * @author htdong
 * @date 2018年4月8日 下午2:35:54
 */

public class Solution {

    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode h1 = head;
        while (h1 != null) {
            ++len;
            h1 = h1.next;
        }
        if (len < 2) {
            return true;
        }
        h1 = head;
        int c = 0;
        while (c < (len + 1) / 2) {
            h1 = h1.next;
            ++c;
        }
        ListNode h2 = head, tail = null, next = h2.next;
        while (h2 != h1) {
            h2.next = tail;
            tail = h2;
            h2 = next;
            next = h2.next;
        }
        if (len % 2 > 0) {
            tail = tail.next;
        }
        while (h1 != null) {
            if (h1.val != tail.val) {
                return false;
            }
            h1 = h1.next;
            tail = tail.next;
        }
        return true;
    }

}