package com.htdong.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author htdong
 * @date 2018年4月8日 下午2:35:54
 */

public class Solution {

    public String minWindow(String s, String t) {
        int l = -1, r = -1;
        Map<Character, Integer> mapt = new HashMap<>();
        for (int i = 0; i < t.length(); ++i) {
            mapt.put(t.charAt(i), mapt.containsKey(t.charAt(i)) ? mapt.get(t.charAt(i)) + 1 : 1);
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length();) {
            if (check(map, mapt)) {
                if (l == -1 || r - l > j - i) {
                    l = i;
                    r = j;
                }
                if (mapt.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if (map.get(s.charAt(i)) == 0) {
                        map.remove(s.charAt(i));
                    }
                }
                ++i;
                if (i > j) {
                    j = i;
                    map.clear();
                }
            } else {
                if (j < s.length()) {
                    if (mapt.containsKey(s.charAt(j))) {
                        if (map.containsKey(s.charAt(j))) {
                            map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                        } else {
                            map.put(s.charAt(j), 1);
                        }
                    }
                    ++j;
                } else {
                    ++i;
                }
            }
        }
        if (l == -1) {
            return "";
        } else {
            return s.substring(l, r);
        }
    }

    private boolean check(Map<Character, Integer> map, Map<Character, Integer> mapt) {
        if(map.size() < mapt.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> iter : map.entrySet()) {
            if(mapt.get(iter.getKey()) > iter.getValue()) {
                return false;
            }
        }
        return true;
    }

    public int[] shortestToChar(String s, char c) {
        int[] a = new int[s.length() + 5];
        int[] ans = new int[s.length()];
        int la = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == c) {
                a[la++] = i;
            }
        }
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == c) {
                ans[i] = 0;
            } else {
                int l = 0, r = la - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    if (a[mid] <= i) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                ans[i] = i > a[l] ? i - a[l] : a[l] - i;
                if (l + 1 < la && a[l + 1] - i < ans[i]) {
                    ans[i] = a[l + 1] - i;
                }
            }
        }
        return ans;
    }
}