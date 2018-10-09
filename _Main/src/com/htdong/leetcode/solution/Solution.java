package com.htdong.leetcode.solution;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author htdong
 * @date 2018年4月8日 下午2:35:54
 */

public class Solution {

    int[] tr;

    public int partitionDisjoint(int[] a) {
        int n = a.length;
        tr = new int[n * 2 + 5];
        build(0, n - 1, a);
        int mx = a[0];
        for (int i = 1; i < n; ++i) {
            if (mx <= query(0, n - 1, i, n - 1)) {
                return i;
            }
            if (a[i] > mx) {
                mx = a[i];
            }
        }
        return n;
    }

    private int query(int l, int r, int s, int t) {
        if (s <= l && t >= r) {
            return tr[idx(l, r)];
        }
        int mid = l + r >> 1;
        if (s <= mid && t > mid) {
            return Math.min(query(l, mid, s, t), query(mid + 1, r, s, t));
        } else if (s <= mid) {
            return query(l, mid, s, t);
        } else {
            return query(mid + 1, r, s, t);
        }
    }

    private void build(int l, int r, int[] a) {
        if (l == r) {
            tr[idx(l, r)] = a[l];
            return;
        }
        int mid = l + r >> 1;
        build(l, mid, a);
        build(mid + 1, r, a);
        tr[idx(l, r)] = Math.min(tr[idx(l, mid)], tr[idx(mid + 1, r)]);
    }

    private int idx(int l, int r) {
        return (l + r) | (l != r ? 1 : 0);
    }

    public List<String> wordSubsets(String[] a, String[] b) {
        List<String> rlt = new LinkedList<>();
        int[] c1 = new int[26];
        for (int i = 0; i < b.length; ++i) {
            int[] c2 = new int[26];
            for (int j = 0; j < b[i].length(); ++j) {
                ++c2[b[i].charAt(j) - 'a'];
            }
            for (int j = 0; j < 26; ++j) {
                if (c1[j] < c2[j]) {
                    c1[j] = c2[j];
                }
            }
        }
        for (int i = 0; i < a.length; ++i) {
            int[] c2 = new int[26];
            for (int j = 0; j < a[i].length(); ++j) {
                ++c2[a[i].charAt(j) - 'a'];
            }
            boolean flag = true;
            for (int j = 0; j < 26; ++j) {
                if (c2[j] < c1[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                rlt.add(a[i]);
            }
        }
        return rlt;
    }
}