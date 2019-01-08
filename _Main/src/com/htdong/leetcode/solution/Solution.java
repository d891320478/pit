package com.htdong.leetcode.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author htdong
 * @date 2018年4月8日 下午2:35:54
 */

public class Solution {

    public static class Point {
        int x, y;

        public Point(int[] o) {
            this.x = o[0];
            this.y = o[1];
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    public static int MOD = 1000000007;
    public static int[] dx = { 1, 0, -1, 0 };
    public static int[] dy = { 0, -1, 0, 1 };

    public static int dot(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.x - a.x) + (b.y - a.y) * (c.y - a.y);
    }

    public static int xmult(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }

    public static int idx(int l, int r) {
        return (l + r) | (l != r ? 1 : 0);
    }

    class Edge {
        int next, v, w;

        public Edge(int next, int v, int w) {
            this.next = next;
            this.v = v;
            this.w = w;
        }
    }

    int[] head;
    Edge[] e;
    int cnt;

    public void init(int n) {
        head = new int[n];
        for (int i = 0; i < n; ++i) {
            head[i] = -1;
        }
        e = new Edge[n << 1];
        cnt = 0;
    }

    public void addEdge(int u, int v, int w) {
        e[cnt] = new Edge(head[u], v, w);
        head[u] = cnt++;
    }

    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int[][] d = new int[map.size() + 1][2];
        int[] a = new int[map.size()];
        int[] b = new int[map.size()];
        int j = 0;
        for (Map.Entry<Integer, Integer> iter : map.entrySet()) {
            a[j] = iter.getKey();
            b[j] = iter.getValue();
            ++j;
        }
        d[0][0] = 0;
        d[0][1] = a[0] * b[0];
        for (int i = 1; i < map.size(); ++i) {
            d[i][0] = Math.max(d[i - 1][0], d[i - 1][1]);
            if (a[i] == a[i - 1] + 1) {
                d[i][1] = d[i - 1][0] + a[i] * b[i];
            } else {
                d[i][1] = Math.max(d[i - 1][0], d[i - 1][1]) + a[i] * b[i];
            }
        }
        return Math.max(d[map.size() - 1][0], d[map.size() - 1][1]);
    }
}