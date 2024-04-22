package com.htdong.leetcode.solution;

import com.htdong.leetcode.algorithm.Base;

/**
 * @author htdong
 * @date 2019年11月7日 下午4:56:49
 */
public class Solution extends Base {

    static class Trie {
        public int end;
        public Trie[] next;
        public int len;

        public Trie(int len) {
            this.end = 0;
            this.next = new Trie[len];
            this.len = len;
        }

        public static void insert(Trie node, String a) {
            for (int i = 0; i < a.length(); ++i) {
                int v = a.charAt(i) - 'a';
                if (node.next[v] == null) {
                    node.next[v] = new Trie(node.len);
                }
                node = node.next[v];
            }
            ++node.end;
        }
    }

    public long countPrefixSuffixPairs(String[] w) {
        Trie root = new Trie(26);
        long ans = 0;
        Trie.insert(root, w[0]);
        for (int i = 1; i < w.length; ++i) {
            int[] p = new int[w[i].length()];
            p[0] = -1;
        }
        return ans;
    }

    public int findNonMinOrMax(int[] a) {
        int mn = a[0];
        int mx = a[0];
        for (int i = 1; i < a.length; ++i) {
            mn = Math.min(mn, a[i]);
            mx = Math.max(mx, a[i]);
        }
        int ans = -1;
        for (int i = 0; i < a.length; ++i) {
            if (a[i] != mn && a[i] != mx) {
                ans = a[i];
                break;
            }
        }
        return ans;
    }
}