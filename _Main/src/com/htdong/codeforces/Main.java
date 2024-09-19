package com.htdong.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

    // static Scanner in = new Scanner(System.in);
    static Fastget in = new Fastget();

    public static void main(String[] args) {
        int _t = in.nextInt();
        int n, k;
        while (_t-- > 0) {
            n = in.nextInt();
            k = in.nextInt();
            
        }
    }

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

        public long nextLong() {
            String s = next();
            return Long.parseLong(s);
        }
    }
}