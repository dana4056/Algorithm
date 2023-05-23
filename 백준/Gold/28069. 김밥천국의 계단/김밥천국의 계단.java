import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);	// 계단 수
		int K = Integer.parseInt(NK[1]);	// 행동 수

		int[] DP = new int[N+1];
		for(int i = 1 ; i<= N ; i++){
			DP[i] = Integer.MAX_VALUE;
		}

		for(int i  = 0 ; i <= N ; i++){			
			if(i+1 <= N){
				DP[i+1] = Math.min(DP[i] + 1, DP[i+1]);
			}
			
			if(i + Math.round(i/2) <= N && DP[i + Math.round(i/2)] != 0){
				DP[i + Math.round(i/2)] = Math.min(DP[i] + 1, DP[i + Math.round(i/2)]);
			}
		}

		System.out.println( K < DP[N] ? "water" : "minigimbob");

	}
}
