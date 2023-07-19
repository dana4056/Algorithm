import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] TW = br.readLine().split(" ");
        int T = Integer.parseInt(TW[0]);
        int W = Integer.parseInt(TW[1]);
        int[] arr = new int[T+1];
        int[][] dp = new int[W+2][T+1];

        for(int i = 1 ; i <= T ; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(i == 1 && arr[i] == 1){
                dp[1][1] = 1;
            }
        }

        for(int i = 1 ; i <= W+1 ; i++){
            for(int j = 1 ; j <= T ; j++){
                int same =(i % 2 == arr[j] % 2) ? 1 : 0;
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i][j-1]) + same;
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
            }
        }
        System.out.println(dp[W+1][T]);

    }
}
