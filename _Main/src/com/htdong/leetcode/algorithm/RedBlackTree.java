package com.htdong.leetcode.algorithm;

public class RedBlackTree {

    private TreeNode root;

    public RedBlackTree() {
        this.root = null;
    }

    public int size() {
        return root == null ? 0 : root.sz;
    }

    public void insert(int k, int v) {
        TreeNode node = TreeNode.newRed(k, v);
        if (root == null) {
            root = node;
            root.red = false;
            return;
        }
        insert(root, node);
    }

    private void insert(TreeNode rt, TreeNode node) {
        if (rt.key == node.key) {
            rt.val = node.val;
            return;
        }
        int childNode = node.key < rt.key ? 0 : 1;
        if (rt.ch[childNode] == TreeNode.leaf()) {
            addLeaf(rt, node, childNode);
        } else {
            insert(rt.ch[childNode], node);
        }
        rt.sz = rt.ch[0].sz + 1 + rt.ch[1].sz;
    }

    private void addLeaf(TreeNode rt, TreeNode node, int child) {
        rt.ch[child] = node;
        node.p = rt;
        rt.sz = rt.ch[0].sz + 1 + rt.ch[1].sz;
        handle(node);
    }

    private void handle(TreeNode node) { // TODO
        TreeNode rt = node.p;
        // 父结点是黑的，不用处理，直接返回
        if (!rt.red) {
            return;
        }
        if (rt.p.ch[0].red == rt.p.ch[1].red) {
            // 父结点和叔结点都是红的
            rt.p.ch[0].red = false;
            rt.p.ch[1].red = false;
            if (rt.p != root) {
                rt.p.red = true;
                handle(rt.p);
            }
        } else {

        }
    }

    /**
     * 
     * @param rt
     * @param ch 0表示左旋，1表示右旋
     */
    private void rotate(TreeNode rt, int ch) {
        TreeNode nrt = rt.ch[ch ^ 1];
        rt.ch[ch ^ 1] = rt.ch[ch ^ 1].ch[ch];
        nrt.ch[ch] = rt;
        if (rt == root) {
            root = nrt;
        } else {
            TreeNode p = rt.p;
            int pch = p.ch[0] == rt ? 0 : 1;
            p.ch[pch] = nrt;
        }
        nrt.p = rt.p;
        rt.p = nrt;
        rt.sz = 1 + rt.ch[0].sz + rt.ch[1].sz;
        nrt.sz = 1 + nrt.ch[0].sz + nrt.ch[1].sz;
    }

    private static class TreeNode {
        int sz;
        int key, val;
        boolean red;
        TreeNode[] ch;
        TreeNode p;

        private static TreeNode LEAF = new TreeNode();

        private static TreeNode newRed(int key, int val) {
            TreeNode redNode = new TreeNode();
            redNode.sz = 1;
            redNode.key = key;
            redNode.val = val;
            redNode.red = true;
            redNode.ch = new TreeNode[] {leaf(), leaf()};
            redNode.p = leaf();
            return redNode;
        }

        public static TreeNode leaf() {
            if (LEAF != null) {
                return LEAF;
            }
            LEAF = new TreeNode();
            LEAF.sz = 0;
            LEAF.red = false;
            LEAF.ch = new TreeNode[] {LEAF, LEAF};
            return LEAF;
        }
    }

}
