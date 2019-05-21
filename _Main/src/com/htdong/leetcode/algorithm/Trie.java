package com.htdong.leetcode.algorithm;

public class Trie {
    public boolean end;
    public Trie[] next;

    public Trie(boolean end, int len) {
        this.end = end;
        this.next = new Trie[len];
    }
}
