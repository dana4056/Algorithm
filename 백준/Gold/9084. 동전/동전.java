import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0 ; tc < T ; tc++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N+1];

            String[] line = br.readLine().split(" ");
            for(int n = 1 ; n <= N ; n++){
                arr[n] = Integer.parseInt(line[n-1]);
            }

            int target = Integer.parseInt(br.readLine());
            int[][] dp = new int[N+1][target+1];

            for(int i = 1 ; i <= N ; i++){
                dp[i][0] = 1;
                for(int j = 1 ; j <= target ; j++){
                    if(j-arr[i] >= 0){
                        dp[i][j] = dp[i-1][j] + dp[i][j-arr[i]];
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }

            sb.append(dp[N][target]).append("\n");
        }
        System.out.print(sb);
    }
}
