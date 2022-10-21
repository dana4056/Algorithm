import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int N; //나무의 개수
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		
		for(int tc = 1 ; tc <= TC ; tc++) {
			
			N = Integer.parseInt(br.readLine());  // 나무 개수
			
			int[] heights = new int[N];
			int[] remainder = new int[N];
			int[][] even_odd = new int[2][N];
			
			// 각 나무 키 입력 받기 & 가장 큰 나무 키(MAX) 구하기
			int MAX = -999;
			String[] temp = br.readLine().split(" "); // 나무들의 키
			for(int i = 0 ; i < N ; i++) {
				heights[i] = Integer.parseInt(temp[i]);
				if(heights[i] > MAX) {
					MAX = heights[i];			
				}
			}
			
			// 각 나무별로 MAX와의 차이 구하고 2로 묶기
			int Esum = 0, Osum = 0;
			for(int i = 0 ; i < N ; i++) {
				remainder[i] = MAX - heights[i];    //MAX와 차이
				
				even_odd[0][i] = remainder[i] / 2;	//2로 묶었을 떄 
				even_odd[1][i] = remainder[i] % 2;	//나머지	
				
				Esum += even_odd[0][i];
				Osum += even_odd[1][i];
			}
			
			
			// 총 짝수일, 홀수일의 차이 줄이기(전체 단위로 봤을때 2로 묶은게 더 많으면 1로 풀어줘서 차이 줄이기)
			int gap = Math.abs(Esum - Osum);
			while(true) {
				Esum -= 1;
				Osum += 2;
				if(Math.abs(Esum - Osum) >= gap) {
					Esum += 1;
					Osum -= 2;
					break;
				}
				gap = Math.abs(Esum - Osum);
			}
			
			// 몇일 걸리는지 계산
			int days = 1;
			while(Esum+Osum != 0) {
				
				if(Esum != 0 && days % 2 == 0) { //짝수날
					Esum -= 1;
				}
				if(Osum != 0 && days % 2 == 1) { //홀수날
					Osum -= 1;
				}
				days += 1;
			}
			sb.append("#").append(tc).append(" ").append(days-1).append("\n");
		}
		System.out.println(sb.toString());
	}
}