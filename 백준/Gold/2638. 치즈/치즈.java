import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, M, total;
	static int[][] arr;
	static int[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		arr = new int[N][M];
		visited = new int[N][M];

		for(int i = 0 ; i < N ; i++){
			String[] line = br.readLine().split(" ");
			for(int j = 0 ; j < M ; j++){
				arr[i][j] = Integer.parseInt(line[j]);
				if(arr[i][j] == 1) total++;
			}
		}

		int cnt = 0;
		while(total > 0){
			int deleted = 0;
			insertQueue();

			while(!q.isEmpty()){
				int[] now = q.poll();

				for(int i = 0 ; i < 4 ; i++){
					int nr = now[0] + dr[i];
					int nc = now[1] + dc[i];

					if(inRange(nr, nc)){
						if(arr[nr][nc] == 0 && visited[nr][nc] == 0){
							visited[nr][nc] = 1;
							q.add(new int[]{nr, nc});
						}

						else if(arr[nr][nc] == 1 && visited[nr][nc] < 2){
							visited[nr][nc] += 1;
							if(visited[nr][nc] == 2){
								arr[nr][nc] = 0;
								deleted++;
							}
						}
					}
				}
			}
			initVisited();
			total -= deleted;
			cnt++;
		}
		System.out.println(cnt);
	}

	private static void insertQueue() {
		boolean searchStart = false;
		for(int i = 0 ; i < N ; i++){
			for(int j = 0 ; j < M ; j++){
				if(arr[i][j] == 0){
					q.add(new int[]{i, j});
					visited[i][j] = 1;
					searchStart = true;
					break;
				}
			}
			if(searchStart) break;
		}
	}

	private static void initVisited() {
		for(int i = 0 ; i < N ; i++){
			Arrays.fill(visited[i], 0);
		}
	}

	static boolean inRange(int r , int c){
		if(r >= 0 && r < N && c >= 0 && c < M) return true;
		return false;
	}
}
