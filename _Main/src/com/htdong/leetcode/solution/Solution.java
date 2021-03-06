package com.htdong.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.htdong.leetcode.algorithm.Base;

/**
 * @author htdong
 * @date 2019年11月7日 下午4:56:49
 */
public class Solution {

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int idx(int l, int r) {
        return (l + r) | (l != r ? 1 : 0);
    }

    private long dfs(long[][] d, int n, int k) {
        if (d[n][k] != -1) {
            return d[n][k];
        }
        if (k > n - 1 || n == 0) {
            return d[n][k] = 0;
        }
        if (k == 1 && n > 0) {
            return d[n][k] = 1;
        }
        long sum = 0;
        for (int i = 0; i < n; ++i) {

        }
        return d[n][k] = sum;
    }

    public int numberOfSets(int n, int k) {
        // https://leetcode.com/problems/number-of-sets-of-k-non-overlapping-line-segments/
        long[][] d = new long[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                d[i][j] = -1;
            }
        }
        d[0][0] = 1;
        return (int) dfs(d, n, k);
    }

    public int longestMountain(int[] a) {
        int[] b = new int[a.length - 1];
        for (int i = 0; i + 1 < a.length; ++i) {
            if (a[i] < a[i + 1]) {
                b[i] = -1;
            } else if (a[i] > a[i + 1]) {
                b[i] = 1;
            }
            if (i > 0) {
                b[i] += b[i - 1];
            }
        }
        int ans = 0;
        for (int i = 0; i + 2 < a.length; ++i) {
            if (b[i] - (i - 1 >= 0 ? b[i - 1] : 0) != -1 || b[i + 1] - b[i] != 1) {
                continue;
            }
            int l = 0, r = i;
            while (l < r) {
                int mid = l + r >> 1;
                if (b[i] - (mid - 1 >= 0 ? b[mid - 1] : 0) != -(i - mid + 1)) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            int ll = i - l + 2;
            l = i + 1;
            r = a.length - 2;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (b[mid] - b[i] == mid - i) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            ll += l - i;
            ans = Math.max(ll, ans);
        }
        return ans;
    }

    boolean flag;

    private String key(List<Integer> list) {
        return String.join("_", list.stream().map(i -> i.toString()).collect(Collectors.toList()));
    }

    private List<Integer> fkey(String u) {
        List<Integer> list = new ArrayList<>();
        String[] s = u.split("_");
        for (String i : s) {
            list.add(Integer.parseInt(i));
        }
        return list;
    }

    public int shoppingOffers(List<Integer> p, List<List<Integer>> special, List<Integer> needs) {
        // https://leetcode.com/problems/shopping-offers/
        int n = p.size();
        for (int i = 0; i < n; ++i) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                list.add(j == i ? 1 : 0);
            }
            list.add(p.get(i));
            special.add(list);
        }
        Map<String, Integer> map = new HashMap<>();
        List<Integer> lll = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            lll.add(0);
        }
        map.put(key(lll), 0);
        TreeSet<String> q = new TreeSet<>();
        q.addAll(map.keySet());
        while (!q.isEmpty()) {
            String u = q.first();
            q.remove(u);
            int v = map.get(u);
            List<Integer> list = fkey(u);
            for (List<Integer> i : special) {
                boolean flag = true;
                for (int j = 0; j < n; ++j) {
                    if (list.get(j) + i.get(j) > needs.get(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    int vv = v + i.get(n);
                    List<Integer> ll = new ArrayList<>();
                    for (int j = 0; j < n; ++j) {
                        ll.add(list.get(j) + i.get(j));
                    }
                    String vk = key(ll);
                    if (!map.containsKey(vk) || vv < map.get(vk)) {
                        map.put(vk, vv);
                        q.add(vk);
                    }
                }
            }
        }
        return map.get(key(needs));
    }

    public int leastInterval(char[] t, int n) {
        int nt = t.length;
        char[] c = new char[nt * 100 + 5];
        int[] cnt = new int[26];
        for (char i : t) {
            ++cnt[i - 'A'];
        }
        int max = 0;
        for (int i = 0;;) {
            int k = -1;
            int mx = 0;
            for (int j = 0; j < 26; ++j) {
                if (cnt[j] > mx) {
                    mx = cnt[j];
                    k = j;
                }
            }
            if (k == -1) {
                break;
            }
            while (c[i] != 0) {
                ++i;
            }
            for (int j = 0; j < cnt[k]; ++j) {
                c[i + j * (n + 1)] = (char) ('A' + k);
            }
            max = Math.max(max, i + (cnt[k] - 1) * (n + 1));
            cnt[k] = 0;
        }
        return max + 1;
    }

    public int mincostTickets(int[] days, int[] costs) {
        // TODO https://leetcode.com/problems/minimum-cost-for-tickets/
        return 0;
    }

    public String largestMultipleOfThree(int[] d) {
        // https://leetcode.com/problems/largest-multiple-of-three/submissions/
        StringBuilder sb = new StringBuilder();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        for (int i = 0; i < d.length; ++i) {
            if (d[i] % 3 == 0) {
                a.add(d[i]);
            } else if (d[i] % 3 == 1) {
                b.add(d[i]);
            } else {
                c.add(d[i]);
            }
        }
        a.sort(Integer::compareTo);
        b.sort(Integer::compareTo);
        c.sort(Integer::compareTo);
        if (b.size() == 0 && c.size() < 3 || c.size() == 0 && b.size() < 3) {
            if (a.isEmpty()) {
                return "";
            } else if (a.get(a.size() - 1) == 0) {
                return "0";
            }
        }

        a.sort(Integer::compareTo);
        for (int x = a.size() - 1; x >= 0; --x) {
            sb.append(a.get(x));
        }
        return sb.toString();
    }

    public int numWays(int s, int t) {
        if (t > s) {
            t = s;
        }
        int[][] d = new int[s + 1][t + 1];
        d[0][0] = 1;
        for (int i = 1; i <= s; ++i) {
            for (int j = 0; j <= t; ++j) {
                d[i][j] = (d[i - 1][j] + (j - 1 >= 0 ? d[i - 1][j - 1] : 0)) % Base.MOD
                        + (j + 1 <= t ? d[i - 1][j + 1] : 0);
                d[i][j] %= Base.MOD;
            }
        }
        return d[s][0];
    }
}