#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<cmath>
#include<iostream>
#include<algorithm>
#include<string>
#include<map>
#include<set>
#include<queue>
#include<stack>
#include<ctime>
#include<vector>
#include<utility>
using namespace std;

#define INF (1<<30)
#define EPS 1e-6
#define PI acos(-1)
#define lowbit(x) ((x) & (-(x)))
#define IDX(l,r) ((l)+(r) | (l)!=(r))
#define ABS(x) ((x)>0?(x):-(x))
#define SET(a,b) memset(a,b,sizeof(a))
#define N 500
struct point { double x, y; }p[N];
double dist[N][N];
struct lis { double a;	bool flag;	int id; }lit[10 * N];
double dis(point a, point b) { return sqrt(pow(a.x - b.x, 2.0) + pow(a.y - b.y, 2.0)); }
int cmp(const lis& a, const lis& b) { if (a.a < b.a)return 1; if (a.a == b.a)return a.id > b.id; return 0; }

int n, a[10010], cnt = 1;

int main() {
    cin >> n;
    a[1] = 1;
    for (int i = 2; i <= n; ++i) {
        int c = 2;
        for (int j = 2; j * j <= i; ++j) {
            if (i % j == 0) {
                c = max(c, max(a[j], a[i / j]) + 1);
            }
        }
        a[i] = c;
        cnt = max(c, cnt);
    }
    printf("%d\n", cnt);
    for (int i = 1; i <= n; ++i) {
        printf("%d%c", a[i], i == n ? '\n' : ' ');
    }

    return 0;
}