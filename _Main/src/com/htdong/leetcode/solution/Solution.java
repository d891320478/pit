package com.htdong.leetcode.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.htdong.leetcode.algorithm.Base;

/**
 * @author htdong
 * @date 2019年11月7日 下午4:56:49
 */
public class Solution extends Base {

    public int countPalindromicSubsequence(String s) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < s.length(); ++i) {
            list.get(s.charAt(i) - 'a').add(i);
        }
        Set<String> set = new HashSet<>();
        for (int i = 1; i + 1 < s.length(); ++i) {
            char ch = s.charAt(i);
            for (int j = 0; j < list.size(); ++j) {
                if (!list.get(j).isEmpty() && list.get(j).get(0) < i && list.get(j).getLast() > i) {
                    StringBuilder sb = new StringBuilder();
                    sb.append((char)('a' + j)).append(ch).append((char)('a' + j));
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
}