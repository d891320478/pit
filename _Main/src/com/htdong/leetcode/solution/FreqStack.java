package com.htdong.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author htdong
 * @date 2018年8月29日 下午4:21:31
 */

public class FreqStack {

    class Heap {
        int v;
        LinkedList<Integer> list;

        public Heap(int v, int len) {
            this.v = v;
            this.list = new LinkedList<>();
            list.add(-1);
            list.add(len);
        }
    }

    int len;
    ArrayList<Heap> a;
    Map<Integer, Integer> map;

    public FreqStack() {
        len = 0;
        a = new ArrayList<>();
        map = new HashMap<>();
    }

    private void buildup(int i) {
        if (i == 0) {
            return;
        }
        int ip = (i - 1) / 2;
        Heap p = a.get(ip);
        Heap h = a.get(i);
        if (h.list.size() > p.list.size() || (h.list.size() == p.list.size() && h.list.getLast() > p.list.getLast())) {
            Heap tmp = a.get(ip);
            a.set(ip, a.get(i));
            a.set(i, tmp);
            map.put(p.v, i);
            map.put(h.v, ip);
            buildup(ip);
        }
    }

    private void builddown(int i) {
        if (i * 2 + 1 >= a.size()) {
            return;
        }
        Heap h = a.get(i);
        int is = i * 2 + 1;
        Heap s = a.get(is);
        if (i * 2 + 2 < a.size()) {
            Heap r = a.get(i * 2 + 2);
            if (r.list.size() > s.list.size()
                    || (r.list.size() == s.list.size() && r.list.getLast() > s.list.getLast())) {
                s = r;
                is = i * 2 + 2;
            }
        }
        if (h.list.size() < s.list.size() || (h.list.size() == s.list.size() && h.list.getLast() < s.list.getLast())) {
            Heap tmp = a.get(is);
            a.set(is, a.get(i));
            a.set(i, tmp);
            map.put(s.v, i);
            map.put(h.v, is);
            builddown(is);
        }
    }

    public void push(int x) {
        if (!map.containsKey(x)) {
            Heap h = new Heap(x, len++);
            a.add(h);
            map.put(x, a.size() - 1);
        } else {
            Heap h = a.get(map.get(x));
            h.list.add(len++);
        }
        buildup(map.get(x));
    }

    public int pop() {
        Heap h = a.get(0);
        h.list.removeLast();
        builddown(0);
        return h.v;
    }
}
