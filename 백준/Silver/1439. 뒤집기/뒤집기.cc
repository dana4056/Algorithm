#include <iostream>
#include <string>
using namespace std;
int main() {
	string s;
	getline(cin, s );
	int count = 0;
	int now=s[0];

	for (int i = 0; i < s.length(); i++) {
		
		if (s[i] != now) {    //숫자가 달라지는 순간 카운트
			if (s[i - 1] == s[i]) continue;  //연속되는 숫자는 생략
			count++;
		}
	}
	cout << count;
}