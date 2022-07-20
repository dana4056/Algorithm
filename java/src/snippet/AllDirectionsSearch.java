package day03.test;
//팔방탐색, 사방탐색
public class Test01 {
	static String[][] arr = {
			{"좌상","상","우상"},
			{"좌","#","우"},
			{"좌하","하","우하"}				
	};
	
	public static void main(String[] args) {
		int row = 1, col = 1;
		
		// arr[row][col];   	  //기준 #  
		// arr[row-1][col];     //상
		// arr[row+1][col];     //하
		// arr[row][col-1];     //좌
		// arr[row][col+1];     //우
		// arr[row-1][col+1];   //우상
		// arr[row+1][col-1];   //좌하
		// arr[row-1][col-1];   //좌상
		// arr[row+1][col+1];   //우하
		

		// 팔방탐색
		int[] drow = {-1,1,0,0,-1,1,-1,1}; //행이동정보
		int[] dcol = {0,0,-1,1,1,-1,-1,1}; //컬럼이동정보
		// 사방탐색(상, 하, 좌, 우)
		// int[] drow = {-1,1,0,0};   //행이동정보 
		// int[] dcol = {0,0,-1,1};   //컬럼이동정보
		
	
		for(int i = 0;i<drow.length;i++) {
			int r = row + drow[i];
			int c = col + dcol[i];
			
			if(r>=0 && c>=0 && r<arr.length &&c<arr[0].length) {
				System.out.println(arr[r][c]);
			}		
		}
	}
}
