package com.htdong.leetcode.algorithm;

/**
 * @author dht31261
 * @date 2024年5月7日 16:11:00
 */
public class Splay {

    public static class TreeNode {
        public TreeNode ch[] = new TreeNode[2];
        public TreeNode pre;
        public int sz;
    }

    private TreeNode root, leaf;

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

    private void splay(TreeNode x, TreeNode goal) {
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

    public void pushup(TreeNode x) {

    }

    public void pushdown(TreeNode x) {

    }
}