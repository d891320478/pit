package com.htdong.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author htdong
 * @date 2018年10月26日 下午2:59:35
 */

public class StockSpanner {

    class Stack {
        public int idx;
        public int val;

        public Stack() {
        }

        public Stack(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    private int idx;
    private List<Stack> list;

    public StockSpanner() {
        idx = 0;
        list = new ArrayList<>();
        list.add(new Stack(idx, 100000000));
    }

    public int next(int price) {
        ++idx;
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (list.get(mid).val <= price) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        int ans = idx - list.get(l).idx;
        while (list.get(list.size() - 1).val <= price) {
            list.remove(list.size() - 1);
        }
        list.add(new Stack(idx, price));
        return ans;
    }
}
