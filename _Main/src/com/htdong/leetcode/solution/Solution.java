package com.htdong.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author htdong
 * @date 2018年4月8日 下午2:35:54
 */

public class Solution {

    public int lastStoneWeightII(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for (int i : stones) {
            list.add(i);
        }
        while (list.size() > 1) {
            list.sort(Integer::compare);
            int i = 0, j = 0;
            int abs = 2100000000;
            for (; i + 1 < list.size(); ++i) {
                if (Math.abs(list.get(i) - list.get(i + 1)) < abs) {
                    abs = Math.abs(list.get(i) - list.get(i + 1));
                    j = i;
                }
            }
            int a = list.remove(j);
            int b = list.remove(j);
            if (a != b) {
                list.add(Math.abs(a - b));
            }
        }
        if (list.size() == 0) {
            return 0;
        }
        return list.get(0);
    }
}