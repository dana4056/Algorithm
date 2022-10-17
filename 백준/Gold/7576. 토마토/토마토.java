import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	static int[][] box;
	static int[] dr = {-1,1,0,0}; //상하좌우 
	static int[] dc = {0,0,-1,1}; //상하좌우 
	static int R, C;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		box = new int[R][C];
		
		int nope = 0;  //덜익은 토마토 개수
		Queue<int[]> q = new LinkedList<int[]>();
		
		int h = 0;
		// 토마토 상자 입력
		for(int r = 0 ; r < R ; r++) {
			st = new StringTokenizer(in.readLine());
			for(int c = 0 ; c < C ; c++) {
				box[r][c] = Integer.parseInt(st.nextToken());
				if(box[r][c] == 0) {
					nope++;  					// 덜익은 토마토 카운팅
				}
				else if(box[r][c] == 1) {
					q.add(new int[] {r,c,h});   // 익은 토마토 리스트에 추가 
				}
			}
		}
		
		while(!q.isEmpty()) {
			
			int[] t = q.poll(); //토마토 꺼내기
			int r, c;
			h = t[2];
			
			//사방 탐색
			for(int i = 0 ; i < 4 ; i++) {
				r = t[0]+dr[i];
				c = t[1]+dc[i];
				
				//다음 토마토
				if(inRange(r, c)) {
					q.add(new int[] {r,c,h+1});
					box[r][c] = 1;
					nope -= 1;
				}
			}
			
		}
		
		if(nope > 0) {
			System.out.println(-1);
		}else {
			System.out.println(h);
		}
		
	}

	
	//배열 범위 확인
	private static boolean inRange(int r, int c) {
		if(r>= 0 && r < R && c >= 0 && c < C && box[r][c] == 0) {
			return true;
		}
		return false;
	}

}