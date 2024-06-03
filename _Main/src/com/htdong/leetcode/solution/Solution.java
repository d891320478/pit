package com.htdong.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.htdong.leetcode.algorithm.Base;

/**
 * @author htdong
 * @date 2019年11月7日 下午4:56:49
 */
public class Solution extends Base {
    public int minimumSeconds(List<Integer> a) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < a.size(); ++i) {
            int v = a.get(i);
            List<Integer> l = map.getOrDefault(v, new ArrayList<>());
            l.add(i);
            map.put(v, l);
        }
        int ans = a.size();
        for (List<Integer> iter : map.values()) {
            int mx = 0;
            for (int i = 0; i < iter.size(); ++i) {
                if (i > 0) {
                    mx = Math.max(iter.get(i) - iter.get(i - 1) - 1, mx);
                } else {
                    mx = Math.max(iter.get(i) + a.size() - iter.getLast() - 1, mx);
                }
            }
            ans = Math.min(ans, (mx + 1) / 2);
        }
        return ans;
    }
}