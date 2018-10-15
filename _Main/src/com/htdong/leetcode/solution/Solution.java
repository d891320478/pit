package com.htdong.leetcode.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author htdong
 * @date 2018年4月8日 下午2:35:54
 */

public class Solution {

    double r, x, y;

    public Solution(double radius, double x_center, double y_center) {
        this.r = radius;
        this.x = x_center;
        this.y = y_center;
    }

    public double[] randPoint() {
        double[] ret = new double[2];
        double xx = Math.random() * r;
        ret[0] = this.x + xx * (Math.random() < 0.5 ? -1 : 1);
        ret[1] = this.y + Math.random() * Math.sqrt(r * r - xx * xx) * (Math.random() < 0.5 ? -1 : 1);
        if (Math.pow(ret[0] - this.x, 2.0) + Math.pow(ret[1] - this.y, 2.0) > r * r) {
            return randPoint();
        }
        return ret;
    }
}