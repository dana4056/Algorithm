import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int[][] selected = new int[2][3];
    static int N, M, total;
    static int Max, initCnt;
    static List<Coord> virus = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int r = 0 ; r < N ; r++){
            String[] tmp = br.readLine().split(" ");
            for(int c = 0 ; c < M ; c++){
                arr[r][c] = Integer.parseInt(tmp[c]);

                if(arr[r][c] == 0) {
                    initCnt++;
                } else {
                    if(arr[r][c] == 2){
                        virus.add(new Coord(r, c));
                    }
                    visited[r][c] = true;
                }
            }
        }

        comb(0,0,0);
        System.out.println(Max);

    }

    static void comb(int row, int col, int cnt){
        if(cnt == 3){
            for(int i = 0 ; i < 3 ; i++){
                arr[selected[0][i]][selected[1][i]] = 1;
            }
            Max = Math.max(Max, countSafeZone());

            for(int i = 0 ; i < 3 ; i++){
                arr[selected[0][i]][selected[1][i]] = 0;
            }
            return;
        }
        int sCol = col;
        for(int r = row ; r < N ; r++){
            if(r != row){
                sCol = 0;
            }
            for(int c = sCol ; c < M ; c++){
                if(!visited[r][c]){
                    visited[r][c] = true;
                    selected[0][cnt] = r;
                    selected[1][cnt] = c;
                    comb(r, c, cnt+1);
                    visited[r][c] = false;
                }
            }
        }
    }

    private static int countSafeZone() {
        int cnt = initCnt;
        int[][] visited = new int[N][M];
        for(int i = 0 ; i < N ; i++){
             visited[i] = arr[i].clone();
        }
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1 ,1};

        Queue<Coord> q = new LinkedList<>();
        for(Coord c : virus){
            q.add(c);
        }

        while(!q.isEmpty()){
            Coord now = q.poll();

            for(int i = 0 ; i < 4 ; i++){
                int nr = now.row + dr[i];
                int nc = now.col + dc[i];
                if(inRange(nr, nc) && visited[nr][nc] == 0){
                    visited[nr][nc] = 2;
                    cnt--;
                    q.add(new Coord(nr ,nc));
                }
            }
        }
        return cnt - 3;
    }

    private static boolean inRange(int r, int c) {
        if(r >= 0 && r < N && c >= 0 && c < M){
            return true;
        }
        return false;
    }

    static class Coord{
        int row;
        int col;

        Coord(int r, int c){
            this.row = r;
            this.col = c;
        }
    }
}
