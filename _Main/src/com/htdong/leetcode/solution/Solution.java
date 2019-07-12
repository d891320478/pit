package com.htdong.leetcode.solution;

import java.util.Arrays;

/**
 * @author htdong
 * @date 2018年4月8日 下午2:35:54
 */

public class Solution {

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

    public int removeStones(int[][] s) {
        int n = s.length;
        init(n, n * (n - 1));
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (s[i][0] == s[j][0] || s[i][1] == s[j][1]) {
                    addEdge(i, j, 0);
                    addEdge(j, i, 0);
                }
            }
        }
        boolean[] vis = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (!vis[i]) {
                ans += dfs(i, vis) - 1;
            }
        }
        return ans;
    }

    private int dfs(int u, boolean[] vis) {
        vis[u] = true;
        int cnt = 1;
        for (int i = head[u]; i != -1; i = e[i].next) {
            if (!vis[e[i].v]) {
                cnt += dfs(e[i].v, vis);
            }
        }
        return cnt;
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] ret = new int[deck.length];
        // TODO https://leetcode.com/problems/reveal-cards-in-increasing-order/
        return ret;
    }

    public int maxProfit(int[] p, int fee) {
        int[] d = new int[p.length];
        int[] e = new int[p.length];
        for (int i = 0; i < p.length; ++i) {
            e[i] = p[i] + fee;
        }
        // TODO
        // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
        for (int i = 1; i < p.length; ++i) {
            d[i] = d[i - 1];
            // d[i] = max(d[i], p[i]-p[k]-fee+d[k-1])
        }
        return d[p.length - 1];
    }
}