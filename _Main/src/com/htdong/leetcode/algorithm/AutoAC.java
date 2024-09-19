package com.htdong.leetcode.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dht31261
 * @date 2024年8月30日 14:39:47
 */
public class AutoAC {

    private static final int M = 26;

    public static class Node {
        public int end;
        public Node[] next;
        public Node fail;

        public Node() {
            next = new Node[M];
            end = -1;
        }
    }

    private Node root;

    public AutoAC() {
        root = new Node();
    }

    public void insert(String s, int idx) {
        Node nxt = root;
        for (int i = 0; i < s.length(); ++i) {
            if (nxt.next[s.charAt(i) - 'a'] == null) {
                nxt.next[s.charAt(i) - 'a'] = new Node();
            }
            nxt = nxt.next[s.charAt(i) - 'a'];
        }
        nxt.end = idx;
    }

    public void build() {
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < M; ++i) {
            if (root.next[i] == null) {
                root.next[i] = root;
            } else {
                root.next[i].fail = root;
                q.add(root.next[i]);
            }
        }
        while (!q.isEmpty()) {
            Node u = q.poll();
            for (int i = 0; i < M; ++i) {
                if (u.next[i] == null) {
                    u.next[i] = u.fail.next[i];
                } else {
                    u.next[i].fail = u.fail.next[i];
                    q.add(u.next[i]);
                }
            }
        }
    }
}