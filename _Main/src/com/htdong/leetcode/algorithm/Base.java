package com.htdong.leetcode.algorithm;

public class Base {
    public static int MOD = 1000000007;
    public static int[] dx = { 1, 0, -1, 0 };
    public static int[] dy = { 0, -1, 0, 1 };
    public static int[] cx = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
    public static int[] cy = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };

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
}