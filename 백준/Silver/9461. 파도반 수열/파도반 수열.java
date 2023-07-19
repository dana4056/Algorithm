import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[] dp = new long[100];

        for(int i = 0 ; i<5 ; i++){
            if(i < 3) dp[i] = 1;
            else dp[i] = 2;
        }

        for(int i = 5 ; i < 100 ; i++){
            dp[i] = dp[i-1] + dp[i-5];
        }

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0 ; tc < T ; tc++ ){
            int N = Integer.parseInt(br.readLine()) - 1;
            sb.append(dp[N]).append("\n");
        }

        System.out.print(sb);
    }
}
