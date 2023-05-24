package com.htdong.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author htdong
 * @date 2018年4月20日 上午11:52:19
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Fastget in = new Fastget();
        // int _t = in.nextInt();
        // while (_t-- > 0) {
        // }
    }

    static class Point implements Comparable<Point> {
        long x, y;

        static Point init(Scanner in) {
            Point p = new Point();
            p.x = in.nextLong();
            p.y = in.nextLong();
            return p;
        }

        @Override
        public int compareTo(Point o) {
            if (x < o.x) {
                return -1;
            }
            if (x > o.x) {
                return 1;
            }
            return Long.compare(y, o.y);
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point)) {
                return false;
            }
            return compareTo((Point)o) == 0;
        }
    }

    static class Line {
        Point a, b;

        public Line(Point a, Point b) {
            this.a = a;
            this.b = b;
        }
    }

    static long xmult(Point p0, Point p1, Point p2) {
        return (p1.x - p0.x) * (p2.y - p0.y) - (p2.x - p0.x) * (p1.y - p0.y);
    }

    static boolean intersect(Point u1, Point u2, Point v1, Point v2) {
        return (Math.max(u1.x, u2.x) >= Math.min(v1.x, v2.x)) && (Math.max(v1.x, v2.x) >= Math.min(u1.x, u2.x))
            && (Math.max(u1.y, u2.y) >= Math.min(v1.y, v2.y)) && (Math.max(v1.y, v2.y) >= Math.min(u1.y, u2.y))
            && (xmult(u1, v1, u2) * xmult(u1, u2, v2) >= 0) && (xmult(v1, u1, v2) * xmult(v1, v2, u2) >= 0);
    }

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};

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

    public static int MOD = 1000000007;

    public static int idx(int l, int r) {
        return (l + r) | (l != r ? 1 : 0);
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static long pow(long a, int n, long mod) {
        long ans = 1;
        while (n > 0) {
            if ((n & 1) > 0) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
            n >>= 1;
        }
        return ans;
    }

    static class TreapNode {
        int key, val;
        int wht, sz;
        TreapNode[] ch;
        private static TreapNode LEAF = null;
        // private static final Random RAND = new Random(System.currentTimeMillis());
        private static int x = 1364684679;

        static int rands() {
            x += (x << 2) + 1;
            return x;
        }

        public static TreapNode leaf() {
            if (LEAF != null) {
                return LEAF;
            }
            LEAF = new TreapNode();
            LEAF.ch = new TreapNode[2];
            LEAF.ch[0] = LEAF.ch[1] = LEAF;
            LEAF.sz = 0;
            LEAF.key = -1;
            LEAF.val = -1;
            LEAF.wht = -2147483648;
            return LEAF;
        }

        private TreapNode() {}

        public TreapNode(int key, int val) {
            ch = new TreapNode[2];
            ch[0] = ch[1] = leaf();
            this.key = key;
            this.val = val;
            this.sz = 1;
            this.wht = rands();
        }

        @Override
        public String toString() {
            return "key= " + key + ", val = " + val;
        }
    }

    static class Treap {

        private TreapNode root, leaf;

        public Treap() {
            leaf = TreapNode.leaf();
            root = leaf;
        }

        public void insert(int key, int val) {
            insert(root, key, val, null, 0);
        }

        public void remove(int key) {
            remove(root, key, null, 0);
        }

        public int find(int key) {
            return find(root, key);
        }

        public int findLowerOrEqual(int key) {
            TreapNode rlt = findLowerOrEqual(root, key);
            return rlt == leaf ? -1 : rlt.key;
        }

        public int findUpperOrEqual(int key) {
            TreapNode rlt = findUpperOrEqual(root, key);
            return rlt == leaf ? -1 : rlt.key;
        }

        public int maxKey() {
            TreapNode t = root;
            while (t.ch[1] != leaf) {
                t = t.ch[1];
            }
            return t.key;
        }

        public int size() {
            return root.sz;
        }

        private void insert(TreapNode x, int key, int val, TreapNode px, int pt) {
            if (x == leaf) {
                x = new TreapNode(key, val);
                if (px != null) {
                    px.ch[pt] = x;
                } else {
                    root = x;
                }
                return;
            }
            if (key == x.key) {
                x.val = val;
            } else {
                int son = key < x.key ? 0 : 1;
                insert(x.ch[son], key, val, x, son);
                if (x.wht < x.ch[son].wht) {
                    rotate(x, son, px, pt);
                }
            }
            update(x);
        }

        private void remove(TreapNode x, int key, TreapNode px, int pt) {
            if (x == leaf) {
                return;
            }
            if (x.key == key) {
                if (x.ch[0] == leaf && x.ch[1] == leaf) {
                    if (px == null) {
                        root = leaf;
                    } else {
                        px.ch[pt] = leaf;
                    }
                    return;
                }
                int son = x.ch[0].wht > x.ch[1].wht ? 0 : 1;
                rotate(x, son, px, pt);
                remove(x, key, px == null ? root : px.ch[pt], son ^ 1);
            } else {
                int son = key < x.key ? 0 : 1;
                remove(x.ch[son], key, x, son);
            }
            update(x);
        }

        private int find(TreapNode x, int key) {
            if (x == leaf) {
                return -1;
            }
            if (x.key == key) {
                return x.val;
            }
            return find(x.ch[key < x.key ? 0 : 1], key);
        }

        private TreapNode findLowerOrEqual(TreapNode x, int key) {
            if (x == leaf) {
                return leaf;
            }
            if (x.key == key) {
                return x;
            }
            if (x.key > key) {
                return findLowerOrEqual(x.ch[0], key);
            }
            TreapNode lv = findLowerOrEqual(x.ch[1], key);
            if (lv == leaf || lv.key > key) {
                return x;
            } else {
                return lv;
            }
        }

        private TreapNode findUpperOrEqual(TreapNode x, int key) {
            if (x == leaf) {
                return leaf;
            }
            if (x.key == key) {
                return x;
            }
            if (x.key < key) {
                return findUpperOrEqual(x.ch[1], key);
            }
            TreapNode lv = findUpperOrEqual(x.ch[0], key);
            if (lv == leaf || lv.key < key) {
                return x;
            } else {
                return lv;
            }
        }

        private void update(TreapNode t) {
            t.sz = 1 + t.ch[0].sz + t.ch[1].sz;
        }

        private void rotate(TreapNode x, int t, TreapNode px, int pt) {
            TreapNode s = x.ch[t];
            x.ch[t] = s.ch[t ^ 1];
            s.ch[t ^ 1] = x;
            update(x);
            update(s);
            if (px != null) {
                px.ch[pt] = s;
            } else {
                root = s;
            }
        }
    }
}