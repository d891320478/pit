package com.htdong.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author htdong
 * @date 2018年4月8日 下午2:36:19
 */

public class LeetCode {
    public static void main(String[] args) {
        ArrayList<List<Integer>> la = new ArrayList<>();
        la.add(Arrays.asList(new Integer[] { 3, 0, 5 }));
        la.add(Arrays.asList(new Integer[] { 1, 2, 10 }));
        System.out.println(new Solution().shoppingOffers(Arrays.asList(new Integer[] { 2, 5 }), la,
                Arrays.asList(new Integer[] { 3, 2 })));
    }
}