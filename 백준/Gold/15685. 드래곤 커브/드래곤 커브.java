import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] arr = new int[101][101];
    static int[] dr = {0,-1,0,1};   //우상좌하
    static int[] dc = {1,0,-1,0};   //우상좌하
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i++){
            String[] XYDG = br.readLine().split(" ");
            int x = Integer.parseInt(XYDG[0]);
            int y = Integer.parseInt(XYDG[1]);
            int d = Integer.parseInt(XYDG[2]);
            int g = Integer.parseInt(XYDG[3]);
            List<Integer> dirs = new ArrayList<>();
            dirs.add(d);

            arr[y][x] = 1;
            arr[y+dr[d]][x+dc[d]] = 1;

            drawCurve(x+dc[d], y+dr[d], dirs, 0, g);
        }
        System.out.println(checkBox());
    }

    private static int checkBox() {
        int cnt = 0;
        for(int i = 0 ; i < 100 ; i++){
            for(int j = 0 ; j < 100 ; j++){
                if(arr[i][j] == 0) continue;
                if(arr[i][j] == 1 && arr[i][j+1] == 1 && arr[i+1][j] == 1 && arr[i+1][j+1] == 1){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void drawCurve(int sc, int sr, List<Integer> dirs, int cnt, int g) {
        if(cnt == g){
            return;
        }
        
        int nr = sr;
        int nc = sc;
        for(int i = dirs.size()-1 ; i >= 0 ; i--){
            int dir = (dirs.get(i) + 1) % 4;    // 90도 회전
            nr += dr[dir];
            nc += dc[dir];

            arr[nr][nc] = 1;
            dirs.add(dir);
        }
        drawCurve(nc, nr, dirs, cnt+1, g);
    }
}
