package com.htdong.leetcode.solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author htdong
 * @date 2018年4月8日 下午2:35:54
 */

public class Solution {

    private final static int MOD = 1000000007;

    public int profitableSchemes(int n, int m, int[] group, int[] profit) {
        Map<String, Abc> map = new HashMap<>();
        Queue<Abc> q = new LinkedList<>();

        Abc abc = new Abc(0, 0, 1);
        map.put(getKey(0, 0), abc);
        q.add(abc);

        int ans = 0;
        while (!q.isEmpty()) {
            Abc head = q.poll();
            if (head.b >= m) {
                ans = (ans + head.c) % MOD;
            }
            for (int i = 0; i < group.length; ++i) {
                if (head.a + group[i] > n) {
                    continue;
                }
                String key = getKey(head.a + group[i], head.b + profit[i]);
                Abc val = map.get(key);
                if (val == null) {
                    val = new Abc(head.a + group[i], head.b + profit[i], 0);
                    map.put(key, val);
                    q.add(val);
                }
                val.c = (val.c + head.c) % MOD;
            }
        }
        return ans;
    }

    private String getKey(int a, int b) {
        return a + "_" + b;
    }

    class Abc {
        int a, b, c;

        public Abc(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}