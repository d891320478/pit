package com.htdong.yv.lrc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author htdong
 * @date 2021年8月15日 上午12:53:39
 */
public class LrcTranslate {
    public static void main(String[] args) throws IOException {
        String path = "E:\\YV\\live素材\\2019-04-28 - YVEPN0005 - 蛍標\\01-蛍標\\";
        String f = "蛍標";
        try (Scanner in1 = new Scanner(new File(path + f + ".lrc"));
                Scanner in2 = new Scanner(System.in);
                FileWriter fw = new FileWriter(path + f + "（翻译）.lrc")) {
            while (in1.hasNextLine()) {
                String s = in1.nextLine();
                s = s.substring(0, s.indexOf("]") + 1);
                String t = in2.nextLine();
                if (!t.startsWith("[")) {
                    fw.write(s + t + "\n");
                } else {
                    fw.write(t + "\n");
                }
            }
            fw.flush();
        }
    }
}