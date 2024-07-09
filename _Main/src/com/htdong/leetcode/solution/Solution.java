package com.htdong.leetcode.solution;

import java.util.List;

import com.htdong.leetcode.algorithm.Base;

/**
 * @author htdong
 * @date 2019年11月7日 下午4:56:49
 */
public class Solution extends Base {

    void build(int[] tr, int l, int r, List<Integer> a) {
        if (l == r) {
            tr[idx(l, r)] = a.get(l);
            return;
        }
        int mid = l + r >> 1;
        build(tr, l, mid, a);
        build(tr, mid + 1, r, a);
        tr[idx(l, r)] = Math.min(tr[idx(l, mid)], tr[idx(mid + 1, r)]);
    }

    int min(int[] tr, int l, int r, int s, int t) {
        if (s <= l && t >= r) {
            return tr[idx(l, r)];
        }
        int mid = l + r >> 1;
        if (t <= mid) {
            return min(tr, l, mid, s, t);
        } else if (s > mid) {
            return min(tr, mid + 1, r, s, t);
        }
        return Math.min(min(tr, l, mid, s, t), min(tr, mid + 1, r, s, t));
    }

    public long maximumSumOfHeights(List<Integer> a) {
        int n = a.size();
        long[] b = new long[n];
        long[] c = new long[n];
        // long[] s = new long[n];
        // s[0] = a.get(0);
        // for (int i = 1; i < n; ++i) {
        // s[i] = s[i - 1] + a.get(i);
        // }
        int[] tr = new int[n * 2 + 5];
        build(tr, 0, n - 1, a);
        b[0] = a.get(0);
        for (int i = 1; i < n; ++i) {
            int l = 0, r = i - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (min(tr, 0, n - 1, mid, i - 1) < a.get(i)) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (l == i - 1 && a.get(l) < a.get(i)) {
                ++l;
            }
            long bb = (l == 0 ? 0 : b[l - 1]);
            b[i] = a.get(i) * (i - l + 1) + bb;
        }
        c[n - 1] = a.get(n - 1);
        for (int i = n - 2; i >= 0; --i) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (min(tr, 0, n - 1, i + 1, mid) > a.get(i)) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (l == i + 1 && a.get(l) < a.get(i)) {
                l--;
            }
            long cc = (l == n - 1 ? 0 : c[l + 1]);
            c[i] = a.get(i) * (l - i + 1) + cc;
        }
        long ans = -1;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, b[i] + c[i] - a.get(i));
        }
        return ans;
    }

    public char repeatedCharacter(String s) {
        boolean[] vis = new boolean[128];
        for (int i = 0; i < s.length(); ++i) {
            char v = s.charAt(i);
            if (vis[v]) {
                return v;
            }
            vis[v] = true;
        }
        return 0;
    }

    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int i : chalk) {
            sum += i;
        }
        k %= sum;
        for (int i = 0; i < chalk.length; ++i) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }
        return 0;
    }
}