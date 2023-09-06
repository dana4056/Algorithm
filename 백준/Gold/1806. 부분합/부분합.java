import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NS = br.readLine().split(" ");
        int N = Integer.parseInt(NS[0]);
        int S = Integer.parseInt(NS[1]);

        int[] arr = new int[N+1];
        int[] len = new int[N+1];
        String[] line = br.readLine().split(" ");
        for(int i = 1 ; i <= N ; i++){
            arr[i] = Integer.parseInt(line[i-1]);
        }

        int MIN = Integer.MAX_VALUE;
        int sum = 0;
        int left = 1;
        for(int right = 1 ; right <= N ; right++){
            sum += arr[right];
            len[right] = len[right-1] + 1;

            if(sum >= S){
                while(true){
                    if(sum - arr[left] < S || left == right) break;
                    sum -= arr[left++];
                    len[right] -= 1;
                }
                MIN = Math.min(MIN, len[right]);
            }
        }
        System.out.println(MIN == Integer.MAX_VALUE ? 0 : MIN);
    }
}
