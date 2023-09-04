import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int INF = 1000000;
		int[][] cost = new int[3][N+1];
		int[][] dp = new int[3][N+1];

		for(int i = 1 ; i <= N ; i++){
			String[] RGB = br.readLine().split(" ");
			int R = Integer.parseInt(RGB[0]);
			int G = Integer.parseInt(RGB[1]);
			int B = Integer.parseInt(RGB[2]);

			cost[0][i] = R;
			cost[1][i] = G;
			cost[2][i] = B;
		}

		int ans = INF;
		for(int c = 0 ; c < 3 ; c++){
			for(int i = 0 ; i < 3 ; i++){
				if(i == c){
					dp[i][1] = cost[i][1];
				}else{
					dp[i][1] = INF;
				}
			}

			for(int i = 2 ; i <= N ; i++){
				dp[0][i] = Math.min(dp[1][i-1], dp[2][i-1]) + cost[0][i];
				dp[1][i] = Math.min(dp[0][i-1], dp[2][i-1]) + cost[1][i];
				dp[2][i] = Math.min(dp[0][i-1], dp[1][i-1]) + cost[2][i];
			}

			for(int i = 0 ; i < 3 ; i++){
				if(i != c){
					ans = Math.min(ans, dp[i][N]);
				}
			}
		}
		System.out.println(ans);
	}
}
