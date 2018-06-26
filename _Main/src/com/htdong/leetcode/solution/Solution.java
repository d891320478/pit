package com.htdong.leetcode.solution;

/**
 *
 * @author htdong
 * @date 2018年4月8日 下午2:35:54
 */

public class Solution {

    int sum;
    int[] head;
    int[] e, next;
    int cnt;

    private void add(int u, int v) {
        next[cnt] = head[u];
        e[cnt] = v;
        head[u] = cnt++;
    }

    public int[] sumOfDistancesInTree(int n, int[][] ed) {
        int[] sz = new int[n];
        int[] ans = new int[n];
        head = new int[n];
        next = new int[n << 1];
        e = new int[n << 1];
        cnt = 0;
        sum = 0;
        for (int i = 0; i < n; ++i) {
            head[i] = -1;
        }
        for (int i = 0; i + 1 < n; ++i) {
            add(ed[i][0], ed[i][1]);
            add(ed[i][1], ed[i][0]);
        }
        dfs(0, -1, sz, 0);
        ans[0] = sum;
        dfs(0, -1, ans, sz, n);
        return ans;
    }

    private void dfs(int u, int p, int[] ans, int[] sz, int n) {
        if (u == p) {
            return;
        }
        if (u != 0) {
            ans[u] = ans[p] - sz[u] + n - sz[u];
        }
        for (int i = head[u]; i != -1; i = next[i]) {
            if (e[i] != p) {
                dfs(e[i], u, ans, sz, n);
            }
        }
    }

    private void dfs(int u, int p, int[] sz, int dis) {
        if (u == p) {
            return;
        }
        sum += dis;
        sz[u] = 1;
        for (int i = head[u]; i != -1; i = next[i]) {
            if (e[i] != p) {
                dfs(e[i], u, sz, dis + 1);
                sz[u] += sz[e[i]];
            }
        }
    }
}
