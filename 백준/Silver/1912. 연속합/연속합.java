import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        int MAX = Integer.MIN_VALUE;

        String[] nums = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++){
            int num = Integer.parseInt(nums[i]);
            if(i == 0){
                dp[i] = num;
            }else{
                if(0 < dp[i-1] + num){
                    dp[i] = Math.max(dp[i-1] + num, num);
                }else{
                    dp[i] = num;
                }
            }
            MAX = Math.max(MAX, dp[i]);
        }
        System.out.println(MAX);
    }
}
