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
}
