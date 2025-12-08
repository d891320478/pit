package com.htdong.leetcode.algorithm;

public class Base {
    public static int MOD = 1000000007;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int[] cx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    public static int[] cy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    public static int[] ex = {-1, -2, -2, -1, 1, 2, 2, 1};
    public static int[] ey = {-2, -1, 1, 2, -2, -1, 1, 2};

    public static int idx(int l, int r) {
        return (l + r) | (l != r ? 1 : 0);
    }

    public static long power(long a, long b, long p) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) > 0) {
                ans = ans * a % p;
            }
            a = a * a % p;
            b >>= 1;
        }
        return ans;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int lowbit(int x) {
        return x & (-x);
    }

    public static class Pair implements Comparable<Pair> {
        public int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(a) ^ Integer.hashCode(b);
        }

        @Override
        public boolean equals(Object p) {
            if (p == null || !(p instanceof Pair)) {
                return false;
            }
            Pair pp = (Pair)p;
            return a == pp.a && b == pp.b;
        }

        @Override
        public int compareTo(Pair o) {
            int v = Integer.compare(a, o.a);
            return v == 0 ? Integer.compare(b, o.b) : v;
        }
    }
}