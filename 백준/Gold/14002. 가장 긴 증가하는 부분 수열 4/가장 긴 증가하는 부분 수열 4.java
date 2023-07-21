import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        int[] route = new int[N+1];


        String[] line = br.readLine().split(" ");
        for(int i = 1 ; i <= N ; i++){
            arr[i] = Integer.parseInt(line[i-1]);
        }

        int totalMax = 0, end = 0;
        for(int i = 1 ; i <= N ; i++){
            int max = 0;
            int idx = 0;
            for(int j = 1 ; j < i ; j++){
                if(arr[j] < arr[i]){
                    if(dp[j] > max){
                        max = dp[j];
                        idx = j;
                    }
                }
            }
            dp[i] = max + 1;
            route[i] = idx;
            if(totalMax < dp[i]){
                totalMax = dp[i];
                end = i;
            }
        }
        sb.append(totalMax).append("\n");
        Stack<Integer> st = new Stack<>();

        while(end > 0){
            st.add(arr[end]);
            end = route[end];
        }

        while(!st.isEmpty()){
            int num = st.pop();
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}
