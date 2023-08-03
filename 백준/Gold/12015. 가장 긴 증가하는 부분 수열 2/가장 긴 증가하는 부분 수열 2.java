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
        }

        int idx = 0;
        int before = 0;
        for(int i = 0 ; i < N ; i++){
            if(arr[i] > dp[before]){
                before = idx;
                dp[idx++] = arr[i];
            }else{
                dp[binarySearch(0, idx, arr[i])] = arr[i];
            }
        }
        System.out.println(idx);
    }
    
    static int binarySearch(int start, int end, int target){
        int mid = (end - start) / 2;
        while(true){
            if(start + 1 == end){
                if(target <= dp[start]){
                    return start;
                }
                break;
            }
            if(dp[mid] == target) {
                return mid;
            }

            if(target > dp[mid]){
                start = mid;

                mid += (end - start) / 2;

            }else{
                end = mid;
                mid = start + (end - start) / 2;
            }
        }
        return mid+1;
    }
}
