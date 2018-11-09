package com.htdong.leetcode.solution;

import java.util.Set;
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

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new TreeSet<>();
        for (String i : emails) {
            String[] s = i.split("@");
            String k = "";
            for (int j = 0; j < s[0].length(); ++j) {
                if (s[0].charAt(j) == '.') {
                    continue;
                }
                if (s[0].charAt(j) == '+') {
                    break;
                }
                k += s[0].charAt(j);
            }
            set.add(k + "@" + s[1]);
        }
        return set.size();
    }
}