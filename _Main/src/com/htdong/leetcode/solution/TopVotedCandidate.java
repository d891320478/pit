package com.htdong.leetcode.solution;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 *
 * @author htdong
 * @date 2018年9月29日 上午10:21:31
 */

public class TopVotedCandidate {

    int[] ans;
    int[] times;

    class Vote implements Comparator<Vote>, Comparable<Vote> {
        int s, t;
        int ind;

        @Override
        public int compare(Vote o1, Vote o2) {
            if (o1.s > o2.s) {
                return 1;
            }
            if (o1.s < o2.s) {
                return -1;
            }
            if (o1.t > o2.t) {
                return 1;
            }
            if (o1.t < o2.t) {
                return -1;
            }
            return 0;
        }

        @Override
        public int compareTo(Vote o) {
            return this.compare(this, o);
        }
    }

    public TopVotedCandidate(int[] persons, int[] times) {
        int n = persons.length;
        ans = new int[n];
        this.times = times;
        Map<Integer, Vote> map = new HashMap<>();
        TreeSet<Vote> set = new TreeSet<>();
        for (int i = 0; i < n; ++i) {
            Vote vote = map.get(persons[i]);
            if (vote == null) {
                vote = new Vote();
                vote.s = 0;
                vote.ind = persons[i];
                map.put(persons[i], vote);
            }
            set.remove(vote);
            vote.t = times[i];
            ++vote.s;
            set.add(vote);
            ans[i] = set.last().ind;
        }
    }

    public int q(int t) {
        int l = 0, r = times.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (times[mid] > t) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return ans[l];
    }
}