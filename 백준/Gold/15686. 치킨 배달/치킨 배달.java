import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,R,H;
	static int[][] numbers;
	static int[][] house;
	static int[][] picks;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(in.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n+1][n+1];
        numbers = new int[13][2];
        house = new int[2*n][2];
        
        // 마을 입력
        for(int i = 1 ; i<=n ;i++) {
        	String[] input1 = in.readLine().split(" ");
        	for(int j = 1; j<= n ; j++) {
        		arr[i][j] = Integer.parseInt(input1[j-1]);
        		if(arr[i][j] == 1) {
        			house[H][0] = i;
        			house[H][1] = j;
        			H += 1;
        		}
        		if(arr[i][j] == 2) { 
        			//치킨집 좌표 등록
        			numbers[N][0] = i;
        			numbers[N][1] = j;
        			N += 1; //치킨집 개수 증가
        		}
        	}
        }
        
        picks = new int[R][2];
        comb(0,0);
        
        System.out.println(result);
	}
	
	static void comb(int cnt, int start) {
		if(cnt == R) {
			int chickenDis = calDistance();
			if(chickenDis < result) result = chickenDis;
			return;
		}
		for(int i = start ; i< N ; i++) {
			picks[cnt] = numbers[i]; 
			comb(cnt+1,i+1);
		}
	}
	
	static int calDistance() {
		int totalDis = 0;
		int minDis;
		int dis = 0;
		for(int h = 0 ; h < H; h++) {
			minDis = Integer.MAX_VALUE;
			for(int c = 0 ; c < R; c++ ) {
				dis = Math.abs(house[h][0] - picks[c][0])+ Math.abs(house[h][1] - picks[c][1]);
				if(dis < minDis) minDis = dis;
			}
			totalDis += minDis;
		}
		return totalDis;
	}
}
