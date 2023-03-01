package com.htdong.leetcode.algorithm;

import java.util.LinkedList;
import java.util.Scanner;

public class UnrolledLinkedList {

    private int sqrtn;
    private Node head;
    private int size;

    public UnrolledLinkedList(int maxSize) {
        sqrtn = Math.max(1, (int)Math.sqrt(maxSize));
        head = new Node();
        head.next = new Node();
        size = 0;
    }

    public void init(String s) {
        Node next = head;
        for (int i = 0; i < s.length(); ++i) {
            if (next.getSize() > sqrtn) {
                next = next.next;
                next.next = new Node();
            }
            next.add(s.charAt(i));
        }
    }

    public void add(char ch, int i) {
        Node next = head;
        for (;;) {
            if (next.getSize() + 1 >= i) {
                add(next, ch, i);
                break;
            } else {
                i -= next.getSize();
                if (next.next == null) {
                    next.next = new Node();
                }
                next = next.next;
            }
        }
    }

    public char get(int i) {
        Node next = head;
        for (;;) {
            if (next.getSize() >= i) {
                return next.list.get(i - 1);
            } else {
                i -= next.getSize();
                next = next.next;
            }
        }
    }

    public int getSize() {
        return size;
    }

    private void add(Node next, char ch, int idx) {
        if (idx > next.getSize()) {
            next.add(ch);
        } else {
            next.add(idx - 1, ch);
        }
        ++size;
        if (next.getSize() > 2 * sqrtn) {
            Node nn = new Node();
            nn.next = next.next;
            next.next = nn;
            while (next.getSize() > sqrtn) {
                nn.addFirst(next.list.getLast());
                next.list.removeLast();
            }
        }
    }

    private class Node {
        private Node next;
        private LinkedList<Character> list = new LinkedList<Character>();

        public int getSize() {
            return list.size();
        }

        public void addFirst(Character ch) {
            list.addFirst(ch);
        }

        public void add(Character ch) {
            list.add(ch);
        }

        public void add(int idx, Character ch) {
            list.add(idx, ch);
        }
    }

    public static void main(String[] args) {
        UnrolledLinkedList ull = new UnrolledLinkedList(1000000);
        Scanner in = new Scanner(System.in);
        ull.init(in.next());
        int _t = in.nextInt();
        while (_t-- > 0) {
            String op = in.next();
            if (op.equals("Q")) {
                System.out.println(ull.get(in.nextInt()));
            } else {
                String sc = in.next();
                int idx = in.nextInt();
                ull.add(sc.charAt(0), idx);
            }
        }
    }
}