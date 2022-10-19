import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//MainB1987  알파벳
public class Main {

	static boolean[] isSelect = new boolean[26];
	static char[][] arr;
	static int[][] visited;
	static int MAX = -1, r, c, CNT;
	static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	static int[] dc = {0, 0, -1, 1}; // 상하좌우
	static char[] temp;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new char[r][c];
		visited = new int[r][c];
		temp = new char[r*c];
		
		for(int i = 0 ; i < r ; i++) {
			arr[i] = in.readLine().toCharArray();
		}
		search(0, 0, 0);
		System.out.println(MAX<=CNT?CNT+1:MAX);
	}
	
	
	private static void search(int row, int col, int cnt) {
		if(visited[row][col] == 0 && isSelect[arr[row][col]-'A']) {
			if(cnt > MAX) MAX = cnt;
			return;
		}
		CNT = cnt;
		//선택
		isSelect[arr[row][col]-'A'] = true;
		visited[row][col] = 1;
		temp[cnt] = arr[row][col];
				
		//다음 선택 (상하좌우)
		for(int i = 0 ; i < 4 ; i++) {
			if(row+dr[i]<0 || row+dr[i]>= r || col+dc[i] < 0 || col+dc[i] >= c){
				continue;
			}
			if(visited[row+dr[i]][col+dc[i]] == 0) {
				search(row+dr[i], col+dc[i], cnt+1);
			}	
		}
		visited[row][col] = 0;
		isSelect[arr[row][col]-'A'] = false;
	}
}
