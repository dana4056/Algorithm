import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String[] line = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(line[i]);
        }

        int[] stack = new int[N];
        int top = -1;
        for(int i = N-1 ; i >= 0 ; i--){
            int num = arr[i];

            while(top >= 0 && stack[top] <= arr[i]){
                // 스택: pop
                top--;
            }

            if(top >= 0){
               arr[i] = stack[top];
            }else{
               arr[i] = -1;
            }
            // 스택: push
            top++;
            stack[top] = num;
        }

        for(int i = 0 ; i < N ; i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.print(sb);

    }
}
