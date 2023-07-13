import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);

		int[][] dp = new int[N+1][K+1];

		for(int i = 0 ; i <= N ; i++){
			for(int j = 0 ; (j <= K && j <= i) ; j++){
				if(j == 0){
					dp[i][j] = 1;
				}else{
					dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % 10007;
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}
