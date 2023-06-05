import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dr = {-1,1,0,0};	// 상하좌우
	static int[] dc = {0,0,-1,1};	// 상하좌우
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NMK = br.readLine().split(" ");
		N = Integer.parseInt(NMK[0]);
		M = Integer.parseInt(NMK[1]);
		int K = Integer.parseInt(NMK[2]);
		char[][] arr = new char[N][M];
		int[][][] visited = new int[N][M][K+1];

		for(int i = 0 ; i < N ; i++){
			arr[i] = br.readLine().toCharArray();
		}

		Queue<Coord> q = new LinkedList<>();
		visited[0][0][0] = 1;
		q.add(new Coord(0,0,0));

		while(!q.isEmpty()){
			Coord now = q.poll();
			int r = now.row;
			int c = now.col;
			int w = now.wall;

			for(int i = 0 ; i < 4 ; i++){
				int nr = r + dr[i];
				int nc = c + dc[i];

				if(inRange(nr, nc) && arr[nr][nc] == '0' && visited[nr][nc][w] == 0){
					visited[nr][nc][w] = visited[r][c][w] + 1;
					q.add(new Coord(nr, nc, w));
				}
				if(inRange(nr, nc) && arr[nr][nc] == '1' && w < K && visited[nr][nc][w+1] == 0){
					visited[nr][nc][w+1] = visited[r][c][w] + 1;
					q.add(new Coord(nr, nc, w+1));
				}
			}
		}

		int MIN = Integer.MAX_VALUE;
		for(int i = 0; i <= K ; i++){
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

	static class Coord{
		int row;
		int col;
		int wall;

		Coord(int r, int c, int w){
			this.row = r;
			this.col = c;
			this.wall = w;
		}
	}
}
