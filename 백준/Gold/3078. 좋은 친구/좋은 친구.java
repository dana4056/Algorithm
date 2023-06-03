import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        int[] cntArr = new int[21];
        int[] nameArr = new int[N+K];

        for(int i = K ; i < N+K ; i++){
            nameArr[i] = br.readLine().length();
        }

        double sum = 0;

        // 윈도우 슬라이딩
        for(int now = 0 ; now < N+K ; now++){
            int out = now + K;

            if(out < N+K){
                cntArr[nameArr[out]] += 1;
            }

            if(nameArr[now] != 0){
                cntArr[nameArr[now]] -= 1;
            }
            sum += cntArr[nameArr[now]];
        }
        System.out.printf("%.0f", sum);
    }
}
