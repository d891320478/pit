package com.htdong.codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author htdong
 * @date 2018年4月20日 上午11:52:19
 */

public class Main {

    private static boolean[] flag;
    private static int ans;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<List<Integer>> e = new ArrayList<>(n + 2);
        for (int i = 0; i < m; ++i) {
            int u = in.nextInt();
            int v = in.nextInt();
            if (e.get(u) == null) {
                e.set(u, new ArrayList<>());
            }
            if (e.get(v) == null) {
                e.set(v, new ArrayList<>());
            }
            e.get(u).add(v);
            e.get(v).add(u);
        }
        flag = new boolean[n + 2];
        ans = 0;
        for (int i = 1; i <= n; ++i) {
            flag[i] = true;
        }
        in.close();
    }
}
