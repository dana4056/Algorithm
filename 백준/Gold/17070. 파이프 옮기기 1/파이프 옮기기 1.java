import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	static int N;
	static int[][] arr;
	static int ans = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		
		for(int i = 1 ; i<= N ; i++) {
			String[] temp = br.readLine().split(" ");
			for(int j = 1 ; j <= N ; j++) {
				arr[i][j] = Integer.parseInt(temp[j-1]);
			}
		}
		
		
		DFS(1,2,0);
		System.out.println(ans);

		
	}

	private static void DFS(int r, int c, int d) {
		if(r == N && c == N) {
			ans++;
			return;
		}

		
		if(d == 0) {
			if(c+1<=N && arr[r][c+1] == 0) DFS(r,c+1,0);
		}else if(d == 1) {
			if(r+1<=N && arr[r+1][c] == 0) DFS(r+1,c,1);
		}else if(d == 2) {
			if(c+1<=N && arr[r][c+1] == 0) DFS(r,c+1,0);
			if(r+1<=N && arr[r+1][c] == 0) DFS(r+1,c,1);
		}
		if(c+1<=N && r+1<=N && arr[r][c+1] == 0 && arr[r+1][c] == 0 && arr[r+1][c+1] == 0)DFS(r+1,c+1,2);
	}
}
