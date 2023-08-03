import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        dp = new int[N];

        String[] line = br.readLine().split(" ");
        for (int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(line[i]);
            dp[i] = Integer.MIN_VALUE;
        }

        int idx = 0;
        int before = 0;
        for(int i = 0 ; i < N ; i++){
            if(arr[i] > dp[before]){
                before = idx;
                dp[idx++] = arr[i];
            }else{
                int sidx = Arrays.binarySearch(dp,0, idx, arr[i]);
                dp[sidx < 0 ? (sidx + 1) * -1 : sidx] = arr[i];
            }
        }
        System.out.println(idx);
    }
}
