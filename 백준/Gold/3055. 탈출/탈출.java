import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static char[][] arr;
	static int row, col;
	static int[] dr = {-1,1,0,0}; //상하좌우 
	static int[] dc = {0,0,-1,1}; //상하좌우 
	static Queue<Water> water = new LinkedList<Water>();
	static Queue<int[]> q = new LinkedList<int[]>();  //r,c,h
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		arr = new char[row][col];
		
		int DochiR = 0, DochiC = 0;
		// 문자 입력받기
		for(int r = 0 ; r < row ; r++) {
			char[] tmp = in.readLine().toCharArray();
			for(int c = 0 ; c < col ; c++) {
				arr[r][c] = tmp[c];
				if(arr[r][c] == 'S') {  		 // 도치 위치 파악
					DochiR = r;
					DochiC = c;
				}
				if(arr[r][c] == '*') {
					water.add(new Water(r, c));  // 물 위치 파악(리스트로)
				}
			}
		}
		
		//다음 갈 곳 추가
		int height = 0, N = 0;
		int[] now = {DochiR, DochiC, 0};
		q.add(now);
		
		N = water.size();
		for (int i = 0; i < N; i++) {
			flood(water.poll());	
		}
		
		int nr = 0, nc = 0;
		boolean[][] visit = new boolean[row][col]; 
		while(!q.isEmpty()){
			int[] next = new int[3];
			
			now = q.poll();
			if(height < now[2]) {
				// 물 퍼져나간다~
				height = now[2];
				N = water.size();
				for (int i = 0; i < N; i++) {
					flood(water.poll());	
				}
			}
			//다음 갈 곳 추가
			for(int i = 0 ; i < 4 ; i++) {
				nr = now[0]+dr[i];
				nc = now[1]+dc[i];
				
				if(nr>=0 && nr <row && nc >=0 && nc<col && !visit[nr][nc]) { //범위 안에서
					
					if(arr[nr][nc]=='.' || arr[nr][nc]=='D') {  //갈 수 있는 곳이면
						
						if(arr[nr][nc] == 'D') {
							System.out.println(now[2] + 1);
							return;
						}
						
						next[0] = nr; next[1] = nc; next[2] = now[2]+1;
						q.add(new int[] {nr,nc,now[2]+1});
						visit[nr][nc] = true;
					}
				}
			}
		}
		System.out.println("KAKTUS");
					
	}

	private static void flood(Water w) {
		int r=0, c=0;
		
		for(int i = 0 ; i < 4 ; i++) {
			
			r = w.R + dr[i];
			c = w.C + dc[i];
			
			if(r>=0 && r<row && c >=0 && c<col) {
				if(arr[r][c] != 'X' && arr[r][c] != 'D' && arr[r][c] != '*') {
					water.add(new Water(r,c));
					arr[r][c] = '*';
				}
			}
		}
	}

}

class Water{
	int R;
	int C;
	
	Water(int R, int C){
		this.R = R;
		this.C = C;
	}
}