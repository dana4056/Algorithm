import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        int[] dp = new int[K+1];
        int[] won = new int[N];

        Arrays.fill(dp, INF);

        for(int i = 0 ; i < N ;i++){
            won[i] = Integer.parseInt(br.readLine());
        }

        for(int k = 1 ; k <= K ; k++){
            for(int i = 0  ; i < N ; i++){
                if(k-won[i] > 0 && dp[k-won[i]] != INF){
                    dp[k] = Math.min(dp[k], dp[k-won[i]] + 1);
                }else if(k-won[i] == 0){
                    dp[k] = 1;
                }
            }
        }

        System.out.println(dp[K] == INF ? -1 : dp[K]);

    }
}
