package com.htdong.city.xiecheng;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author htdong
 * @date 2018年6月5日 下午5:35:54
 */

public class Sortt {
    
    public static void main(String[] args) throws IOException {
        Scanner in1 = new Scanner(new File("E:\\1.txt"));
        BufferedWriter out1 = new BufferedWriter(new FileWriter(new File("E:\\6.txt")));
        List<String> ls = new ArrayList<>();
        while (in1.hasNextLine()) {
            ls.add(in1.nextLine());
        }
        ls.sort((String s, String t) -> {
            String[] a = s.split("\\$");
            String[] b = t.split("\\$");
            return a[4].compareTo(b[4]);
        });
        for (String i : ls) {
            out1.write(i + "\r\n");
        }
        out1.flush();
        out1.close();
        in1.close();
    }
}
