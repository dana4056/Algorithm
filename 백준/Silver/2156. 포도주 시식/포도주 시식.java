import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        for(int i = 1 ; i <= N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(N == 1){
            System.out.println(arr[1]);
        }else{
            int[][] dp = new int[3][N+1];
            dp[0][0] = arr[0];
            dp[0][1] = arr[1];


            for(int i = 1 ; i <= N ; i++){
                dp[0][i] = dp[2][i-1] + arr[i];
                dp[1][i] = dp[0][i-1] + arr[i];
                dp[2][i] = Math.max(dp[1][i-1],Math.max(dp[0][i-1],dp[2][i-1]));
            }
            System.out.println(Math.max(dp[1][N],Math.max(dp[0][N],dp[2][N])));
        }

    }



}
