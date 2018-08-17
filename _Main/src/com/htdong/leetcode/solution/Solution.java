package com.htdong.leetcode.solution;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author htdong
 * @date 2018年4月8日 下午2:35:54
 */

public class Solution {

    public int maxDistToClosest(int[] seats) {
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < seats.length; ++i) {
            if (seats[i] == 1) {
                q.addLast(i);
            }
        }
        q.addFirst(-q.getFirst());
        q.addLast((seats.length - 1) * 2 - q.getLast());
        int x = q.removeFirst();
        int ans = 0;
        while (!q.isEmpty()) {
            int y = q.removeFirst();
            ans = Math.max(ans, (y - x) / 2);
            x = y;
        }
        return ans;
    }
}