package com.htdong.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author htdong
 * @date 2018年4月8日 下午2:36:19
 */
public class LeetCode {

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        System.out.println(new Solution().minimumSeconds(new ArrayList<>(Arrays.asList(1, 2, 1, 2))));
        System.out.println("time = " + (System.currentTimeMillis() - t1));
    }
}