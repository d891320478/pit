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
    int[] dx = { 1, 0, -1, 0 };
    int[] dy = { 0, 1, 0, -1 };
    boolean flag;

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>();
        for (String s : words) {
            flag = false;
            boolean[][] f = new boolean[board.length][];
            for (int i = 0; i < board.length; ++i) {
                f[i] = new boolean[board[i].length];
            }
            for (int i = 0; i < board.length && !flag; ++i) {
                for (int j = 0; j < board[i].length && !flag; ++j) {
                    if (board[i][j] == s.charAt(0)) {
                        f[i][j] = true;
                        dfs(board, s, f, i, j, 1);
                        f[i][j] = false;
                        if (flag) {
                            set.add(s);
                        }
                    }
                }
            }
        }
        return new LinkedList<>(set);
    }

    private void dfs(char[][] board, String s, boolean[][] f, int x, int y, int i) {
        if (flag) {
            return;
        }
        if (i >= s.length()) {
            flag = true;
            return;
        }
        for (int j = 0; j < 4; ++j) {
            if (x + dx[j] >= 0 && x + dx[j] < board.length) {
                if (y + dy[j] >= 0 && y + dy[j] < board[x + dx[j]].length) {
                    if (!f[x + dx[j]][y + dy[j]] && s.charAt(i) == board[x + dx[j]][y + dy[j]]) {
                        f[x + dx[j]][y + dy[j]] = true;
                        dfs(board, s, f, x + dx[j], y + dy[j], i + 1);
                        f[x + dx[j]][y + dy[j]] = false;
                    }
                }
            }
        }
    }
}
