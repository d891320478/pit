package com.htdong.algorithm.avl;

public class AvlTree {

    public static class AvlNode {

        public static final AvlNode leaf = AvlNode.leaf();

        public int key;
        public int value;
        public AvlNode[] ch;
        public int height, size;

        private AvlNode() {}

        public AvlNode(int k, int v) {
            this.key = k;
            this.value = v;
            this.ch = new AvlNode[] {leaf, leaf};
            this.height = 1;
            this.size = 1;
        }

        private static AvlNode leaf() {
            AvlNode leaf = new AvlNode();
            leaf.ch = new AvlNode[] {leaf, leaf};
            leaf.height = 0;
            leaf.size = 0;
            return leaf;
        }
    }

    private AvlNode root, leaf;

    public AvlTree() {
        leaf = AvlNode.leaf;
    }

    public void insert(int k, int v) {
        if (root == null) {
            root = new AvlNode(k, v);
            return;
        }
        root = insert(root, k, v);
    }

    private AvlNode rotate(AvlNode node, int r) {
        AvlNode rlt = node.ch[r];
        AvlNode zz = rlt.ch[r ^ 1];
        rlt.ch[r ^ 1] = node;
        node.ch[r] = zz;
        node.height = Math.max(node.ch[0].height, node.ch[1].height) + 1;
        node.size = node.ch[0].size + node.ch[1].size + 1;
        rlt.height = Math.max(rlt.ch[0].height, rlt.ch[1].height) + 1;
        rlt.size = rlt.ch[0].size + rlt.ch[1].size + 1;
        return rlt;
    }

    private AvlNode rotate(AvlNode pre) {
        if (pre.ch[0].height - pre.ch[1].height == 2) {
            AvlNode left = pre.ch[0];
            if (left.ch[0].height - left.ch[1].height >= 0) {
                return rotate(pre, 0);
            } else {
                pre.ch[0] = rotate(pre.ch[0], 1);
                return rotate(pre, 1);
            }
        } else if (pre.ch[1].height - pre.ch[0].height == 2) {
            AvlNode right = pre.ch[1];
            if (right.ch[1].height - right.ch[0].height >= 0) {
                return rotate(pre, 1);
            } else {
                pre.ch[1] = rotate(pre.ch[1], 0);
                return rotate(pre, 0);
            }
        }
        return pre;
    }

    private AvlNode insert(AvlNode pre, int k, int v) {
        if (pre.key == k) {
            pre.value = v;
            return pre;
        }
        if (k < pre.key) {
            if (pre.ch[0] == leaf) {
                pre.ch[0] = new AvlNode(k, v);
            } else {
                pre.ch[0] = insert(pre.ch[0], k, v);
            }
        } else {
            if (pre.ch[1] == leaf) {
                pre.ch[1] = new AvlNode(k, v);
            } else {
                pre.ch[1] = insert(pre.ch[1], k, v);
            }
        }
        pre.height = Math.max(pre.ch[0].height, pre.ch[1].height) + 1;
        pre.size = pre.ch[0].size + pre.ch[1].size + 1;
        return rotate(pre);
    }

    private AvlNode remove(AvlNode pre, int k) {
        if (pre == leaf) {
            return pre;
        }
        if (k < pre.key) {
            pre.ch[0] = remove(pre.ch[0], k);
        } else if (k > pre.key) {
            pre.ch[1] = remove(pre.ch[1], k);
        } else {
            if (pre.ch[0] == leaf && pre.ch[1] == leaf) {
                return leaf;
            } else if (pre.ch[0] == leaf) {
                AvlNode preRight = pre.ch[1];
                pre.ch[1] = null;
                pre = preRight;
            } else if (pre.ch[1] == leaf) {
                AvlNode preLeft = pre.ch[0];
                pre.ch[0] = null;
                pre = preLeft;
            } else {
                // TODO
            }
        }
        pre.height = Math.max(pre.ch[0].height, pre.ch[1].height) + 1;
        pre.size = pre.ch[0].size + pre.ch[1].size + 1;
        return rotate(pre);
    }

    public void remove(int k) {
        if (root == null) {
            return;
        }
        root = remove(root, k);
    }
}