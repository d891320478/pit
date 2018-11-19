package com.htdong.leetcode.solution;

import java.util.LinkedList;
import java.util.List;

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

    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new LinkedList<>();
        int[] a = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            a[s.charAt(i) - 'a'] = i;
        }
        s += "0";
        for (int st = 0, i = 0, lst = 0; i < s.length(); ++i) {
            if (i > lst) {
                ans.add(lst - st + 1);
                st = i;
                lst = i;
            }
            if (s.charAt(i) != '0') {
                lst = Math.max(lst, a[s.charAt(i) - 'a']);
            }
        }
        return ans;
    }
}