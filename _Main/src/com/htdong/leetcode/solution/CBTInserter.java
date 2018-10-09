package com.htdong.leetcode.solution;

import com.htdong.leetcode.domain.TreeNode;

/**
 *
 * @author htdong
 * @date 2018年10月9日 下午3:54:12
 */

public class CBTInserter {

    int sz;
    TreeNode rt;

    public CBTInserter(TreeNode root) {
        this.sz = 0;
        this.rt = root;
        count(root);
    }

    private void count(TreeNode root) {
        if (root == null) {
            return;
        }
        ++sz;
        count(root.left);
        count(root.right);
    }

    public int insert(int v) {
        ++sz;
        if (rt == null) {
            rt = new TreeNode(v);
            return v;
        } else {
            int z = sz;
            TreeNode node = rt;
            int cnt = 0;
            while (z > 0) {
                ++cnt;
                z >>= 1;
            }
            --cnt;
            z = sz;
            while (cnt > 1) {
                if ((z & (1 << (cnt - 1))) > 0) {
                    node = node.right;
                } else {
                    node = node.left;
                }
                --cnt;
            }
            if ((z & 1) == 0) {
                node.left = new TreeNode(v);
            } else {
                node.right = new TreeNode(v);
            }
            return node.val;
        }
    }

    public TreeNode get_root() {
        return rt;
    }
}
