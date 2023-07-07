import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        int[][] dp = new int[N+1][K+1];
        int[] coins = new int[N];

        for(int i = 0 ; i < N ; i++){
            coins[i] = Integer.parseInt(br.readLine());
            dp[i+1][0] = 1;
        }

        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= K ;j++){
                dp[i][j] += dp[i-1][j];
                if(j-coins[i-1] >= 0){
                    dp[i][j] += dp[i][j-coins[i-1]];
                }
            }
        }

        System.out.println(dp[N][K]);


    }
}
