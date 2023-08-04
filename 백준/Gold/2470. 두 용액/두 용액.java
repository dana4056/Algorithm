import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int num1 = 0, num2 = 0;
        int MIN = Integer.MAX_VALUE;

        String[] line = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(arr);

        int left = 0;
        int right = N-1;

        while(left < right){
            int sum = arr[left] + arr[right];
            int abs = Math.abs(sum);

            if(abs < MIN){
                MIN = abs;
                num1 = arr[left];
                num2 = arr[right];
            }

            if (sum > 0){
                right--;
            }else{
                left++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(num1).append(" ").append(num2);
        System.out.println(sb);
    }
}
