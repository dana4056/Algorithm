import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M, K, MAX;
    static int[][] arr1;
    static int[][] arr2;
    static int[] br = {0,0,1,1,2,2};    //block row
    static int[] bc = {0,1,0,1,0,1};    //block col
    static int[] select = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        K = Math.max(N, M);
        arr1 = new int[K][K];
        arr2 = new int[K][K];

        for(int i = 0 ; i < N ; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0 ; j < M ; j++){
                arr1[i][j] = Integer.parseInt(line[j]);
                arr2[(K-1)-j][i] = arr1[i][j];
            }
        }

        // 1자 막대 모양
        for(int r = 0 ; r < K ; r++){
            int sum1 = 0;
            int sum2 = 0;
            for(int c = 0 ; c < K ; c++){
                if(c < 4){
                    sum1 += arr1[r][c];
                    sum2 += arr2[r][c];
                    MAX = Math.max(MAX, Math.max(sum1, sum2));
                }else{
                    sum1 -= arr1[r][c-4];
                    sum1 += arr1[r][c];
                    sum2 -= arr2[r][c-4];
                    sum2 += arr2[r][c];
                    MAX = Math.max(MAX, Math.max(sum1, sum2));
                }
            }
        }

        // 그 이외 모양
        for(int r = 0 ; r < K-2 ; r++){
            for(int c = 0 ; c < K-1 ; c++){
                comb(0, 0, r, c);
            }
        }

        System.out.println(MAX);
    }

    private static void comb(int start, int cnt, int row, int col) {
        if(cnt == 2){
            if(isPossible(select[0], select[1])){
                int r1 = row + br[select[0]];
                int c1 = col + bc[select[0]];
                int r2 = row + br[select[1]];
                int c2 = col + bc[select[1]];

                int sum1 = calSix(row, col, arr1) - arr1[r1][c1] - arr1[r2][c2];
                int sum2 = calSix(row, col, arr2) - arr2[r1][c1] - arr2[r2][c2];
                MAX = Math.max(MAX, Math.max(sum1, sum2));
            }
            return;
        }

        for(int i = start ; i < 6 ; i++){
            select[cnt] = i;
            comb(i+1, cnt+1, row, col);
        }
    }

    private static boolean isPossible(int a, int b) {
        if((a == 0 && b == 3) || (a == 1 && b == 2) || (a == 2 && b == 3)||(a == 2 && b == 5)||(a == 3 && b == 4)){
            return false;
        }
        return true;
    }


    private static int calSix(int r, int c, int[][] arr) {
        int sum = 0;
        for(int i = r ; i < r+3 ; i++){
            for(int j = c ; j < c+2 ; j++){
                sum += arr[i][j];
            }
        }
        return sum;
    }
}
