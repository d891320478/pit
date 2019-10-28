package com.htdong.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author htdong
 * @date 2018年4月8日 下午2:35:54
 */

public class Solution {

    public boolean canPartitionKSubsets(int[] c, int k) {
        int n = c.length;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += c[i];
        }
        if (sum % k != 0) {
            return false;
        }
        // TODO https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
        return true;
    }

    public static class Edge {
        int next, v, w, c;

        public Edge(int next, int v, int w, int c) {
            this.next = next;
            this.v = v;
            this.w = w;
            this.c = c;
        }
    }

    public int[] head;
    public Edge[] e;
    public int cnt;

    int[] d;
    int[] pre;
    boolean[] vis;

    public void init(int n, int m) {
        head = new int[n];
        for (int i = 0; i < n; ++i) {
            head[i] = -1;
        }
        e = new Edge[m];
        cnt = 0;
        d = new int[n];
        pre = new int[n];
        vis = new boolean[n];
    }

    public void addEdge(int u, int v, int w, int c) {
        e[cnt] = new Edge(head[u], v, w, c);
        head[u] = cnt++;
        e[cnt] = new Edge(head[v], u, 0, -c);
        head[v] = cnt++;
    }

    private boolean spfa(int s, int t, int n) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            pre[i] = -1;
            d[i] = -1;
        }
        d[s] = 0;
        q.add(s);
        while (!q.isEmpty()) {
            int u = q.poll();
            vis[u] = false;
            for (int i = head[u]; i != -1; i = e[i].next) {
                if (e[i].w > 0) {
                    if (d[e[i].v] == -1 || d[e[i].v] > d[u] + e[i].c) {
                        d[e[i].v] = d[u] + e[i].c;
                        pre[e[i].v] = i;
                        if (!vis[e[i].v]) {
                            q.add(e[i].v);
                            vis[e[i].v] = true;
                        }
                    }
                }
            }
        }
        return d[t] != -1;
    }

    public int findMinMoves(int[] ma) {
        int n = ma.length;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += ma[i];
        }
        if (sum % n > 0) {
            return -1;
        }
        int s = n;
        int t = s + 1;
        init(t + 1, n * 10);
        for (int i = 0; i < n; ++i) {
            addEdge(s, i, ma[i], 0);
            addEdge(i, t, sum / n, 0);
            if (i - 1 >= 0) {
                addEdge(i, i - 1, sum, 1);
            }
            if (i + 1 < n) {
                addEdge(i, i + 1, sum, 1);
            }
        }
        int ans = 0;
        while (spfa(s, t, t + 1)) {
            int u, mn = 1000000000;
            for (u = t; u != s; u = e[pre[u] ^ 1].v) {
                mn = Math.min(mn, e[pre[u]].w);
            }
            ans += mn * d[t];
            for (u = t; u != s; u = e[pre[u] ^ 1].v) {
                e[pre[u]].w -= mn;
                e[pre[u] ^ 1].w += mn;
            }
        }
        return ans;
    }

    private boolean f(String s, int l, int r) {
        switch (s.charAt(l)) {
        case '!':
            break;
        case '|':
            break;
        case '&':
            break;
        }
        return false;
    }

    public boolean parseBoolExpr(String expression) {
        // TODO https://leetcode.com/problems/parsing-a-boolean-expression/
        return f(expression, 0, expression.length() - 1);
    }

    public int longestSubstring(String s, int k) {
        // TODO
        // https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
        int[][] a = new int[26][s.length() + 1];
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 0; j < 26; ++j) {
                a[j][i] = a[j][i - 1];
                if (j == s.charAt(i - 1) - 'a') {
                    ++a[j][i];
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= s.length(); ++i) {
            int n = s.length();
            int ll = n, rr = 0;
            for (int j = 0; j < 26; ++j) {
                if (a[j][s.length()] == a[j][i - 1]) {
                    continue;
                }
            }
            ans = Math.max(ans, n - i + 1);
        }
        return ans;
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