import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int INF = Integer.MAX_VALUE;
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        int[] route = new int[N+1];

        for(int i = 2 ; i <= N ; i++){
            dp[i] = INF;

            if(i % 3 == 0 && dp[i / 3] + 1 < dp[i]){
                dp[i] = dp[i / 3] + 1;
                route[i] = i / 3;
            }
            if(i % 2 == 0 && dp[i / 2] + 1 < dp[i]){
                dp[i] = dp[i / 2] + 1;
                route[i] = i / 2;
            }

            if(dp[i-1] + 1 < dp[i]){
                dp[i] = dp[i-1] + 1;
                route[i] = i - 1;
            }
        }


        StringBuilder sb = new StringBuilder();
        sb.append(dp[N]).append("\n");

        int now = N;
        while(now != 0){
            sb.append(now).append(" ");
            now = route[now];
        }

        System.out.println(sb);
    }
}
