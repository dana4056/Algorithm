import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, M, K;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NMK = br.readLine().split(" ");
		N = Integer.parseInt(NMK[0]);
		M = Integer.parseInt(NMK[1]);
		K = Integer.parseInt(NMK[2]);

		char[][] arr = new char[N][M];
		int[][][] visited = new int[N][M][K+1];

		for(int i = 0 ; i < N ; i++){
			String line = br.readLine();
			for(int j = 0 ; j < M ; j++){
				arr[i][j] = line.charAt(j);
			}
		}

		Queue<Spot> q = new LinkedList<>();
		q.add(new Spot(0,0, 1, 0, true));
		visited[0][0][0] = 1;

		while(!q.isEmpty()){
			Spot now = q.poll();

			for(int i = 0 ; i < 4 ; i++){
				int nr = now.row + dr[i];
				int nc = now.col + dc[i];

				if(inRange(nr, nc) && arr[nr][nc] == '0' &&  (visited[nr][nc][now.level] == 0 || visited[nr][nc][now.level] > now.sum + 1)){
					visited[nr][nc][now.level] = now.sum + 1;
					q.add(new Spot(nr, nc, now.sum + 1, now.level, !now.isDaytime));
				}
				if(inRange(nr, nc) && arr[nr][nc] == '1' && now.level < K && (visited[nr][nc][now.level+1] == 0 || visited[nr][nc][now.level+1] > now.sum + 1)){
					if(now.isDaytime){
						visited[nr][nc][now.level+1] = now.sum + 1;
						q.add(new Spot(nr, nc, now.sum + 1, now.level + 1, !now.isDaytime));
					}else{
						visited[nr][nc][now.level+1] = now.sum + 2;
						q.add(new Spot(nr, nc, now.sum + 2, now.level + 1, now.isDaytime));
					}
				}
			}
		}

		int MIN = Integer.MAX_VALUE;
		for(int i = 0 ; i <= K ; i++){
			if(visited[N-1][M-1][i] != 0){
				MIN = Math.min(MIN, visited[N-1][M-1][i]);
			}
		}
		System.out.println(MIN == Integer.MAX_VALUE ? -1 : MIN);
	}

	static boolean inRange(int r, int c){
		if(r >= 0 && r < N && c >= 0 && c < M){
			return true;
		}
		return false;
	}

	static class Spot{
		int row;
		int col;
		int sum;
		int level;
		boolean isDaytime;

		Spot(int r, int c, int s, int l, boolean i){
			this.row = r;
			this.col = c;
			this.sum = s;
			this.level = l;
			this.isDaytime = i;
		}
	}
}
