package com.htdong.leetcode.main;

import com.htdong.leetcode.solution.ExamRoom;

/**
 * 
 * @author htdong
 * @date 2018年4月8日 下午2:36:19
 */

public class LeetCode {
    public static void main(String[] args) {
        ExamRoom er = new ExamRoom(10);
        System.out.println(er.seat());
        System.out.println(er.seat());
        System.out.println(er.seat());
        System.out.println(er.seat());
        er.leave(4);
        System.out.println(er.seat());
    }
}
