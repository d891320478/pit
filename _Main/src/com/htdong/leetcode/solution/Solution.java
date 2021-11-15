package com.htdong.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.htdong.leetcode.algorithm.Base;

/**
 * @author htdong
 * @date 2019年11月7日 下午4:56:49
 */
public class Solution {

<<<<<<< HEAD
    public static final int N = 30;
    public static final int M = 2010;
    public static final int INF = (1 << 30);
    private int cnt, s, t, ans;
    private int[] head = new int[N], d = new int[N], pre = new int[N];
    private boolean[] vis = new boolean[N];

    private static class Edge {
        int v, w, c, next;

        public Edge(int v, int w, int c, int next) {
            this.v = v;
            this.w = w;
            this.c = c;
            this.next = next;
        }

    }

    Edge[] e = new Edge[M];

    void addEdge(int u, int v, int w, int c) {
        e[cnt] = new Edge(v, w, c, head[u]);
        head[u] = cnt++;
        e[cnt] = new Edge(u, 0, -c, head[v]);
        head[v] = cnt++;
    }

    Queue<Integer> q = new LinkedList<>();

    boolean spfa() {
        for (int i = 0; i < N; ++i) {
            pre[i] = d[i] = -1;
            vis[i] = false;
        }
        d[s] = 0;
        q.add(s);
        while (!q.isEmpty()) {
            int u = q.poll();
            vis[u] = false;
            for (int i = head[u]; i != -1; i = e[i].next)
                if (e[i].w > 0)
                    if (d[e[i].v] == -1 || d[e[i].v] > d[u] + e[i].c) {
                        d[e[i].v] = d[u] + e[i].c;
                        pre[e[i].v] = i;
                        if (!vis[e[i].v]) {
                            q.add(e[i].v);
                            vis[e[i].v] = true;
                        }
                    }
        }
        return d[t] != -1;
    }

    int mcmf() {
        ans = 0;
        while (spfa()) {
            int u, mn = INF;
            for (u = t; u != s; u = e[pre[u] ^ 1].v)
                mn = Math.min(mn, e[pre[u]].w);
            ans += mn * d[t];
            for (u = t; u != s; u = e[pre[u] ^ 1].v) {
                e[pre[u]].w -= mn;
                e[pre[u] ^ 1].w += mn;
            }
        }
        return ans;
    }

    public int maximumRequests(int n, int[][] r) {
        s = n;
        t = n + 1;
        cnt = 0;
        for (int i = 0; i < N; ++i) {
            head[i] = -1;
        }
        for (int[] a : r) {
            addEdge(a[0], a[1], 1, 1);
            addEdge(s, a[0], 1, 1);
            addEdge(a[0], t, 1, 0);
        }
        return mcmf();
    }

=======
>>>>>>> a8f954f3e09834305ee874b0bf811d7090e95191
    public int maxProductPath(int[][] a) {
        // TODO https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/
        int n = a.length;
        int m = a[0].length;
        Long[][][] b = new Long[n][m][2];
        for (int j = 0; j < m; ++j) {
            if (a[0][j] >= 0)
                b[0][j][0] = (long) a[0][j];
            else
                b[0][j][1] = (long) a[0][j];
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < m; ++j) {

            }
        }
        return -1;
    }

    public int maxDistance(int[] a, int[] b) {
        int ans = 0;
        for (int i = 0; i < Math.min(a.length, b.length); ++i) {
            int l = i, r = b.length - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (b[mid] >= a[i]) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (b[l] >= a[i]) {
                ans = Math.max(ans, l - i);
            }
        }
        return ans;
    }

    public static int MOD = 1000000007;

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
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