package com.htdong.leetcode.solution;

import com.htdong.algorithm.Base;
import java.util.Map;
import java.util.HashMap;

/**
 * @author htdong
 * @date 2019年11月7日 下午4:56:49
 */
public class Solution extends Base {

    public static class Rmq {

        private static final int M = 25;

        private int[][] or;
        private int[] p, idx;

        public Rmq(int n) {
            or = new int[M][n];
            p = new int[M];
            idx = new int[n + 1];
            idx[0] = -1;
            for (int i = 1; i <= n; i++) {
                idx[i] = idx[i - 1] + ((i & (i - 1)) == 0 ? 1 : 0);
            }
            for (int i = 0; i < M; i++) {
                p[i] = 1 << i;
            }
        }

        public void init(int[] a) {
            int n = a.length;
            for (int i = 0; i < n; i++) {
                or[0][i] = a[i];
            }
            for (int i = 1; p[i] <= n; i++) {
                for (int j = 0; j + p[i] - 1 < n; j++) {
                    or[i][j] = or[i - 1][j] | or[i - 1][j + p[i - 1]];
                }
            }
        }

        public int or(int l, int r) {
            int t = idx[r - l + 1];
            return or[t][l] | or[t][r - p[t] + 1];
        }
    }

    public long countGoodSubarrays(int[] a) {
        Map<Integer, Long> map = new HashMap<>();
        int n = a.length;
        Rmq rmq = new Rmq(n);
        rmq.init(a);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int l = 0, r = i;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (rmq.or(mid, i) > a[i]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            long ll = l;
            l = i;
            r = n - 1;
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if (rmq.or(i, mid) <= a[i]) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            long rr = l;
            if (map.containsKey(a[i])) {
                long p = map.get(a[i]) + 1;
                ll = Math.max(ll, p);
            }
            map.put(a[i], (long) i);
            ans += (rr - i + 1) * (i - ll + 1);
        }
        return ans;
    }
}