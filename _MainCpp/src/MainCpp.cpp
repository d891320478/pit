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

string str;
vector<string> a;
int n = 0;

int main() {
	while (getline(cin, str)) {
		a.push_back(str);
		n = max(n, (int)str.size());
	}
	for (int i = 0; i < n + 2; ++i) {
		printf("*");
	}
	printf("\n");

	bool flag = false;
	for (int i = 0;i < a.size();++i) {
		printf("*");
		int l = (n - a[i].size()) / 2;
		int r = (n - a[i].size()) / 2;
		if ((n - a[i].size()) % 2 == 1) {
			if (!flag) {
				++r;
			} else {
				++l;
			}
			flag = !flag;
		}
		for (int i = 0; i < l; ++i) {
			printf(" ");
		}
		cout << a[i];
		for (int i = 0; i < r; ++i) {
			printf(" ");
		}
		printf("*\n");
	}

	for (int i = 0; i < n + 2; ++i) {
		printf("*");
	}
	printf("\n");
}