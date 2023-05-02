import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int t = 0 ; t < T ; t++){
			int MAX = Integer.MIN_VALUE;
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][N+2];
			int[][] DP = new int[2][N+2];

			// 배열 입력
			for (int r = 0 ; r < 2 ; r++){
				String[] tmp = br.readLine().split(" ");
				for(int c = 2 ; c <= N+1 ; c++){
					arr[r][c] = Integer.parseInt(tmp[c-2]);
				}
			}

			for(int c = 2 ; c <= N+1 ; c++){
				for(int r = 0 ; r < 2 ; r++){
					if(r == 0){
						DP[r][c] = Math.max(DP[r+1][c-1] + arr[r][c], DP[r+1][c-2] + arr[r][c]);
					}else{
						DP[r][c] = Math.max(DP[r-1][c-1] + arr[r][c], DP[r-1][c-2] + arr[r][c]);
					}
					MAX = Math.max(DP[r][c], MAX);
				}
			}
			System.out.println(MAX);
		}

	}
}
