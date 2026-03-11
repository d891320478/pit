package com.htdong.leetcode.solution;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import com.htdong.algorithm.Base;

/**
 * @author htdong
 * @date 2019年11月7日 下午4:56:49
 */
public class Solution extends Base {

    public int[] p;

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public int maxStability(int n, int[][] edges, int k) {
        Arrays.sort(edges, (a, b) -> {
            return Integer.compare(b[2], a[2]);
        });
        p = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
        int min = Integer.MAX_VALUE;
        int edgeCount = 0;
        for (int[] edge : edges) {
            if (edge[3] == 1) {
                ++edgeCount;
                min = Math.min(min, edge[2]);
                int x = find(edge[0]);
                int y = find(edge[1]);
                if (x != y) {
                    p[x] = y;
                } else {
                    return -1;
                }
            }
        }
        Queue<Integer> q = new PriorityQueue<>();
        for (int[] edge : edges) {
            if (edgeCount == n - 1) {
                break;
            }
            if (edge[3] == 0) {
                int x = find(edge[0]);
                int y = find(edge[1]);
                if (x != y) {
                    q.add(edge[2]);
                    p[x] = y;
                    ++edgeCount;
                }
            }
        }
        Queue<Integer> q2 = new PriorityQueue<>();
        for (int i = 0; i < k && !q.isEmpty(); ++i) {
            q2.add(q.poll() * 2);
        }
        if (!q.isEmpty()) {
            min = Math.min(min, q.poll());
        }
        if (!q2.isEmpty()) {
            min = Math.min(min, q2.poll());
        }
        return edgeCount == n - 1 ? min : -1;
    }
}