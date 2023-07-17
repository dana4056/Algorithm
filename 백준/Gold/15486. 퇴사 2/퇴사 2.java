import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+2];
        
        for(int i = 1 ; i <= N ; i++){
            String[] TP = br.readLine().split(" ");
            int time = Integer.parseInt(TP[0]);
            int pay = Integer.parseInt(TP[1]);

            dp[i] = Math.max(dp[i], dp[i-1]);
            if(i+time <= N+1){
                dp[i+time] = Math.max(dp[i+time], dp[i] + pay);
            }
        }
        System.out.println(Math.max(dp[N], dp[N+1]));
    }
}
