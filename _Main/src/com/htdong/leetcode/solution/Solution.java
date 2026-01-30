package com.htdong.leetcode.solution;

import java.util.TreeSet;

import com.htdong.leetcode.algorithm.Base;

/**
 * @author htdong
 * @date 2019年11月7日 下午4:56:49
 */
public class Solution extends Base {

    public static class Edge {
        int next, v;
        long w;

        public Edge(int next, int v, long w) {
            this.next = next;
            this.v = v;
            this.w = w;
        }
    }

    public int[] head;
    public Edge[] e;
    public int cnt;

    public void init(int n, int m) {
        head = new int[n];
        for (int i = 0; i < n; ++i) {
            head[i] = -1;
        }
        e = new Edge[m];
        cnt = 0;
    }

    public void addEdge(int u, int v, long w) {
        e[cnt] = new Edge(head[u], v, w);
        head[u] = cnt++;
    }

    private void dfs(int u, int p, long[] d) {
        for (int i = head[u]; i != -1; i = e[i].next) {
            if (e[i].v != p) {
                d[e[i].v] = d[u] + 1;
                dfs(e[i].v, u, d);
            }
        }
    }

    private boolean f(long a, long b, long c) {
        long aa = a * a;
        long bb = b * b;
        long cc = c * c;
        return aa + bb == cc || aa + cc == bb || bb + cc == aa;
    }

    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        init(n, n * 2);
        for (int[] edge : edges) {
            addEdge(edge[0], edge[1], 1);
            addEdge(edge[1], edge[0], 1);
        }
        long[][] d = new long[3][n];
        dfs(x, -1, d[0]);
        dfs(y, -1, d[1]);
        dfs(z, -1, d[2]);
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (f(d[0][i], d[1][i], d[2][i])) {
                ++cnt;
            }
        }
        return cnt;
    }

    public int minLengthAfterRemovals(String s) {
        int n = s.length();
        int[] a = new int[s.length() + 1];
        for (int i = 1; i <= n; ++i) {
            a[i] = a[i - 1];
            if (s.charAt(i - 1) == 'a') {
                ++a[i];
            }
        }
        int ans = n;
        for (int i = 1; i <= n;) {
            int k = i;
            for (int j = i + 1; j <= n;) {
                if ((a[j] - a[i - 1]) * 2 == j - i + 1) {
                    k = j + 1;
                    j += 2;
                } else {
                    int mx = Math.max(a[j] - a[i - 1], j - i + 1 - (a[j] - a[i - 1]));
                    j = i + mx * 2 - 1;
                }
            }
            ans -= k - i;
            i = k == i ? i + 1 : k;
        }
        return ans;
    }

    public int xorAfterQueries(int[] a, int[][] queries) {
        int n = a.length;
        for (int[] q : queries) {
            for (int i = q[0]; i <= q[1]; i += q[2]) {
                a[i] = (int)(((long)a[i] * q[3]) % MOD);
            }
        }
        int x = a[0];
        for (int i = 1; i < n; ++i) {
            x ^= a[i];
        }
        return x;
    }

    public int distinctPoints(String s, int m) {
        TreeSet<Pair> set = new TreeSet<>(Pair::compareTo);
        int n = s.length();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        int[] c = new int[n + 1];
        int[] d = new int[n + 1];
        int x = 0, y = 0;
        for (int i = 0; i < s.length(); ++i) {
            a[i + 1] = a[i];
            b[i + 1] = b[i];
            c[i + 1] = c[i];
            d[i + 1] = d[i];
            switch (s.charAt(i)) {
                case 'U' -> {
                    ++x;
                    ++a[i + 1];
                }
                case 'D' -> {
                    --x;
                    ++b[i + 1];
                }
                case 'L' -> {
                    ++y;
                    ++c[i + 1];
                }
                case 'R' -> {
                    --y;
                    ++d[i + 1];
                }
            }
        }
        for (int i = 1; i + m - 1 <= n; ++i) {
            int xx = x, yy = y;
            xx += a[i + m - 1] - a[i - 1];
            xx -= b[i + m - 1] - b[i - 1];
            yy += c[i + m - 1] - c[i - 1];
            yy -= d[i + m - 1] - d[i - 1];
            set.add(new Pair(xx, yy));
        }
        return set.size();
    }

    public int[] sumAndMultiply(String s, int[][] q) {
        int n = s.length();
        int m = q.length;
        long[] a = new long[n];
        a[0] = 1;
        for (int i = 1; i < n; ++i) {
            a[i] = a[i - 1] * 10 % MOD;
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; ++i) {
            long sum = 0;
            long x = 0;
            for (int j = q[i][1], k = 0; j >= q[i][0]; --j) {
                if (s.charAt(j) == '0') {
                    continue;
                }
                int v = s.charAt(j) - '0';
                sum += v;
                x = (x + a[k++] * v) % MOD;
            }
            ans[i] = (int)(sum * x % MOD);
        }
        return ans;
    }

    public int maxBalancedSubarray(int[] a) {
        int n = a.length;
        int[] b = new int[n + 1];
        int[] c = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            b[i + 1] = b[i] ^ a[i];
            c[i + 1] = c[i] + a[i] ^ 1;
        }
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = i + ans; j <= n; ++j) {
                if ((j - i + 1) % 2 != 0) {
                    continue;
                }
                if ((b[j] ^ b[i - 1]) == 0 && c[j] - c[i - 1] == (j - i + 1) / 2) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}