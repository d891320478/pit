package com.htdong.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author htdong
 * @date 2019年11月7日 下午4:56:49
 */
public class Solution {

    public static int MOD = 1000000007;

    public int numWays(int s, int t) {
        if (t > s) {
            t = s;
        }
        int[][] d = new int[s + 1][t + 1];
        d[0][0] = 1;
        for (int i = 1; i <= s; ++i) {
            for (int j = 0; j <= t; ++j) {
                d[i][j] = (d[i - 1][j] + (j - 1 >= 0 ? d[i - 1][j - 1] : 0)) % MOD + (j + 1 <= t ? d[i - 1][j + 1] : 0);
                d[i][j] %= MOD;
            }
        }
        return d[s][0];
    }

    public static int idx(int l, int r) {
        return (l + r) | (l != r ? 1 : 0);
    }

    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public String toString() {
            return val + "";
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head) {
        Node next = head;
        while (next != null) {
            if (next.child != null) {
                Node nn = next.next;
                next.next = flatten(next.child);
                next.child = null;
                while (next.next != null) {
                    next = next.next;
                }
                next.next = nn;
                nn.prev = next;
                next = nn;
            } else {
                next = next.next;
            }
        }
        return head;
    }

    private void pushup(int[] tr, int l, int mid, int r) {
        tr[idx(l, r)] = Math.max(tr[idx(l, mid)], tr[idx(mid + 1, r)]);
    }

    private void pushdown(int[] tr, int[] lzy, int l, int mid, int r) {
        lzy[idx(l, mid)] += lzy[idx(l, r)];
        lzy[idx(mid + 1, r)] += lzy[idx(l, r)];
        tr[idx(l, mid)] += lzy[idx(l, r)];
        tr[idx(mid + 1, r)] += lzy[idx(l, r)];
        lzy[idx(l, r)] = 0;
    }

    private void update(int[] tr, int[] lzy, int l, int r, int s, int t, int v) {
        if (s <= l && t >= r) {
            tr[idx(l, r)] += v;
            lzy[idx(l, r)] += v;
            return;
        }
        int mid = l + r >> 1;
        pushdown(tr, lzy, l, mid, r);
        if (s <= mid) {
            update(tr, lzy, l, mid, s, t, v);
        }
        if (t > mid) {
            update(tr, lzy, mid + 1, r, s, t, v);
        }
        pushup(tr, l, mid, r);
    }

    public int longestSubstring(String s, int k) {
        // TODO
        // https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
        int n = s.length();
        int[][] a = new int[26][n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < 26; ++j) {
                a[j][i] = a[j][i - 1];
                if (j == s.charAt(i - 1) - 'a') {
                    ++a[j][i];
                }
            }
        }
        int ans = 0;
        int[] tr = new int[n * 2 + 10];
        int[] lzy = new int[n * 2 + 10];
        for (int i = 0; i < s.length(); ++i) {
            Queue<Integer> q1 = new LinkedList<>();
            Queue<Integer> q2 = new LinkedList<>();
            for (int j = 0; j < 26; ++j) {
                int l = i, r = s.length();
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    if (a[j][mid] > a[j][i]) {
                        r = mid - 1;
                    } else {
                        l = mid;
                    }
                }
                if (l > i) {
                    q1.add(i + 1);
                    q2.add(l);
                    update(tr, lzy, 1, n, i + 1, l, 1);
                }
            }
        }
        return ans;
    }
}