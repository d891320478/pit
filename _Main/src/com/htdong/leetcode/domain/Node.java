package com.htdong.leetcode.domain;

/**
 * @author htdong
 * @date 2018年8月1日 下午3:35:04
 */

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}