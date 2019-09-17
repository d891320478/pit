package com.htdong.leetcode.solution;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

import com.htdong.leetcode.domain.TreeNode;

/**
 * @author htdong
 * @date 2018年4月8日 下午2:35:54
 */

class TreapNode {
    int key, val;
    int wht, sz, cnt;
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
        LEAF.cnt = 0;
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
        this.sz = this.cnt = 1;
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
            ++x.cnt;
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
            if (x.cnt > 1) {
                --x.cnt;
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
        t.sz = t.cnt + t.ch[0].sz + t.ch[1].sz;
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

    public int maxProfit(int k, int[] p) {
        int n = p.length;
        if (k > n / 2) {
            k = n / 2;
        }
        int[][] d = new int[k + 1][n + 1];
        for (int i = 1; i <= k; ++i) {
            for (int j = 1; j <= n; ++j) {
                d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]);
                for (int l = 0; l + 1 <= j; ++l) {
                    d[i][j] = Math.max(d[i][j], d[i - 1][l] + p[j - 1] - p[l]);
                }
            }
        }
        return d[k][n];
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