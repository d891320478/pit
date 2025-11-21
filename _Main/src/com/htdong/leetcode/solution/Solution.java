package com.htdong.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

import com.htdong.leetcode.algorithm.Base;

/**
 * @author htdong
 * @date 2019年11月7日 下午4:56:49
 */
public class Solution extends Base {

    public static class Pair {

        public int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public long getAns() {
            long n = b - a + 1;
            return n * (n + 1) / 2;
        }

        public String toString() {
            return String.format("{%d, %d}", a, b);
        }
    }

    public long[] countStableSubarrays(int[] a, int[][] qu) {
        List<Pair> list = new ArrayList<>();
        list.add(new Pair(-1, -1));
        int n = a.length;
        for (int i = 0; i < n;) {
            int j = i + 1;
            for (; j < n;) {
                if (a[j] >= a[j - 1]) {
                    ++j;
                } else {
                    break;
                }
            }
            list.add(new Pair(i, j - 1));
            i = j;
        }
        list.add(new Pair(n + 1, n));
        long[] b = new long[list.size()];
        for (int i = 1; i < list.size(); ++i) {
            b[i] = b[i - 1] + list.get(i).getAns();
        }
        long[] ans = new long[qu.length];
        for (int _i = 0; _i < qu.length; ++_i) {
            int l = 0, r = list.size() - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (list.get(mid).a < qu[_i][0]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            int ll = l;
            l = 0;
            r = list.size() - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (list.get(mid).b > qu[_i][1]) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            int rr = r;
            if (ll <= rr) {
                ans[_i] = b[rr] - b[ll - 1];
                if (qu[_i][0] < list.get(ll).a) {
                    int m = list.get(ll).a - qu[_i][0];
                    ans[_i] += m * (m + 1) / 2;
                }
                if (list.get(rr).b < qu[_i][1]) {
                    int m = qu[_i][1] - list.get(rr).b;
                    ans[_i] += m * (m + 1) / 2;
                }
            } else {
                int m = qu[_i][1] - qu[_i][0] + 1;
                ans[_i] += m * (m + 1) / 2;
            }
        }
        return ans;
    }
}