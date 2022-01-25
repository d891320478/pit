package com.htdong.sgu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author htdong
 * @date 2020年12月11日 上午10:32:20
 */
public class Main {

    static class Fastget {

        public BufferedReader in;
        public StringTokenizer st;
        public static final PrintWriter out = new PrintWriter(System.out);

        public Fastget() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        public void close() {
            try {
                out.flush();
                out.close();
                in.close();
            } catch (IOException e) {
            }
        }

        private String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (Exception e) {
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            String s = next();
            return Integer.parseInt(s);
        }
    }

    public static class Edge {
        int next, v, w;

        public Edge(int next, int v, int w) {
            this.next = next;
            this.v = v;
            this.w = w;
        }
    }

    public static int[] head;
    public static Edge[] e;
    public static int cnt;

    public static void init(int n, int m) {
        head = new int[n];
        for (int i = 0; i < n; ++i) {
            head[i] = -1;
        }
        e = new Edge[m];
        cnt = 0;
    }

    public static void addEdge(int u, int v, int w) {
        e[cnt] = new Edge(head[u], v, w);
        head[u] = cnt++;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i <= c; ++i) {
            l.add(a * i);
            l.add(b * i);
        }
        l.sort(Integer::compareTo);
        int t = l.get(c - 1);
        if (t % a == 0 && t % b == 0) {
            System.out.println((t / a + t / b) + " " + t);
        } else {
            if (t % a != 0) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            System.out.println((t / a + t / b + 1) + " " + ((t / b + 1) * b));
        }
        in.close();
    }
}