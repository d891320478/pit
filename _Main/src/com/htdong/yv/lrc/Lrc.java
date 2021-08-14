package com.htdong.yv.lrc;

import java.util.Scanner;

/**
 * @author htdong
 * @date 2021年8月14日 下午11:40:24
 */
public class Lrc {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNextLine()) {
                String s = in.nextLine();
                s = s.substring(s.indexOf("]") + 1);
                String[] a = s.split(" // ");
                for (String i : a) {
                    System.err.println(i);
                }
            }
        }
    }
}