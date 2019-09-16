#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

pair<int,int> n[10001];
int main() {
    int N,M,R,x,y,p,c=0;
    cin >> N >> M >> R;
    
    for(int i = 0; i < N;i++){
        cin >> x >> y;
        n[i] = make_pair(x,y);
    }
    
    for(int i = 0; i < M;i++){
        cin >> p;
        for(int j = 0; j < N;j++){
            if(p >= n[j].first && p <= n[j].second) c++;//:)
        }
    }
    
    cout << c;
    
    return 0;
}
