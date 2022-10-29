import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long[][] dp = new long[10][N];
		
		int br=0, bc=0, ar=0, ac=0;
		long ans = 0;
		int mod = 1000000000;
        
		for(int c = 0 ; c < N ; c++) {
			for(int r = 0 ; r< 10 ; r++) {
				if(c == 0) { 
                    // 첫번째 자리일때 초기화 (1~9만 가능)
					if(r != 0) dp[r][c] = 1;
				}
				else {
					br = r - 1;	bc = c - 1;  // 1 작은 수 좌표
					ar = r + 1; ac = c - 1;  // 1 큰 수 좌표
                    
                    // 값 누적
					if(inRange(br, bc)) {
						dp[r][c] += (dp[br][bc] % mod);
					}
					if(inRange(ar, ac)) {
						dp[r][c] += (dp[ar][bc] % mod);
					}
				}
				
                // N번째 자리 수일때 누적 구하기
				if(c == N-1) {
					ans += dp[r][c];
				}
			}
		}
		
		System.out.println(ans % mod);
	}

	private static boolean inRange(int row, int col) {
		if(row >= 0 && row <= 9) return true;
		return false;
	}
}