package com.htdong.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author htdong
 * @date 2018年4月20日 上午11:52:19
 */
public class Main {
    static class UnrolledLinkedList {

        private int sqrtn;
        private Node head;
        private int size;

        public UnrolledLinkedList(int maxSize) {
            sqrtn = Math.max(1, (int)Math.sqrt(maxSize));
            head = new Node();
            size = 0;
        }

        public void init(int[] s) {
            Node next = head;
            size = s.length;
            for (int i = 0; i < s.length; ++i) {
                if (next.getSize() > sqrtn) {
                    next.next = new Node();
                    next = next.next;
                }
                next.add(s[i]);
            }
        }

        public int get(int i) {
            Node next = head;
            for (; next != null;) {
                if (next.getSize() >= i) {
                    return next.get(i - 1);
                } else {
                    i -= next.getSize();
                    next = next.next;
                }
            }
            return 0;
        }

        public int getSize() {
            return size;
        }

        public void add(int ch, int i) {
            Node next = head;
            for (; next != null;) {
                if (next.getSize() + 1 >= i) {
                    next.add(i - 1, ch);
                    ++size;
                    return;
                } else {
                    i -= next.getSize();
                    next = next.next;
                }
            }
        }

        public void remove(int i) {
            Node next = head;
            for (; next != null;) {
                if (next.getSize() >= i) {
                    next.remove(i - 1);
                    --size;
                    return;
                }
                i -= next.getSize();
                next = next.next;
            }
        }

        public int count(int m, int v) {
            Node next = head;
            int cnt = 0;
            for (; next != null && next.getSize() <= m; next = next.next) {
                m -= next.getSize();
                cnt += next.map.getOrDefault(v, 0);
            }
            for (int i = 0; i < m; ++i) {
                if (next.get(i) == v) {
                    ++cnt;
                }
            }
            return cnt;
        }

        private class Node {
            private Node next;
            private Map<Integer, Integer> map = new HashMap<>(sqrtn);
            private int[] list = new int[sqrtn * 2 + 5];
            private int size;

            public int getSize() {
                return size;
            }

            public int get(int i) {
                return list[i];
            }

            public void remove(int i) {
                int v = get(i);
                map.put(v, map.get(v) - 1);
                for (; i + 1 < size; ++i) {
                    list[i] = list[i + 1];
                }
                --size;
                merge();
            }

            public void add(Integer ch) {
                add(size, ch);
            }

            public void add(int idx, Integer ch) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                for (int i = size; i > idx; --i) {
                    list[i] = list[i - 1];
                }
                list[idx] = ch;
                ++size;
                split();
            }

            private void merge() {
                if (next != null && size + next.size <= sqrtn) {
                    Node nn = next;
                    for (int i = 0; i < nn.getSize(); ++i) {
                        add(nn.get(i));
                    }
                    next = nn.next;
                }
                split();
            }

            private void split() {
                if (size > 2 * sqrtn) {
                    Node nn = new Node();
                    next = nn;
                    nn.next = next;
                    for (int i = sqrtn + 1; i < next.getSize(); ++i) {
                        nn.add(list[i]);
                    }
                    size -= nn.getSize();
                }
            }
        }
    }

    static int[] aa = new int[100010];

    public static void main(String[] args) {
        UnrolledLinkedList ull = new UnrolledLinkedList(100000);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; ++i) {
            aa[i] = in.nextInt();
        }
        ull.init(aa);
        int _t = in.nextInt();
        int lastans = 0, l, r, k, op;
        while (_t-- > 0) {
            op = in.nextInt();
            l = in.nextInt();
            r = in.nextInt();
            l = (l + lastans - 1) % n + 1;
            r = (r + lastans - 1) % n + 1;
            if (l > r) {
                int tmp = l;
                l = r;
                r = tmp;
            }
            if (op == 1) {
                int v = ull.get(r);
                ull.remove(r);
                ull.add(v, l);
            } else {
                k = in.nextInt();
                k = (k + lastans - 1) % n + 1;
                lastans = ull.count(r, k) - ull.count(l - 1, k);
                System.out.println(lastans);
            }
        }
        in.close();
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