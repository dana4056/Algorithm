import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static boolean find = true;
    static char[][] arr;
    static int[][] select = new int[3][2];
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static List<int[]> teachers = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for(int i = 0 ; i < N ; i++){
            String line = br.readLine();
            for(int j = 0 ; j < N ; j++){
                arr[i][j] = line.charAt(j*2);
                if(arr[i][j] == 'T'){
                    teachers.add(new int[]{i,j});
                }
            }
        }

        comb(0);
        System.out.println(find ? "NO" : "YES");
    }

    private static void comb(int cnt) {
        if(!find) return;
        if(cnt == 3){
            find = watchStudent();
            return;
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(arr[i][j] == 'X'){
                    select[cnt][0] = i;
                    select[cnt][1] = j;
                    arr[i][j] = 'O';
                    comb(cnt+1);
                    arr[i][j] = 'X';
                }
            }
        }
    }

    private static boolean watchStudent() {
        for(int[] t: teachers){
            for(int i = 0 ;i <4 ; i++){
                int nr = t[0];
                int nc = t[1];
                while(inRange(nr, nc)){
                    nr += dr[i];
                    nc += dc[i];
                    if(inRange(nr, nc) && arr[nr][nc] != 'X'){
                        if(arr[nr][nc] == 'S'){
                            return true;
                        }
                        break;
                    }
                }
            }
        }
        return false;
    }

    private static boolean inRange(int r, int c) {
        if(r >= 0 && r < N && c >= 0 && c < N){
            return true;
        }
        return false;
    }
}
