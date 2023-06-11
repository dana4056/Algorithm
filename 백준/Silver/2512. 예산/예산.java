import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        int[] nums = new int[N];
        int[][] table = new int[3][100001];

        int sum = 0;
        int max = 0;
        for(int i = 0 ; i < N ; i++){
            nums[i] = Integer.parseInt(tmp[i]);

            // case1에 필요
            sum += nums[i];                 // 요청 예산 합
            max = Math.max(max, nums[i]);   // 요청 예산 최대 값

            // case2에 필요
            table[0][nums[i]] += nums[i];   // 예산
            table[1][nums[i]] += 1;         // 예산 개수
        }

        int maxMoney = Integer.parseInt(br.readLine());
        if(sum <= maxMoney){
            System.out.println(max);
            return;
        }
        else{
            // 누적합
            for(int i = 1 ; i < 100001 ; i++){
                table[0][i] += table[0][i-1];   // i까지의 예산들 합
                table[1][i] += table[1][i-1];   // i까지 합한 예산 개수
                table[2][i] = table[0][i] + ((N - table[1][i]) * i);
                if(table[2][i] > maxMoney){
                    System.out.println(i-1);
                    break;
                }
            }
        }
    }
}
