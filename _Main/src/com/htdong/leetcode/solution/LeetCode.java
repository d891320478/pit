package com.htdong.leetcode.solution;

/**
 * @author htdong
 * @date 2018年4月8日 下午2:36:19
 */

public class LeetCode {
    
    class H2O {

        public H2O() {
            
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode());
    }
}