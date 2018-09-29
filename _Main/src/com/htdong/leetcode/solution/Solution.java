package com.htdong.leetcode.solution;

import com.htdong.leetcode.domain.TreeNode;

/**
 *
 * @author htdong
 * @date 2018年4月8日 下午2:35:54
 */

public class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0) {
            return null;
        }
        TreeNode rt = new TreeNode(pre[0]);
        if (pre.length == 1) {
            return rt;
        }
        int i = 0;
        for (; post[i] != pre[1]; ++i)
            ;
        int[] pr1 = new int[i + 1];
        int[] po1 = new int[i + 1];
        int[] pr2 = new int[pre.length - 2 - i];
        int[] po2 = new int[pre.length - 2 - i];
        for (int i1 = 0, i2 = 0, z = 0; z < pre.length - 1; ++z) {
            if (z <= i) {
                pr1[i1] = pre[z + 1];
                po1[i1] = post[z];
                ++i1;
            } else {
                pr2[i2] = pre[z + 1];
                po2[i2] = post[z];
                ++i2;
            }
        }
        rt.left = constructFromPrePost(pr1, po1);
        rt.right = constructFromPrePost(pr2, po2);
        return rt;
    }
}