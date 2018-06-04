package com.htdong.city.xiecheng;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author htdong
 * @date 2018年6月2日 下午4:46:21
 */

public class Merge {
    public static void main(String[] args) throws IOException {
        Scanner in1 = new Scanner(new File("E:\\1.txt"));
        Scanner in2 = new Scanner(new File("E:\\2.txt"));
        BufferedWriter out1 = new BufferedWriter(new FileWriter(new File("E:\\3.txt")));
        BufferedWriter out2 = new BufferedWriter(new FileWriter(new File("E:\\4.txt")));

        List<A> la = new ArrayList<>();
        Map<Long, A> map = new HashMap<>();

        while (in1.hasNextLine()) {
            String ss = in1.nextLine();
            String[] s = ss.split("##");
            Long preId = s.length > 4 ? Long.parseLong(s[4]) : null;
            la.add(new A(Long.parseLong(s[1]), s[2], null, Long.parseLong(s[0]), preId, Integer.parseInt(s[3])));
        }
        for (A j : la) {
            map.put(j.id, j);
        }

        List<B> lb = new ArrayList<>();

        while (in2.hasNextLine()) {
            String ss = in2.nextLine();
            String[] s = ss.split("##");
            lb.add(new B(s[0], s[1], s[2], Integer.parseInt(s[3])));
        }

        for (int i = 0; i < 4; ++i) {
            for (A j : la) {
                if (j.level == i) {
                    boolean flag = false;
                    for (B k : lb) {
                        if (k.level == i) {
                            if (k.name.startsWith(j.name)) {
                                if (!flag) {
                                    flag = true;
                                    out1.write(j.id + "$" + j.code + "$" + j.name + "$" + j.level + "$" + j.preId);
                                    out1.write("$" + getPre(j, map));
                                }
                                out1.write("#" + k.code + "$" + k.name + "$" + k.parent);
                            }
                        }
                    }
                    if (!flag) {
                        out2.write(j.id + "$" + j.code + "$" + j.name + "$" + j.level + "$" + j.preId);
                        out2.write("$" + getPre(j, map) + "\r\n");
                    } else {
                        out1.write("\r\n");
                    }
                }
            }
        }

        out1.flush();
        out1.close();
        out2.flush();
        out2.close();
        in1.close();
        in2.close();
    }

    private static String getPre(A j, Map<Long, A> map) {
        if (!map.containsKey(j.preId)) {
            return "";
        }
        return getPre(map.get(j.preId), map) + j.name;
    }
}
