import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    static int MINF = Integer.MIN_VALUE;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        dp = new int[N+1];
        int[] route = new int[N+1];

        String[] line = br.readLine().split(" ");
        dp[0] = MINF;
        for(int i = 1 ; i <= N ; i++){
            arr[i] = Integer.parseInt(line[i-1]);
            dp[i] = MINF;
        }

        int idx = 1;
        for(int i = 1 ; i <= N ; i++){
            if(arr[i] > dp[idx-1]){
                route[i] = idx;
                dp[idx++] = arr[i];
            }else{
                int sidx = binarySearch(1, idx, arr[i]);
                dp[sidx] = arr[i];
                route[i] = sidx;
            }
        }

        sb.append(idx - 1).append("\n");
        Stack<Integer> st = new Stack<>();
        int ridx = idx - 1;
        for(int i = N ; i > 0 ; i--){
            if(route[i] == ridx){
                ridx--;
                st.add(arr[i]);
            }
        }

        while(!st.isEmpty()){
            sb.append(st.pop()).append(" ");
        }

        System.out.print(sb);
    }
    
    static public int binarySearch(int start, int end, int target){
        int mid = 0;
        while(true){
            mid = start + (end - start) / 2;

            if(start == mid){
                if(target == dp[mid]){
                    return mid;
                }else if( target > dp[mid]){
                    return mid + 1;
                }
                break;
            }
            if(start == dp[mid]){
                return mid;
            }else if(target > dp[mid]){
                start = mid;
            }else{
                end = mid;
            }
        }

        return mid;
    }
}
