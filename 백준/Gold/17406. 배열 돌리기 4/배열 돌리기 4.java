import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int ans = Integer.MAX_VALUE - 1000;
	static boolean[] visited;
	static int[] nums;
	static int[][] rcs;
	static int[][] origin;
	static int[][] arr1;
	static int[][] arr2;
	static int[] dr = {0, 1, 0, -1};	//우,하,좌,상
	static int[] dc = {1, 0, -1, 0};	//우,하,좌,상
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[K];
		nums = new int[K];

		origin = new int[N+1][M+1];
		arr1 = new int[N+1][M+1];
		arr2 = new int[N+1][M+1];

		for(int i = 1 ; i <= N ; i ++){
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= M ; j++){
				origin[i][j] = Integer.parseInt(st.nextToken());
				arr1[i][j] = origin[i][j];
				arr2[i][j] = origin[i][j];
			}
		}

		rcs = new int[K][3];
		for(int i = 0 ; i < K ; i++){
			st = new StringTokenizer(br.readLine());
			rcs[i][0] = Integer.parseInt(st.nextToken());
			rcs[i][1] = Integer.parseInt(st.nextToken());
			rcs[i][2] = Integer.parseInt(st.nextToken());
		}
		perm(0);
		System.out.print(ans);


	}

	static void perm(int cnt){
		if(cnt == K){
			for(int row = 1; row<=N ; row++){
				for(int col= 1 ; col<= M ; col++){
					arr1[row][col] = origin[row][col];
					arr2[row][col] = origin[row][col];
				}
			}

			for(int i =0 ; i < K ; i ++){
				int r = rcs[nums[i]][0];
				int c = rcs[nums[i]][1];
				int s = rcs[nums[i]][2];
                
				turnArray(r,c,s);

				for(int row = 1; row<=N ; row++){
					for(int col= 1 ; col<= M ; col++){
						arr1[row][col] = arr2[row][col];
					}
				}
			}

			//여기서 배열 값 계산
			int value = calArrayValue(arr2);
			if(value < ans) ans = value;

			return;
		}

		for(int i = 0 ; i < K ; i++){
			if(!visited[i]){
				visited[i] = true;
				nums[cnt] = i;
				perm(cnt+1);
				visited[i] = false;
			}
		}
	}


	// 배열의 값 계산
	static int calArrayValue(int[][] arr){
		int min = Integer.MAX_VALUE - 1000;
		for(int r = 1 ; r <= N ; r++){
			int sum = 0;
			for(int c = 1 ; c <= M ; c++){
				sum += arr[r][c];
			}
			if(sum < min) min = sum;
		}
		return min;
	}

	// 배열 돌리기
	static void turnArray(int r, int c, int s){
		for(int i = 1; i <= s ; i++){
			int dir = 0;
			int nr = r-i;
			int nc = c-i;
			while(true){

				//arr1의 원소를 한칸씩 옮겨 arr2로 넣기
				if(!isRange(nr+dr[dir], nc+dc[dir], r,c,i)){
					dir += 1;	//방향 바꾸기
				}
				arr2[nr+dr[dir]][nc+dc[dir]] = arr1[nr][nc];

				nr += dr[dir];
				nc += dc[dir];

				if(nr == r-i && nc == c-i) break;
			}
		}
	}

	private static boolean isRange(int nr, int nc, int R, int C, int S) {
		if(nr >= R-S && nr <= R+S && nc >= C-S && nc <= C+S) return true;
		else return false;
	}
}
