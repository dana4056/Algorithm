import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		boolean[][] dp = new boolean[N+1][N+1];

		String[] line = br.readLine().split(" ");
		for(int i = 1 ; i <= N ; i++){
			arr[i] = Integer.parseInt(line[i-1]);
			dp[i][i] = true;							// 한 개짜리 팰린드롬
			if(arr[i] == arr[i-1]) dp[i-1][i] = true;	// 두 개짜리 팰린드롬
		}

		for(int d = 2 ; d < N ; d++){	// d: 간격
			for(int s = 1 ; s <= N-d ; s++){
				int e = s + d;
				if(arr[s] == arr[e] && dp[s+1][e-1]){
					dp[s][e] = true;
				}
			}
		}

		int M = Integer.parseInt(br.readLine());
		for(int i  = 0; i < M ; i++){
			String[] SE = br.readLine().split(" ");
			int S = Integer.parseInt(SE[0]);
			int E = Integer.parseInt(SE[1]);

			if(dp[S][E]){
				sb.append(1).append("\n");
			}else{
				sb.append(0).append("\n");
			}
		}

		System.out.println(sb);
	}
}
