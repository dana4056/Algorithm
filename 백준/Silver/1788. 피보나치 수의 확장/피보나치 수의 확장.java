import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int INF = 1000000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int sign = 0;
		int ans = 0;
		int N = Integer.parseInt(br.readLine());
		int n = Math.abs(N);
		int[] dp = new int[n + 1];

		if(n != 0){
			dp[1] = 1;
			if(N > 1){
				for(int i = 2 ; i <= n ; i++){
					dp[i] = (dp[i-2] + dp[i-1]) % INF;
				}
			}else if( N < -1){
				for(int i = 2 ; i <= n ; i++){
					dp[i] = (dp[i-2] - dp[i-1]) % INF;
				}
			}
			ans = dp[n];
			sign = ans < 0 ? -1 : 1;
		}

		sb.append(sign).append("\n").append(Math.abs(ans));
		System.out.println(sb);
	}
}
