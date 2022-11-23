package com.htdong.leetcode.algorithm;

public class Manacher {
    public static int lpd(String s) {
        byte[] a = new byte[s.length() * 2 + 5];
        int[] p = new int[a.length];
        a[0] = -1;
        a[1] = -2;
        int la = 2;
        for (int i = 0; i < s.length(); ++i) {
            a[la++] = (byte)s.charAt(i);
            a[la++] = -2;
        }
        a[la++] = -3;
        int ans = 0;
        int mx = 0, id = 0;
        for (int i = 1; i < la; i++) {
            if (mx > i) {
                p[i] = Math.min(p[id * 2 - i], mx - i);
            } else {
                p[i] = 1;
            }
            for (; a[i + p[i]] == a[i - p[i]]; p[i]++);
            if (p[i] + i > mx) {
                mx = p[i] + i;
                id = i;
            }
            ans = Math.max(ans, p[i] - 1);
        }
        return ans;
    }
}