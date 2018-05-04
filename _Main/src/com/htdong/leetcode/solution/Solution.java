package com.htdong.leetcode.solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.htdong.leetcode.domain.Interval;

/**
 *
 * @author htdong
 * @date 2018年4月8日 下午2:35:54
 */

public class Solution {

    public String reorganizeString(String s) {
        int[] a = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            ++a[s.charAt(i)];
        }
        StringBuilder t = new StringBuilder();
        int lst = 0;
        for (int i = 0; i < s.length(); ++i) {
            int max = -1;
            int ind = -1;
            for (int j = 0; j < 256; ++j) {
                if (j != lst && a[j] > 0 && a[j] > max) {
                    max = a[j];
                    ind = j;
                }
            }
            if (ind != -1) {
                t.append((char) ind);
                --a[ind];
                lst = ind;
            } else {
                return "";
            }
        }
        return t.toString();
    }

}
