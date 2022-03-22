#include <sys/timeb.h>
#include <cmath>
#include <algorithm>
#include <iostream>
#include <map>
#include <string>

using namespace std;

#define idx(l,r) ((l)+(r) | (l)!=(r))

class Solution {
public:
}a;

int main() {
    timeb t;
    ftime(&t);
    long t1 = t.time * 1000 + t.millitm;
    cout << &a << endl;
    ftime(&t);
    long t2 = t.time * 1000 + t.millitm;
    cout << "time = " << t2 - t1 << endl;
    return 0;
}
