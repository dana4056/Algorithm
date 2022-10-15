import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1,1,0,0}; //상하좌우
	static int[] dc = {0,0,-1,1}; //상하좌우
	static int N;
	static int[][] DP, arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = 0; 
		int tc = 0, MIN = Integer.MAX_VALUE - 100;
		
		while(true) {
			N = Integer.parseInt(in.readLine());
			
			if(N == 0) break;
			tc++;
			
			arr = new int[N][N];
			DP = new int[N][N];
			Queue<Spot> q = new LinkedList<Spot>();
			
			for(int i = 0 ; i < N ; i++) {
				Arrays.fill(DP[i], 1000000000);
			}
			
			//배열 입력받기
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0 ; j < N ;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			DP[0][0] = arr[0][0];
			q.add(new Spot(0,0));
			
			while(!q.isEmpty()) {
				Spot now = q.poll();
				
				int nr=0, nc=0;
				for(int i = 0 ; i < 4 ; i++) {
					nr = now.r + dr[i];
					nc = now.c + dc[i];
					if(nr>=0 && nr<N && nc>=0 && nc < N) {
						if(DP[now.r][now.c] + arr[nr][nc] < DP[nr][nc]) {
							q.add(new Spot(nr,nc));
							DP[nr][nc] = DP[now.r][now.c] + arr[nr][nc];
						}
					}
				}
			}
			
			sb.append("Problem ").append(tc).append(": ").append(DP[N-1][N-1]).append("\n");
		}
		System.out.println(sb);
		
	}
}

class Spot{
	int r;
	int c;
	
	public Spot(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "r:"+this.r+" c:"+this.c+"|";
	}
}
