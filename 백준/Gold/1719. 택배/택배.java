import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int INF = 100000000;

        int[][] dp = new int[N][N];
        int[][] dp2 = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            Arrays.fill(dp[i], INF);
        }

        for(int i = 0 ; i < M ; i++){
            String[] abc = br.readLine().split(" ");
            int a = Integer.parseInt(abc[0]) - 1;
            int b = Integer.parseInt(abc[1]) - 1;
            int cost = Integer.parseInt(abc[2]);

            dp[a][b] = cost;
            dp[b][a] = cost;
            dp2[a][b] = b+1;
            dp2[b][a] = a+1;
        }

        for(int m = 0 ; m < N ; m++){
            for(int s = 0 ; s < N ; s++){
                if(s == m) continue;
                for(int e = 0 ; e < N ; e++){
                    if(e == s || e == m) continue;
                    if(dp[s][m] + dp[m][e] < dp[s][e]){
                        dp[s][e] = dp[s][m] + dp[m][e];
                        dp2[s][e] = dp2[s][m];
                    }
                }
            }
        }

        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < N ; j++){
                if(i == j){
                    System.out.print("- ");
                }else{
                    System.out.print(dp2[i][j]+" ");
                }
            }
            System.out.println();
        }

    }
}
