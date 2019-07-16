package com.htdong.leetcode.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author htdong
 * @date 2018年4月8日 下午2:35:54
 */

public class Solution {

    public List<String> findItinerary(List<List<String>> tickets) {
        // TODO https://leetcode.com/problems/reconstruct-itinerary/submissions/
        TreeMap<String, TreeSet<String>> gra = new TreeMap<>();
        HashSet<String> all = new HashSet<>();
        for (List<String> list : tickets) {
            all.add(list.get(0));
            all.add(list.get(1));
            TreeSet<String> set = gra.get(list.get(0));
            if (set == null) {
                set = new TreeSet<>();
                gra.put(list.get(0), set);
            }
            set.add(list.get(1));
            if (!gra.containsKey(list.get(1))) {
                gra.put(list.get(1), new TreeSet<>());
            }
        }
        List<String> ans = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();
        dfs("JFK", gra, vis, all.size(), ans);
        return ans;
    }

    private boolean dfs(String u, TreeMap<String, TreeSet<String>> gra, HashSet<String> vis, int n, List<String> ans) {
        vis.add(u);
        ans.add(u);
        if (ans.size() == n) {
            return true;
        }
        for (String iter : gra.get(u)) {
            if (!vis.contains(iter)) {
                boolean flag = dfs(iter, gra, vis, n, ans);
                if (flag) {
                    return true;
                }
            }
        }
        ans.remove(ans.size() - 1);
        vis.remove(u);
        return false;
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] ret = new int[deck.length];
        // TODO https://leetcode.com/problems/reveal-cards-in-increasing-order/
        return ret;
    }

    public int maxProfit(int[] p, int fee) {
        int[] d = new int[p.length];
        int[] e = new int[p.length];
        for (int i = 0; i < p.length; ++i) {
            e[i] = p[i] + fee;
        }
        // TODO
        // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
        for (int i = 1; i < p.length; ++i) {
            d[i] = d[i - 1];
            // d[i] = max(d[i], p[i]-p[k]-fee+d[k-1])
        }
        return d[p.length - 1];
    }
}