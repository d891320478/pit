package com.htdong.leetcode.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author htdong
 * @date 2018年4月8日 下午2:35:54
 */

class TreapNode {
    int key, val;
    int wht, sz;
    TreapNode[] ch;
    private static TreapNode LEAF = null;
    private static final Random RAND = new Random(System.currentTimeMillis());

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

    private TreapNode() {
    }

    public TreapNode(int key, int val) {
        ch = new TreapNode[2];
        ch[0] = ch[1] = leaf();
        this.key = key;
        this.val = val;
        this.sz = 1;
        this.wht = RAND.nextInt(2147483647);
    }

    @Override
    public String toString() {
        return "key= " + key + ", val = " + val;
    }
}

class Treap {

    private TreapNode root, leaf;

    public Treap() {
        leaf = TreapNode.leaf();
        root = leaf;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    private void dfs(TreapNode rt, StringBuilder sb) {
        if (rt == leaf) {
            return;
        }
        sb.append(rt.key).append("[" + rt.sz + "]").append(" (");
        dfs(rt.ch[0], sb);
        sb.append(")(");
        dfs(rt.ch[1], sb);
        sb.append(" )");
    }

    public void insert(int key, int val) {
        insert(root, key, val, null, 0);
    }

    public void remove(int key) {
        remove(root, key, null, 0);
    }

    public int getKey(int index) {
        TreapNode rt = root;
        while (rt != leaf) {
            if (rt.sz - rt.ch[1].sz < index) {
                index -= rt.sz - rt.ch[1].sz;
                rt = rt.ch[1];
            } else if (index > rt.ch[0].sz) {
                return rt.key;
            } else {
                rt = rt.ch[0];
            }
        }
        return 0;
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
            ++x.sz;
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
            if (x.sz - x.ch[0].sz - x.ch[1].sz > 1) {
                --x.sz;
                update(x);
                return;
            }
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

public class Solution {

    public boolean isBipartite(int[][] g) {
        int n = g.length;
        int[] vis = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (vis[i] == 0) {
                q.add(i);
                vis[i] = 1;
                while (!q.isEmpty()) {
                    int u = q.poll();
                    for (int j = 0; j < g[u].length; ++j) {
                        if (vis[g[u][j]] == 0) {
                            vis[g[u][j]] = 3 - vis[u];
                            q.add(g[u][j]);
                        } else if (vis[g[u][j]] == vis[u]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public int longestSubstring(String s, int k) {
        // TODO
        // https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
        int[][] a = new int[26][s.length() + 1];
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 0; j < 26; ++j) {
                a[j][i] = a[j][i - 1];
                if (j == s.charAt(i - 1) - 'a') {
                    ++a[j][i];
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= s.length(); ++i) {
            int n = s.length();
            int ll = n, rr = 0;
            for (int j = 0; j < 26; ++j) {
                if (a[j][s.length()] == a[j][i - 1]) {
                    continue;
                }
            }
            ans = Math.max(ans, n - i + 1);
        }
        return ans;
    }

    public double[] medianSlidingWindow(int[] a, int k) {
        Treap tr = new Treap();
        double[] ans = new double[a.length - k + 1];
        for (int i = 0; i < k; ++i) {
            tr.insert(a[i], 0);
        }
        for (int i = 0, l = 0, r = k; i < ans.length; ++i, ++l, ++r) {
            if (k % 2 == 0) {
                ans[i] = (tr.getKey(k / 2) + 0.0 + tr.getKey(k / 2 + 1)) * 0.5;
            } else {
                ans[i] = tr.getKey((k + 1) / 2);
            }
            tr.remove(a[l]);
            if (r < a.length) {
                tr.insert(a[r], 0);
            }
        }
        return ans;
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] ret = new int[deck.length];
        // TODO https://leetcode.com/problems/reveal-cards-in-increasing-order/
        return ret;
    }

    public int maxProfit(int[] p, int fee) {
        int[] d = new int[p.length];
        int[] e = new int[p.length];
        for (int i = 0; i < p.length; ++i) {
            e[i] = p[i] + fee;
        }
        // TODO
        // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
        for (int i = 1; i < p.length; ++i) {
            d[i] = d[i - 1];
            // d[i] = max(d[i], p[i]-p[k]-fee+d[k-1])
        }
        return d[p.length - 1];
    }
}