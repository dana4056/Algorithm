import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dr = {-1,1,0,0};	//상하좌우
	static int[] dc = {0,0,-1,1};	//상하좌우
	static double[] dir = new double[4];	//각 방향의 확률
	static int N;
	static double ans = 0.0;
	static boolean[][] visited = new boolean[29][29];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);

		for(int i = 1 ; i <= 4 ; i++){
			dir[i-1] = Integer.parseInt(input[i]) * 0.01;
		}

		visited[14][14] = true;
		dfs(14, 14, 0, 1.0);
		System.out.println(ans);

	}

	private static void dfs(int row, int col, int cnt, double p) {
		if(cnt == N){
			ans += p;
			return;
		}

		for(int i = 0 ;  i < 4 ; i++){
			int nr = row + dr[i];
			int nc = col + dc[i];
			if(!visited[nr][nc]){
				visited[nr][nc] = true;
				dfs(nr, nc, cnt+1, p * dir[i]);
				visited[nr][nc] = false;
			}
		}
	}


}
