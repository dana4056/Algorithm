import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] triangle = new int[N+1][N+1];
        int[][] DP = new int[N+1][N+1];

        for(int i = 1 ; i <= N ; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 1 ; j <= i ; j++){
                triangle[i][j] = Integer.parseInt(line[j-1]);
            }
        }

        int MAX = Integer.MIN_VALUE;
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= i ; j++){
                DP[i][j] = Math.max(DP[i-1][j-1], DP[i-1][j]) + triangle[i][j];
                if(i == N){
                    MAX = Math.max(MAX, DP[i][j]);
                }
            }
        }
        System.out.println(MAX);
    }
}
