import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+2];
        int[][] dp = new int[3][N+2];

        for(int i = 2 ; i <= N+1 ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }


        for(int i = 2 ; i<= N+1 ; i++){
            dp[1][i] = Math.max(dp[1][i-2], dp[2][i-2]) + arr[i];
            dp[2][i] = dp[1][i-1] + arr[i];
        }

        System.out.println(Math.max(dp[1][N+1], dp[2][N+1]));

    }
}
