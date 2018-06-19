package com.htdong.leetcode.solution;

import java.util.TreeSet;

/**
 *
 * @author htdong
 * @date 2018年6月19日 下午3:48:28
 */

public class ExamRoom {

    Integer n;
    TreeSet<Integer> set;

    public ExamRoom(int N) {
        this.n = N;
        this.set = new TreeSet<>();
    }

    public int seat() {
        if (this.set.size() == 0) {
            this.set.add(0);
            return 0;
        } else if (this.set.size() == 1) {
            int x = this.set.iterator().next();
            if (x >= n - x) {
                this.set.add(0);
                return 0;
            } else {
                this.set.add(n - 1);
                return n - 1;
            }
        } else {
            int s = this.set.first() * -1;
            int t = n - 1 - this.set.last() + n - 1;
            this.set.add(t);
            Integer ans = null;
            int dis = -1;
            for (Integer i : set) {
                if ((i + s) / 2 - s > dis) {
                    dis = (i + s) / 2 - s;
                    ans = (i + s) / 2;
                }
                s = i;
            }
            if (t >= n) {
                this.set.remove(t);
            }
            this.set.add(ans);
            return ans;
        }
    }

    public void leave(int p) {
        this.set.remove(p);
    }
}
