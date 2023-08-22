import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[][] dp = new int[N+1][M+1];
        char[][] arr = new char[N][M];
        for(int i = 0 ; i < N ; i++){
            arr[i] = br.readLine().toCharArray();
        }

        int MAX = 0;
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= M ; j++){
                if(arr[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
                    MAX = Math.max(MAX, dp[i][j]);
                }
            }
        }
        System.out.println(MAX*MAX);
    }
}
