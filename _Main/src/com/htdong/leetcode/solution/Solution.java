package com.htdong.leetcode.solution;

import java.util.TreeSet;

/**
 *
 * @author htdong
 * @date 2018年4月8日 下午2:35:54
 */

public class Solution {

    public static int MOD = 1000000007;
    public static int[] dx = { 1, 0, -1, 0 };
    public static int[] dy = { 0, -1, 0, 1 };

    public static int idx(int l, int r) {
        return (l + r) | (l != r ? 1 : 0);
    }

    public int[] diStringMatch(String s) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i <= s.length(); ++i) {
            set.add(i);
        }
        int[] ans = new int[s.length() + 1];
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'I') {
                ans[i] = set.first();
            } else {
                ans[i] = set.last();
            }
            set.remove(ans[i]);
        }
        ans[s.length()] = set.first();
        return ans;
    }
}