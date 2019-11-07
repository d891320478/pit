package com.htdong.leetcode.solution;

/**
 * @author htdong
 * @date 2019年11月7日 下午4:56:49
 */
public class Solution {

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