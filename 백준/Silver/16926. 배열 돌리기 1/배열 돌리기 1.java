import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//배열 돌리기 1
public class Main {
	
	static int[] drow = {1, 0, -1, 0};  //하, 우, 상, 좌 (반시계)
	static int[] dcol = {0, 1, 0, -1};  //하, 우, 상, 좌 (반시계)
	static int[][] origin;
	static int[][] update;
	static int N = 0, M = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input1 = in.readLine().split(" ");
		N = Integer.parseInt(input1[0]);
		M = Integer.parseInt(input1[1]);
		int R = Integer.parseInt(input1[2]);
		
		origin = new int[N][M];
		update = new int[N][M];
		
		for(int i = 0; i < N ;i++) {
			String[] input2 = in.readLine().split(" ");
			for(int j = 0 ; j< M; j++) {
				origin[i][j] = Integer.parseInt(input2[j]);
				update[i][j] = origin[i][j];
			}
		}

		
		for(int i = 0 ; i < R ; i++) {
			rotate(0,0);
			//origin 업데이트
			for(int r = 0; r < N ;r++) {
				for(int c = 0 ; c< M; c++) {
					origin[r][c] = update[r][c];
				}
			}

		}
		
		//출력
		for(int r = 0; r < N ;r++) {
			for(int c = 0 ; c< M; c++) {
				System.out.print(origin[r][c]+" ");;
			}
			System.out.println();
		}
	}
	
	static void rotate(int s_row, int s_col) {

		if(s_row >= (N/2) || s_col >= (M/2)) {
//			update[s_row][s_col] = origin[s_row][s_col];
			return;
		}
		int row = s_row, col = s_col;
		int e_row = (N-1)-s_row;
		int e_col = (M-1)-s_col;
		int i = 0;
		
		do {

			if(row + drow[i] < s_row || row + drow[i] > e_row || col + dcol[i] < s_col || col + dcol[i] > e_col) {
				i++;
			}
			update[row + drow[i]][col + dcol[i]] = origin[row][col];
			
			row += drow[i];
			col += dcol[i];
			
		}while(!(row == s_row && col == s_col) && i < 4);
			
		rotate(s_row+1,s_row+1);
	}
}

