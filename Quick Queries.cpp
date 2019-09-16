#include <iostream>
#include <vector>

#define scan(x) do{while((x=getchar())<'0'); for(x-='0'; '0'<=(_=getchar()); x=(x<<3)+(x<<1)+_-'0');}while(0)
char _;

std::vector<int> a;
std::vector<int> psa;
int main() {
    std::cin.sync_with_stdio(0);
    std::cin.tie(0);

    int N, M,q,x,y,z;
    std::cin >> N >> M;

    psa.push_back(0);
    for (int i = 1; i <= N; i++) {
        std::cin >> z;
        a.push_back(z);
        psa.push_back(z);
        psa[i] += psa[i - 1];
    }

    for (int i = 0; i < M; i++) {
        std::cin >> q;

        if (q == 0) {
            std::cin >> x >> y;
            std::cout << psa[y+1] - psa[x]<<"\n";
        }

        if (q == 1) {
            std::cin >> x;
            a.push_back(x);
            psa.push_back(psa[N] + x);
            N++;
        }

        if (q == 2) {
            a.pop_back();
            psa.pop_back();
            N--;
        }

    }

    return 0;
}