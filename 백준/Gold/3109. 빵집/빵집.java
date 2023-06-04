import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int C, R, cnt;
    static boolean isFound;
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] RC = br.readLine().split(" ");
        R = Integer.parseInt(RC[0]);
        C = Integer.parseInt(RC[1]);

        arr = new char[R][C];
        for(int i = 0 ; i < R ; i++){
            arr[i] = br.readLine().toCharArray();
        }

        for(int i = 0 ; i < R ; i++){
            DFS(i, 0);
            isFound = false;
        }

        System.out.println(cnt);
    }

    static void DFS(int r, int c){
        if(isFound){
            return;
        }
        if(c == C-1){
            cnt++;
            isFound = true;
            return;
        }

        for(int dr = -1 ; dr <= 1 ; dr++){
            int nc = c + 1;
            int nr = r + dr;

            if(!isFound && inRange(nr, nc) && arr[nr][nc] == '.'){
                arr[nr][nc] = 'o';
                DFS(nr, nc);
            }
        }
    }

    static boolean inRange(int r, int c){
        if(r >= 0 && r < R && c >= 0 && c < C){
            return true;
        }
        return false;
    }
}
