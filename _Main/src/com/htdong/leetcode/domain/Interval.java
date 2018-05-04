package com.htdong.leetcode.domain;

/**
 *
 * @author htdong
 * @date 2018年5月4日 下午4:54:52
 */

public class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "(" + start + "," + end + ")";
    }
}
