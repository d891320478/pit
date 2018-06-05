package com.htdong.city.xiecheng;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author htdong
 * @date 2018年6月4日 上午10:13:35
 */

public class Result {
    public static void main(String[] args) throws IOException {
        Scanner in1 = new Scanner(new File("E:\\5.txt"));
        BufferedWriter out1 = new BufferedWriter(new FileWriter(new File("E:\\7.txt")));

        while (in1.hasNextLine()) {
            String s = in1.nextLine();
            String[] s1 = s.split("#");
            String[] a = s1[0].split("\\$");
            String[] b = s1[1].split("\\$");
            out1.write(a[0] + "," + b[0] + "," + a[1] + "," + a[2] + "," + a[3] + ",");
            if(a.length > 4) {
                out1.write(a[4]);
            }
            out1.write("\r\n");
        }

        out1.flush();
        out1.close();
        in1.close();
    }
}
