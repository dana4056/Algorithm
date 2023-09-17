import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        if(N == 1){
			System.out.println(0);
			return;
		}
        
		int[] prime = getPrimeArr(N);
		int len = prime.length;

		int left = 0, right = 0, cnt = 0;
		int sum = prime[left];
		while(left <= right){
			if(left == len -1  && right == len-1) {
				if(prime[len-1] == N) cnt++;
				break;
			}
			if(sum >= N) {
				if(sum == N) cnt++;
				sum -= prime[left];
				if(left + 1 < len) left++;
			}else{
				if(right + 1 < len){
					sum += prime[++right];
				}
			}
		}
		System.out.println(cnt);
	}

	private static int[] getPrimeArr(int n) {
		boolean[] isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);

		int cnt = n-1;
		for(int i = 2 ; i*i <= n ; i++){
			if(isPrime[i]){
				for(int j = i + i ; j <= n ; j += i){
					if(isPrime[j]){
						cnt--;
						isPrime[j] = false;
					}
				}
			}
		}

		int[] arr = new int[cnt];
		int idx = 0;
		for(int i = 2 ; i <= n ; i++){
			if(isPrime[i]){
				arr[idx++] = i;
			}
		}
		return arr;
	}
}
