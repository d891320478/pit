package com.htdong.leetcode.solution;

/**
 *
 * @author htdong
 * @date 2018年4月8日 下午2:35:54
 */

public class Solution {

    public static int MOD = 1000000007;

    public static int idx(int l, int r) {
        return (l + r) | (l != r ? 1 : 0);
    }

    int[] tr;

    public void build(int[] tr, int l, int r, int[] a) {
        if (l == r) {
            tr[idx(l, r)] = a[l];
            return;
        }
        int mid = l + r >> 1;
        build(tr, l, mid, a);
        build(tr, mid + 1, r, a);
        tr[idx(l, r)] = Math.min(tr[idx(l, mid)], tr[idx(mid + 1, r)]);
    }

    public int query(int l, int r, int s, int t) {
        if (s <= l && r >= t) {
            return tr[idx(l, r)];
        }
        int mid = l + r >> 1;
        if (t <= mid) {
            return query(l, mid, s, t);
        } else if (s > mid) {
            return query(mid + 1, r, s, t);
        } else {
            return Math.min(query(l, mid, s, t), query(mid + 1, r, s, t));
        }
    }

    public int sumSubarrayMins(int[] a) {
        int n = a.length;
        tr = new int[n * 2 + 5];
        build(tr, 0, n - 1, a);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int l = 0, r = i - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (query(0, n - 1, mid, i - 1) > a[i]) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            int x = l;
            l = i + 1;
            r = n - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (query(0, n - 1, i + 1, mid) > a[i]) {
                    l = mid;
                }
            }
        }
        // TODO
        return 0;
    }
}