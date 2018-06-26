package com.htdong.leetcode.solution;

import java.util.ArrayList;

/**
 *
 * @author htdong
 * @date 2018年4月8日 下午2:35:54
 */

public class Solution {

    public double mincostToHireWorkers(int[] q, int[] w, int m) {
        int n = q.length;
        double ans = -1;
        ArrayList<Double> a = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            a.clear();
            for (int j = 0; j < n; ++j) {
                double b = w[i] * q[j] * 1.0 / q[i];
                if (b >= w[j]) {
                    a.add(b);
                }
            }
            if (a.size() < m) {
                continue;
            }
            a.sort(Double::compare);
            double sum = 0;
            for (int j = 0; j < m; ++j) {
                sum += a.get(j);
            }
            if (ans < 0 || ans > sum) {
                ans = sum;
            }
        }
        return ans;
    }
}
