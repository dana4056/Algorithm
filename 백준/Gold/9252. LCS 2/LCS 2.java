import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        int len1 = str1.length, len2 = str2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int i = 1 ; i <= len1 ; i++){
            for(int j = 1 ; j <= len2 ; j++){
                if(str1[i-1] == str2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int r = len1, c = len2;
        while(dp[r][c] > 0){
            int now = dp[r][c];
            if(now == dp[r-1][c]){
                r -= 1;
                continue;
            }
            if(now == dp[r][c-1]){
                c -= 1;
                continue;
            }

            sb.append(str1[r-1]);
            r -= 1;
            c -= 1;
        }

        sb.reverse();
        sb.insert(0, dp[len1][len2]+"\n");
        System.out.println(sb);
    }
}
