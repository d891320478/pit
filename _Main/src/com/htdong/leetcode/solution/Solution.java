package com.htdong.leetcode.solution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
    public static int[] cx = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
    public static int[] cy = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };

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

    public int mergeStones(int[] a, int k) {
        int n = a.length;
        if ((n - 1) % (k - 1) > 0) {
            return -1;
        }
        int[][] d = new int[n][n];
        for (int i = 0; i + k - 1 < n; ++i) {
            for (int j = i; j <= i + k - 1; ++j) {
                d[i][i + k - 1] += a[j];
            }
        }
        for (int i = k; i < n; ++i) {
            for (int j = 0; j + i - 1 < n; ++j) {
                for (int l = j; l < j + i - 1; ++l) {
                    if (d[j][l] > 0 && d[l + 1][j + i - 1] > 0) {
                        d[j][j + i - 1] = d[j][j + i - 1] == 0 ? d[j][l] + d[l + 1][j + i - 1]
                                : Math.min(d[j][j + i - 1], d[j][l] + d[l + 1][j + i - 1]);
                    }
                }
            }
        }
        return d[0][n - 1];
    }
}