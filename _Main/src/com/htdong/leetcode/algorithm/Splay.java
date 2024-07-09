package com.htdong.leetcode.algorithm;

/**
 * @author dht31261
 * @date 2024年5月7日 16:11:00
 */
public class Splay {

    public static class TreeNode {

        private static TreeNode LEAF = null;

        // 以下不变
        public TreeNode ch[] = new TreeNode[2], pre;
        public int sz;
        // 以下字段需要自定义
        public int val, sum, lzy;

        private TreeNode() {}

        public TreeNode(int val) {
            this.ch[0] = this.ch[1] = this.pre = leaf();
            this.sz = 1;
            this.val = this.sum = val;
            this.lzy = 0;
        }

        public static TreeNode leaf() {
            if (LEAF != null) {
                return LEAF;
            }
            LEAF = new TreeNode();
            LEAF.ch[0] = LEAF.ch[1] = LEAF.pre = null;
            LEAF.sz = 0;
            return LEAF;
        }
    }

    public Splay() {
        leaf = TreeNode.leaf();
        root = new TreeNode(0);
        root.ch[0] = root.pre = leaf;
        root.ch[1] = new TreeNode(0);
        root.ch[1].pre = root;
        root.sz = 2;
    }

    public TreeNode root, leaf;

    private void rotate(TreeNode x, int f) {
        TreeNode y = x.pre, z = y.pre;
        pushdown(y);
        pushdown(x);
        y.ch[f ^ 1] = x.ch[f];
        x.ch[f].pre = y;
        x.ch[f] = y;
        y.pre = x;
        x.pre = z;
        if (x.pre != leaf) {
            z.ch[z.ch[1] == y ? 1 : 0] = x;
        }
        pushup(y);
    }

    public void splay(TreeNode x, TreeNode goal) {
        pushdown(x);
        while (x.pre != goal) {
            if (x.pre.pre == goal) {
                rotate(x, x.pre.ch[0] == x ? 1 : 0);
            } else {
                TreeNode y = x.pre, z = y.pre;
                int f = (z.ch[0] == y ? 1 : 0);
                if (y.ch[f] == x) {
                    rotate(x, f ^ 1);
                } else {
                    rotate(y, f);
                }
                rotate(x, f);
            }
        }
        pushup(x);
        if (goal == leaf) {
            root = x;
        }
    }

    public void rotateTo(int k, TreeNode goal) {
        TreeNode x = root;
        pushdown(x);
        while (x.ch[0].sz != k) {
            if (k < x.ch[0].sz) {
                x = x.ch[0];
            } else {
                k -= x.ch[0].sz + 1;
                x = x.ch[1];
            }
            pushdown(x);
        }
        splay(x, goal);
    }

    public void pushup(TreeNode x) {
        x.sz = x.ch[0].sz + 1 + x.ch[1].sz;
        x.sum = x.ch[0].sum + x.val + x.ch[1].sum;
    }

    public void pushdown(TreeNode x) {

    }
}