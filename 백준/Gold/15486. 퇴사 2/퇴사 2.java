import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+2];
        int[] time = new int[N+1];
        int[] pay = new int[N+1];

        for(int i = 1 ; i <= N ; i++ ){
            String[] TP = br.readLine().split(" ");
            time[i] = Integer.parseInt(TP[0]);
            pay[i] = Integer.parseInt(TP[1]);
        }

        for(int i = 1 ; i <= N ; i++){
            dp[i] = Math.max(dp[i], dp[i-1]);
            if(i+time[i] <= N+1){
                dp[i+time[i]] = Math.max(dp[i+time[i]], dp[i] + pay[i]);
            }
        }
        System.out.println(Math.max(dp[N], dp[N+1]));
    }
}
