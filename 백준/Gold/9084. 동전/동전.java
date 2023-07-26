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
            int[] dp = new int[target+1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <=target; j++) {
                    if (j - arr[i] > 0) {
                        dp[j] = dp[j] + dp[j-arr[i]];
                    } else if (j - arr[i] == 0) {
                        dp[j]++;
                    }
                }
            }
            sb.append(dp[target] + "\n");
        }
        System.out.print(sb);
    }
}
