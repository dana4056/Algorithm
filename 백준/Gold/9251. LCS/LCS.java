import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();

		int[][] DP = new int[str2.length()+1][str1.length()+1];

		for(int r = 1 ; r <= str2.length() ; r++){
			for(int c = 1 ; c <= str1.length() ; c++){
				int d = str2.charAt(r - 1) == str1.charAt(c - 1) ? 1 : 0;
				DP[r][c] = Math.max(Math.max(DP[r-1][c] , DP[r][c-1]), DP[r-1][c-1] + d) ;
			}
		}
		System.out.println(DP[str2.length()][str1.length()]);
	}
}
