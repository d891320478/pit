package com.htdong.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

import com.htdong.leetcode.algorithm.Base;

/**
 * @author htdong
 * @date 2019年11月7日 下午4:56:49
 */
public class Solution extends Base {
    public int maxPathScore(int[][] a, int z) {
        ++z;
        int n = a.length;
        int m = a[0].length;
        int[][][] dp = new int[n][m][z];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                for (int k = 0; k < z; ++k) {
                    dp[i][j][k] = -1;
                }
            }
        }
        dp[0][0][0] = a[0][0];
        boolean[][][] vis = new boolean[n][m][z];
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        Queue<Integer> q3 = new LinkedList<>();
        q1.add(0);
        q2.add(0);
        q3.add(0);
        while (!q1.isEmpty()) {
            int x = q1.poll();
            int y = q2.poll();
            int w = q3.poll();
            vis[x][y][w] = false;
            System.out.printf("%d %d %d %d\n", x, y, w, dp[x][y][w]);
            if (x + 1 < n) {
                if (a[x + 1][y] == 0) {
                    if (dp[x + 1][y][w] < dp[x][y][w]) {
                        dp[x + 1][y][w] = dp[x][y][w];
                        if (!vis[x + 1][y][w]) {
                            vis[x + 1][y][w] = true;
                            q1.add(x + 1);
                            q2.add(y);
                            q3.add(w);
                        }
                    }
                } else if (w + 1 < z) {
                    if (dp[x + 1][y][w + 1] < dp[x][y][w] + a[x + 1][y]) {
                        dp[x + 1][y][w + 1] = dp[x][y][w] + a[x + 1][y];
                        if (!vis[x + 1][y][w + 1]) {
                            vis[x + 1][y][w + 1] = true;
                            q1.add(x + 1);
                            q2.add(y);
                            q3.add(w + 1);
                        }
                    }
                }
            }
            if (y + 1 < m) {
                if (a[x][y + 1] == 0) {
                    if (dp[x][y + 1][w] < dp[x][y][w]) {
                        dp[x][y + 1][w] = dp[x][y][w];
                        if (!vis[x][y + 1][w]) {
                            vis[x][y + 1][w] = true;
                            q1.add(x);
                            q2.add(y + 1);
                            q3.add(w);
                        }
                    }
                } else if (w + 1 < z) {
                    if (dp[x][y + 1][w + 1] < dp[x][y][w] + a[x][y + 1]) {
                        dp[x][y + 1][w + 1] = dp[x][y][w] + a[x][y + 1];
                        if (!vis[x][y + 1][w + 1]) {
                            vis[x][y + 1][w + 1] = true;
                            q1.add(x);
                            q2.add(y + 1);
                            q3.add(w + 1);
                        }
                    }
                }
            }
        }
        int ans = -1;
        for (int i = 0; i < z; ++i) {
            ans = Math.max(ans, dp[n - 1][m - 1][i]);
        }
        return ans;
    }
}