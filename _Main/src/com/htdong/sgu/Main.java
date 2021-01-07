package com.htdong.sgu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author htdong
 * @date 2020年12月11日 上午10:32:20
 */
public class Main {

    static class Fastget {

        public BufferedReader in;
        public StringTokenizer st;

        public Fastget() {
            in = new BufferedReader(new InputStreamReader(System.in));
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

    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // in.close();
    }
}