import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// MainB1149_RGB거리
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N+1][3];
		int[][] dp = new int[N+1][3];
		
		for(int i = 0 ; i < N ; i++) {
			String[] temp = br.readLine().split(" ");
			for(int j = 0 ; j < 3 ; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		
//		d[0][0] = d[0][1] = d[0][2] = a[0][0] = a[0][1] = a[0][2] = 0;
		
		for(int i = 0 ; i < N ; i++) {
			if(i == 0) {
				dp[i][0] = arr[i][0];
				dp[i][1] = arr[i][1];
				dp[i][2] = arr[i][2];
			}else {
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
			}
		}
		System.out.println(Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));
	}

// 시간초과(완전탐색)	
/*	static int N;
	static int[][] arr;	
	static int MIN = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][3];
		
		for(int i = 0 ; i < N ; i++) {
			String[] temp = br.readLine().split(" ");
			for(int j = 0 ; j < 3 ; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		for(int i = 0 ; i < 3 ; i++) {
			DFS(0,i,arr[0][i]);	
		}
		System.out.println(MIN);
		
	}

	private static void DFS(int r, int c, int sum) {		
		if(r == N-1) {
			if(sum < MIN) MIN = sum;
			return;
		}
		
		for(int i = 0 ; i<3 ; i++) {
			if(i == c)continue;
			DFS(r+1,i,sum+arr[r+1][i]);
		}
	}	
*/
}


/*
3
26 40 83
49 60 57
13 89 99

96
 */
