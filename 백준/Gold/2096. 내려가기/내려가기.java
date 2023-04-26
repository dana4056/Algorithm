import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int MAX = -1, MIN = Integer.MAX_VALUE;

        int[][] arr = new int[N][3];
        int[][][] DP = new int[2][N+1][5];

        for(int i = 1 ; i < N+1 ; i++){
            Arrays.fill(DP[1][i], Integer.MAX_VALUE);
        }

        for(int i = 0 ; i < N ; i++){
            String[] tmp = br.readLine().split(" ");
            for(int j = 0 ; j < 3 ; j++){
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for(int r = 1 ; r <= N ; r++){
            for(int c = 1 ; c <= 3 ; c++){
                DP[0][r][c] = arr[r-1][c-1] + Math.max(Math.max(DP[0][r-1][c-1], DP[0][r-1][c]), DP[0][r-1][c+1]);
                DP[1][r][c] = arr[r-1][c-1] + Math.min(Math.min(DP[1][r-1][c-1], DP[1][r-1][c]), DP[1][r-1][c+1]);

                if(r == N){
                    MAX = Math.max(MAX, DP[0][r][c]);
                    MIN = Math.min(MIN, DP[1][r][c]);
                }
            }
        }

        System.out.println(MAX+" "+MIN);

    }
}
