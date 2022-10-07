import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] str1 = in.readLine().split(" ");
		int N = Integer.parseInt(str1[0]);
		int M = Integer.parseInt(str1[1]);
		
		//숫자 배열 생성
		int[][] nums = new int[N+1][N+1];
		int inputNum;
		
		for(int i = 1 ;i < N+1 ;i++) {
			String[] str2 = in.readLine().split(" ");
			for(int j = 1 ; j < N+1 ;j++) {
				inputNum = Integer.parseInt(str2[j-1]);
				nums[i][j] = inputNum + nums[i-1][j]+nums[i][j-1]-nums[i-1][j-1];
				
			}
		}
		
		int sr = 0, sc = 0, er = 0, ec = 0;
		for(int i = 0 ; i < M ; i++) {
			String[] str3 = in.readLine().split(" ");
			sr = Integer.parseInt(str3[0]);
			sc = Integer.parseInt(str3[1]);
			er = Integer.parseInt(str3[2]);
			ec = Integer.parseInt(str3[3]);
			sb.append(nums[er][ec]-nums[er][sc-1]-nums[sr-1][ec]+nums[sr-1][sc-1]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
