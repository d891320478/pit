package com.htdong.yv.lrc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author htdong
 * @date 2021年8月15日 上午12:36:09
 */
public class LrcMerge {

    public static void main(String[] args) throws FileNotFoundException {
        String path = "E:\\YV\\live素材\\2019-04-28 - YVEPN0005 - 蛍標\\01-蛍標\\";
        String f = "蛍標";
        try (Scanner in1 = new Scanner(new File(path + f + ".lrc"));
                Scanner in2 = new Scanner(new File(path + f + "（翻译）.lrc"));) {
            while(in1.hasNextLine()) {
                String s1 = in1.nextLine();
                s1 = s1.substring(s1.indexOf("]") + 1);
                String s2 = in2.nextLine();
                s2 = s2.substring(s2.indexOf("]") + 1);
                System.err.println(s1);
                System.err.println(s2);
            }
        }
    }
}