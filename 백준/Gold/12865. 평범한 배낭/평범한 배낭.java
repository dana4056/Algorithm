import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = br.readLine().split(" ");

		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);

		int[] W = new int[N+1]; // 무게 리스트
		int[] V = new int[N+1]; // 가치 리스트

		for(int i = 1 ; i <= N ; i++){
			String[] wv = br.readLine().split(" ");
			int w = Integer.parseInt(wv[0]);    // 무게
			int v = Integer.parseInt(wv[1]);    // 가치

			W[i] = w;
			V[i] = v;
		}

		int[][] table = new int[N+1][K+1];      // DP 테이블

		for(int n = 1 ; n <= N ; n++){
			for(int k = 1; k <= K ; k++){
				if(W[n] > k ){
					table[n][k] = table[n-1][k];
				}else{
					table[n][k] = Math.max(table[n-1][k], V[n]+table[n-1][k-W[n]]);
				}
			}
		}

		System.out.print(table[N][K]);

	}
}