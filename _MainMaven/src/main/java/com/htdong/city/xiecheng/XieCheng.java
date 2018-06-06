package com.htdong.city.xiecheng;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author htdong
 * @date 2018年6月2日 下午2:52:27
 */
public class XieCheng {

    private static Scanner in;

    public static void main(String[] args) throws FileNotFoundException {
        in = new Scanner(new File("E:\\1.txt"));
        List<String> l1 = new ArrayList<>();
        while (in.hasNextLine()) {
            l1.add(in.nextLine());
        }

        Map<Long, A> m0 = new HashMap<>();
        Map<Long, A> m1 = new HashMap<>();
        Map<Long, A> m2 = new HashMap<>();
        Map<Long, A> m3 = new HashMap<>();

        for (int i = 1; i < l1.size(); ++i) {
            String[] s = l1.get(i).split("##");
            boolean flag = false;
            for (int j = 0; j <= 8; ++j) {
                if (j != 4) {
                    if ("#N/A".equals(s[j])) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) {
                continue;
            }
            m0.put(Long.parseLong(s[7]), new A(Long.parseLong(s[7]), s[8], null, 0));
            m1.put(Long.parseLong(s[5]), new A(Long.parseLong(s[5]), s[6], Long.parseLong(s[7]), 1));
            m2.put(Long.parseLong(s[2]), new A(Long.parseLong(s[2]), s[3], Long.parseLong(s[5]), 2));
            m3.put(Long.parseLong(s[0]), new A(Long.parseLong(s[0]), s[1], Long.parseLong(s[2]), 3));
        }

        long ind = 0;
        List<A> list = new ArrayList<>();

        for (Map.Entry<Long, A> iter : m0.entrySet()) {
            A a = iter.getValue();
            a.id = ++ind;
            list.add(a);
        }

        for (Map.Entry<Long, A> iter : m1.entrySet()) {
            A a = iter.getValue();
            a.id = ++ind;
            a.preId = m0.get(a.pre).id;
            list.add(a);
        }

        for (Map.Entry<Long, A> iter : m2.entrySet()) {
            A a = iter.getValue();
            a.id = ++ind;
            a.preId = m1.get(a.pre).id;
            list.add(a);
        }

        for (Map.Entry<Long, A> iter : m3.entrySet()) {
            A a = iter.getValue();
            a.id = ++ind;
            a.preId = m2.get(a.pre).id;
            list.add(a);
        }

        for (A iter : list) {
            System.err.println(
                    iter.id + "##" + iter.code + "##" + iter.name + "##" + iter.level + "##" + iter.preId + "##");
        }
    }

}
