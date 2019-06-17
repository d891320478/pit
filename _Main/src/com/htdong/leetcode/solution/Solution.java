package com.htdong.leetcode.solution;

/**
 * @author htdong
 * @date 2018年4月8日 下午2:35:54
 */

public class Solution {

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

class MyCalendarThree {

    class TreeNode {
        int mx;
        int lzy;
        int l, r;
        TreeNode ls, rs;

        public TreeNode(int l, int r) {
            mx = lzy = 0;
            this.l = l;
            this.r = r;
        }

        @Override
        public String toString() {
            return "mx = " + mx + ", lzy = " + lzy + ", l = " + l + ", r = " + r;
        }
    }

    TreeNode rt;

    public MyCalendarThree() {
        rt = new TreeNode(0, 1000000000);
    }

    public int book(int s, int t) {
        --t;
        add(s, t, rt);
        return rt.mx;
    }

    private void pushdown(TreeNode t) {
        int mid = t.l + t.r >> 1;
        if (t.ls == null) {
            t.ls = new TreeNode(t.l, mid);
        }
        if (t.rs == null) {
            t.rs = new TreeNode(mid + 1, t.r);
        }
        t.ls.lzy += t.lzy;
        t.rs.lzy += t.lzy;
        t.ls.mx += t.lzy;
        t.rs.mx += t.lzy;
        t.lzy = 0;
    }

    private void pushup(TreeNode t) {
        t.mx = Math.max(t.ls.mx, t.rs.mx);
    }

    private void add(int l, int r, TreeNode t) {
        if (l <= t.l && r >= t.r) {
            ++t.mx;
            ++t.lzy;
            return;
        }
        int mid = t.l + t.r >> 1;
        pushdown(t);
        if (l <= mid) {
            add(l, r, t.ls);
        }
        if (r > mid) {
            add(l, r, t.rs);
        }
        pushup(t);
    }
}