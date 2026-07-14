package com.htdong.leetcode.solution;

import com.htdong.algorithm.Base;

/**
 * @author htdong
 * @date 2019年11月7日 下午4:56:49
 */
public class Solution extends Base {

    public String[] createGrid(int n, int m, int k) {
        char[][] g = new char[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                g[i][j] = '#';
            }
        }
        for (int i = 0; i < n; ++i) {
            g[i][0] = '.';
        }
        for (int i = 0; i < m; ++i) {
            g[n - 1][i] = '.';
        }
        for (int i = 2; i <= k; ++i) {
            if (n == 1) {
                return new String[0];
            }
            int j = 0;
            for (; j < m; ++j) {
                if (g[n - 2][j] == '#') {
                    g[n - 2][j] = '.';
                    break;
                }
            }
            if (j == m) {
                return new String[0];
            }
        }
        String[] s = new String[n];
        for (int i = 0; i < n; ++i) {
            s[i] = new String(g[i]);
        }
        return s;
    }
}