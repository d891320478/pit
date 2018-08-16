package com.htdong.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author htdong
 * @date 2018年4月8日 下午2:35:54
 */

public class Solution {

    int[] dx = { 1, 0, -1, 0 };
    int[] dy = { 0, 1, 0, -1 };

    public int largestIsland(int[][] g) {
        int ans = cnt(g);
        for (int i = 0; i < g.length; ++i)
            for (int j = 0; j < g[i].length; ++j)
                if (g[i][j] == 0) {
                    g[i][j] = 1;
                    ans = Math.max(ans, cnt(g));
                    g[i][j] = 0;
                }
        return ans;
    }

    private int cnt(int[][] g) {
        boolean[][] vis = new boolean[g.length][g[0].length];
        int ans = 0;
        for (int i = 0; i < g.length; ++i)
            for (int j = 0; j < g[i].length; ++j)
                if (!vis[i][j] && g[i][j] == 1) {
                    vis[i][j] = true;
                    int cnt = 0;
                    Queue<int[]> q = new LinkedList<>();
                    int[] z = new int[2];
                    z[0] = i;
                    z[1] = j;
                    q.add(z);
                    while (!q.isEmpty()) {
                        ++cnt;
                        int[] x = q.poll();
                        for (int k = 0; k < 4; ++k) {
                            if (x[0] + dx[k] >= 0 && x[0] + dx[k] < g.length)
                                if (x[1] + dy[k] >= 0 && x[1] + dy[k] < g[0].length)
                                    if (g[x[0] + dx[k]][x[1] + dy[k]] == 1)
                                        if (!vis[x[0] + dx[k]][x[1] + dy[k]]) {
                                            z = new int[2];
                                            z[0] = x[0] + dx[k];
                                            z[1] = x[1] + dy[k];
                                            q.add(z);
                                            vis[z[0]][z[1]] = true;
                                        }
                        }
                    }
                    ans = Math.max(ans, cnt);
                }
        return ans;
    }
}