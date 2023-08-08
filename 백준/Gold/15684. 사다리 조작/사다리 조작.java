import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] arr;
    static int N, M, H;
    static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NMH = br.readLine().split(" ");
        N = Integer.parseInt(NMH[0]);
        M = Integer.parseInt(NMH[1]);
        H = Integer.parseInt(NMH[2]);
        arr = new int[H+1][N+1];

        for(int i = 0 ; i < M ; i++){
            String[] AB = br.readLine().split(" ");
            int A = Integer.parseInt(AB[0]);
            int B = Integer.parseInt(AB[1]);

            arr[A][B] = B+1;
        }

        dfs(0,1);

        if(MIN == Integer.MAX_VALUE){
            MIN = -1;
        }
        System.out.println(MIN);
    }

    private static void dfs(int cnt, int r) {
        if(cnt > 3){
            return;
        }
        if(checkArrive()){
            MIN = Math.min(MIN, cnt);
            return;
        }

        for(int i = r ; i <= H ; i++){
            for(int j = 1 ; j < N ; j++){
                if(arr[i][j] == 0 && arr[i][j-1] == 0 && arr[i][j+1] == 0 && cnt + 1 < MIN){
                    arr[i][j] = j+1;
                    dfs(cnt+1, i);
                    arr[i][j] = 0;
                }
            }
        }
    }

    private static boolean checkArrive() {
        for(int s = 1 ; s <= N ; s++){
            int idx = s;
            for(int j = 1 ; j <= H ; j++){
                if(arr[j][idx] != 0 ){
                    idx++;
                }else if(arr[j][idx-1] != 0){
                    idx--;
                }
            }
            if(idx != s){
                return false;
            }
        }
        return true;
    }
}
