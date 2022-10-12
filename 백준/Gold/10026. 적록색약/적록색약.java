import java.util.Scanner;

public class Main {

	static char[][] arr;
	static int[] dr = {-1,1,0,0}; //상하좌우 
	static int[] dc = {0,0,-1,1}; //상하좌우 
	static int N;
	static boolean[][] visitO, visitX;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		arr = new char[N][N];
		visitO = new boolean[N][N];
		visitX = new boolean[N][N];
		
		sc.nextLine();
		for(int i = 0 ; i < N ; i++ ) {
			char[] tmp = sc.nextLine().toCharArray();
			for(int j = 0 ; j < N ; j++) {
				arr[i][j] = tmp[j];
			}
		}
		int cntX = 0, cntO = 0;
		for(int r = 0 ; r < N; r++) {
			for(int c = 0 ; c < N ; c++) {
				if(visitX[r][c]) continue;
				DFS(r, c, false);
				cntX++;
			}
		}
		for(int r = 0 ; r < N; r++) {
			for(int c = 0 ; c < N ; c++) {
				if(visitO[r][c]) continue;
				DFS(r, c, true);
				cntO++;
			}
		}
		System.out.printf("%d %d", cntX, cntO);
	}
	
	private static void DFS(int r, int c, boolean blindness) {
		char color = arr[r][c];
		if(!blindness) {
			visitX[r][c] = true;
		}else {
			visitO[r][c] = true;
		}
		
		int row=0,col=0;
		for(int i = 0 ; i < 4 ; i++) {
			row=r+dr[i];
			col=c+dc[i];
			if(isRange(row, col)){
				if(!blindness && arr[row][col] == color && !visitX[row][col]) {
					DFS(row,col, false);
				}else if(blindness && !visitO[row][col]) {
					if(arr[row][col] == color || (color=='R' && arr[row][col] != 'B') || (color=='G' && arr[row][col] != 'B')) {
						DFS(row,col, true);
					}
				}
			}
		}
	}

	static boolean isRange(int r, int c) {
		if(r>=0 && r< N && c >= 0 && c<N) {
			return true;
		}
		return false;
	}
}