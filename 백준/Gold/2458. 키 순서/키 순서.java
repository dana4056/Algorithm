import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		boolean[][] dp = new boolean[N+1][N+1];

		for(int i = 0 ; i < M ; i++){
			String[] AB = br.readLine().split(" ");
			int A = Integer.parseInt(AB[0]);
			int B = Integer.parseInt(AB[1]);

			dp[A][B] = true;
		}

		for(int m = 1 ; m <= N ; m++){
			for(int s = 1 ; s <= N ; s++){
				if(s == m) continue;
				for(int e = 1 ; e <= N ; e++){
					if(e == m || e == s) continue;
					if(dp[s][m] && dp[m][e]){
						dp[s][e] = true;
					}
				}
			}
		}

		int total = 0;
		for(int i = 1 ; i<= N ; i++){
			int cnt = 0;
			for(int j = 1 ; j <= N ; j++){
				if(dp[i][j] || dp[j][i]) cnt++;
			}
			if(cnt == N-1) total++;
		}
		System.out.println(total);
	}
}
