package com.htdong.leetcode.solution;

import java.util.Arrays;

import com.htdong.algorithm.Base;

/**
 * @author htdong
 * @date 2019年11月7日 下午4:56:49
 */
public class Solution extends Base {

    private double f(int a, int b, int c) {
        double d = Math.acos((b * b + c * c - a * a) * 1.0 / (2.0 * b * c));
        return d * 180.0 / Math.PI;
    }

    public double[] internalAngles(int[] a) {
        Arrays.sort(a);
        if (a[0] + a[1] <= a[2]) {
            return new double[0];
        }
        double[] b = new double[3];
        b[0] = f(a[0], a[1], a[2]);
        b[1] = f(a[1], a[0], a[2]);
        b[2] = f(a[2], a[1], a[0]);
        Arrays.sort(b);
        return b;
    }
}