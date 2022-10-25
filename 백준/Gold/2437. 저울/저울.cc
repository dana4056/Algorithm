#include <iostream>
using namespace std;

int main() {
	int N;//추의 개수
	int weight[1000]; //추의 무게들

	cin >> N;
	for (int i = 0; i < N; i++)
		cin >> weight[i];

 	for(int j=0;j<N;j++){     //무게들 오름차순으로 정렬
		for (int i = j; i < N; i++) {
			if (weight[j] > weight[i]) {
				int tmp = weight[j];
				weight[j] = weight[i];
				weight[i] = tmp;
			}
		}
	}

	int sum = 1;
	for (int i = 0; i < N; i++) {
		if (sum < weight[i])
			break;
		else sum += weight[i];
	}

	cout << sum << endl;

}