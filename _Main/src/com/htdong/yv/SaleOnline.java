package com.htdong.yv;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SaleOnline {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("E:/yv.txt"));
        TreeMap<String, Integer> map = new TreeMap<>();
        ArrayList<String> list = new ArrayList<>();
        while (in.hasNextLine()) {
            String str = in.nextLine();
            list.add(str);
            String[] s = str.split(" x");
            if (!map.containsKey(s[0])) {
                map.put(s[0], Integer.parseInt(s[1]));
            } else {
                map.put(s[0], map.get(s[0]) + Integer.parseInt(s[1]));
            }
        }
        for (Map.Entry<String, Integer> iter : map.entrySet()) {
            System.out.println(iter.getKey() + " " + iter.getValue());
        }
        in.close();
        list.sort(String::compareTo);
        list.forEach(System.err::println);
        
        in = new Scanner(new File("E:/mail.txt"));
        BigDecimal bd = BigDecimal.ZERO;
        while (in.hasNextLine()) {
            bd = bd.add(new BigDecimal(in.nextLine()));
        }
        in.close();
        System.out.println(bd);
    }

}
