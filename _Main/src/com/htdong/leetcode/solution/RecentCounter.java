package com.htdong.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author htdong
 * @date 2018年11月5日 下午4:06:31
 */

public class RecentCounter {

    private Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        q.add(t);
        while (q.peek() < t - 3000) {
            q.poll();
        }
        return q.size();
    }
}
