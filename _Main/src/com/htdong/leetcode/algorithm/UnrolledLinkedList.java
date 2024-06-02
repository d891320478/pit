package com.htdong.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO https://codeforces.com/contest/455/problem/D
 * @author htdong
 * @date 2023-03-02 20:16:52
 */
public class UnrolledLinkedList {

    private int sqrtn;
    private ListNode head;
    private int size;

    public UnrolledLinkedList(int maxSize) {
        sqrtn = Math.max(1, (int)Math.sqrt(maxSize));
        head = new ListNode();
        size = 0;
    }

    public void init(int[] s) {
        ListNode next = head;
        size = s.length;
        for (int i = 0; i < s.length; ++i) {
            if (next.getSize() > sqrtn) {
                next.next = new ListNode();
                next = next.next;
            }
            next.add(s[i]);
        }
    }

    public int get(int i) {
        ListNode next = head;
        for (; next != null;) {
            if (next.getSize() >= i) {
                return next.get(i - 1);
            } else {
                i -= next.getSize();
                next = next.next;
            }
        }
        return 0;
    }

    public int getSize() {
        return size;
    }

    public void add(int ch, int i) {
        ListNode next = head;
        for (; next != null;) {
            if (next.getSize() + 1 >= i) {
                next.add(i - 1, ch);
                ++size;
                return;
            } else {
                i -= next.getSize();
                next = next.next;
            }
        }
    }

    public void remove(int i) {
        ListNode next = head;
        for (; next != null;) {
            if (next.getSize() >= i) {
                next.remove(i - 1);
                --size;
                return;
            }
            i -= next.getSize();
            next = next.next;
        }
    }

    public int count(int m, int v) {
        ListNode next = head;
        int cnt = 0;
        for (; next != null && next.getSize() <= m; next = next.next) {
            m -= next.getSize();
            cnt += next.map.getOrDefault(v, 0);
        }
        for (int i = 0; i < m; ++i) {
            if (next.get(i) == v) {
                ++cnt;
            }
        }
        return cnt;
    }

    private class ListNode {
        private ListNode next;
        private Map<Integer, Integer> map = new HashMap<>();
        private int[] list = new int[sqrtn * 2 + 5];
        private int size;

        public int getSize() {
            return size;
        }

        public int get(int i) {
            return list[i];
        }

        public void remove(int i) {
            int v = get(i);
            map.put(v, map.get(v) - 1);
            for (; i + 1 < size; ++i) {
                list[i] = list[i + 1];
            }
            --size;
            merge();
        }

        public void add(Integer ch) {
            add(size, ch);
        }

        public void add(int idx, Integer ch) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            for (int i = size; i > idx; --i) {
                list[i] = list[i - 1];
            }
            list[idx] = ch;
            ++size;
            split();
        }

        private void merge() {
            if (next != null && size + next.size <= sqrtn) {
                ListNode nn = next;
                for (int i = 0; i < nn.getSize(); ++i) {
                    add(nn.get(i));
                }
                next = nn.next;
            }
            split();
        }

        private void split() {
            if (size > 2 * sqrtn) {
                ListNode nn = new ListNode();
                next = nn;
                nn.next = next;
                for (int i = sqrtn + 1; i < next.getSize(); ++i) {
                    nn.add(list[i]);
                }
                size -= nn.getSize();
            }
        }
    }
}