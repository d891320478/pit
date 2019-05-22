package com.htdong.leetcode.algorithm;

public class Graph {
    public static class Edge {
        int next, v, w;

        public Edge(int next, int v, int w) {
            this.next = next;
            this.v = v;
            this.w = w;
        }
    }

    public int[] head;
    public Edge[] e;
    public int cnt;

    public void init(int n, int m) {
        head = new int[n];
        for (int i = 0; i < n; ++i) {
            head[i] = -1;
        }
        e = new Edge[m];
        cnt = 0;
    }

    public void addEdge(int u, int v, int w) {
        e[cnt] = new Edge(head[u], v, w);
        head[u] = cnt++;
    }
}
