package com.htdong.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

import com.htdong.leetcode.algorithm.Base;

/**
 * @author htdong
 * @date 2019年11月7日 下午4:56:49
 */
public class Solution extends Base {

    public String toGoatLatin(String sentence) {
        String[] a = sentence.split(" ");
        List<String> b = new ArrayList<>();
        for (int i = 0; i < a.length; ++i) {
            String c;
            if (a[i].charAt(0) == 'a' || a[i].charAt(0) == 'e' || a[i].charAt(0) == 'i' || a[i].charAt(0) == 'o'
                || a[i].charAt(0) == 'u' || a[i].charAt(0) == 'A' || a[i].charAt(0) == 'E' || a[i].charAt(0) == 'I'
                || a[i].charAt(0) == 'O' || a[i].charAt(0) == 'U') {
                c = a[i] + "ma";
            } else {
                c = a[i].substring(1) + a[i].charAt(0) + "ma";
            }
            for (int j = 0; j <= i; ++j) {
                c += "a";
            }
            b.add(c);
        }
        return String.join(" ", b);
    }
}