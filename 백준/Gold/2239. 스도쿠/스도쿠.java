import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] idx_arr = new int[9][9];
	static int[] arr = new int[81];
	static int K;
	static boolean find;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int idx = 0;
		for(int i = 0 ; i < 9 ; i++){
			String line = br.readLine();
			for(int j = 0 ; j < 9 ; j++){
				arr[(i*9)+j] = line.charAt(j) - '0';
				if(arr[(i*9)+j] == 0) K++;
				idx_arr[i][j] = idx++;
			}
		}
		dfs(0, 0);
		System.out.print(sb);
	}

	private static void dfs(int idx, int cnt) {
		if(find) return;
		if(cnt == K){
			for(int i = 0 ;i < 9 ; i++){
				for(int j = 0 ; j < 9 ; j++){
					sb.append(arr[(i*9)+j]);
				}
				sb.append("\n");
			}
			find = true;
			return;
		}

		for(int i = idx ; i < 81 ; i++){
			if(arr[i] == 0) {
				for(int n = 1 ; n <= 9 ; n++){
					if(checkNum(n, i)){
						arr[i] = n;
						dfs(i+1, cnt+1);
						arr[i] = 0;
					}
				}
				break;
			}
		}
	}

	private static boolean checkNum(int num, int idx) {
		int r = idx / 9;
		int c = idx % 9;

		//세로체크
		for(int i = 0 ; i < 9 ; i++){
			if(arr[idx_arr[i][c]] == num) {
				return false;
			}

			if(arr[idx_arr[r][i]] == num) {
				return false;
			}
		}

		//3*3체크
		int sr = r/3;
		int sc = c/3;

		for(int i = 0 ; i < 3 ; i++){
			for(int j = 0 ; j < 3 ; j++){
				if(arr[idx_arr[(sr*3)+i][(sc*3)+j]] == num) {
					return false;
				}
			}
		}
		return true;
	}
}
