import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N+1];
        int[] arr = new int[N+1];

        String[] line = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(line[i]);
        }

        Stack<Integer> st = new Stack<>();
        for(int i = N-1 ; i >= 0 ; i--){
           while(!st.isEmpty() && st.peek() <= arr[i]){
               st.pop();
           }

           if(!st.isEmpty()){
               nums[i] = st.peek();
           }else{
               nums[i] = -1;
           }

           st.push(arr[i]);
        }

        for(int i = 0 ; i < N ; i++){
            sb.append(nums[i]).append(" ");
        }
        System.out.print(sb);
    }
}
