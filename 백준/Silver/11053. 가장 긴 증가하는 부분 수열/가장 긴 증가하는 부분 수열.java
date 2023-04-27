import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int MAX = -1;

        int N = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");

        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(tmp[i]);
        }

        int[] DP = new int[N];

        for(int i = 0 ; i < N ; i++){
            int max = 0;
            for(int j = 0 ; j < i ; j++){
                if(arr[j] < arr[i] && DP[j] > max){
                    max = DP[j];
                }
            }
            if(max != 0){
                DP[i] = max + 1;
            }else{
                DP[i] = 1;
            }

            MAX = Math.max(MAX, DP[i]);
        }

        System.out.println(MAX);

    }
}
