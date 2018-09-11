package com.htdong.leetcode.domain;

import java.util.List;

/**
 *
 * @author htdong
 * @date 2018年8月1日 下午3:35:04
 */

public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
