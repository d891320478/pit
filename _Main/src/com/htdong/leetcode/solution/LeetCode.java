package com.htdong.leetcode.solution;

import com.htdong.leetcode.algorithm.Manacher;

/**
 * @author htdong
 * @date 2018年4月8日 下午2:36:19
 */

public class LeetCode {

    class H2O {

        public H2O() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

            // releaseHydrogen.run() outputs 'H'. Do not change or remove this line.
            releaseHydrogen.run();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {

            // releaseOxygen.run() outputs 'O'. Do not change or remove this line.
            releaseOxygen.run();
        }
    }

    public static void main(String[] args) {
        System.out.println(Manacher.lpd("abccdccba"));
        long t1 = System.currentTimeMillis();
        System.out.println(new Solution().longestNiceSubarray(new int[] {1, 3, 8, 48, 10}));
        System.out.println("time = " + (System.currentTimeMillis() - t1));
    }
}