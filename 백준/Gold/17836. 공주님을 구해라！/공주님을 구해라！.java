import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NMT = br.readLine().split(" ");
		N = Integer.parseInt(NMT[0]);
		M = Integer.parseInt(NMT[1]);
		int T = Integer.parseInt(NMT[2]);
		int time = Integer.MAX_VALUE, gramTime = Integer.MAX_VALUE;
		char[][] arr = new char[N][M];


		for(int i = 0 ; i < N ; i++){
			String line = br.readLine();
			for(int j = 0 ; j < M ; j++){
				arr[i][j] = line.charAt(j*2);
			}
		}

		Queue<Coord> q = new LinkedList<>();
		arr[0][0] = '1';
		q.add(new Coord(0,0,0));

		boolean isGram = false;
		while (!q.isEmpty()){
			Coord now = q.poll();

			if(now.row == N-1 && now.col == M-1){
				time = now.level;
				break;
			}

			for(int i = 0 ; i < 4 ; i++){
				int nr = now.row + dr[i];
				int nc = now.col + dc[i];
				if(inRange(nr, nc) && arr[nr][nc] != '1'){
					if(arr[nr][nc] == '2'){
						// 그램에 도달한 경우
						isGram = true;
						gramTime = (Math.abs(nr - (N-1)) + Math.abs(nc - (M-1))) + (now.level + 1);
					}else{
						q.add(new Coord(nr, nc, now.level+1));
					}
					arr[nr][nc] = '1';
				}
			}
		}

		int ans = Math.min(time, gramTime);
		System.out.println((ans <= T) ? ans : "Fail");
	}

	private static boolean inRange(int r, int c) {
		if(r >= 0 && r < N && c >= 0 && c < M){
			return true;
		}
		return false;
	}

	static class Coord{
		int row;
		int col;
		int level;

		Coord(int r, int c, int l){
			this.row = r;
			this.col = c;
			this.level = l;
		}
	}
}
