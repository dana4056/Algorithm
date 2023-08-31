import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int cnt1, cnt2;
	static int[] table;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		table = new int[N+1];
		table[1] = table[2] = 1;

		fib1(N);
		fib2(N);
		sb.append(cnt1).append(" ").append(cnt2);
		System.out.println(sb);
	}

	private static int fib1(int n) {
		if(n <= 2) {
			cnt1++;
			return 1;
		}
		else return fib1(n-1) + fib1(n-2);
	}

	private static int fib2(int n) {
		for(int i = 3 ; i <= n ; i++){
			cnt2++;
			table[i] = table[i-1] + table[i-2];
		}
		return table[n];
	}
}
