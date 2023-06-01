import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dr = {-1, 1, 0, 0};    //상하좌우
    static int[] dc = {0, 0, -1, 1};    //상하좌우
    static int N, M;
    static int[][][] visited;
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);    // 행
        M = Integer.parseInt(NM[1]);    // 열

        arr = new char[N][M];
        visited = new int[N][M][2];
        Queue<Coord> q = new LinkedList<>();

        for(int r = 0 ; r < N ; r++){
            arr[r] = br.readLine().toCharArray();
        }

        q.add(new Coord(0,0, 0));
        visited[0][0][0] = 1;
        Coord now = null;
        while (!q.isEmpty()){
            now = q.poll();

            for(int i = 0 ; i < 4 ; i++) {
                int nr = now.row + dr[i];
                int nc = now.col + dc[i];
                int wall = now.wall;

                if(inRange(nr, nc) && arr[nr][nc] == '0' && visited[nr][nc][wall] == 0){
                    visited[nr][nc][wall] = visited[now.row][now.col][wall] + 1;
                    q.add(new Coord(nr, nc, wall));
                }
                else if(inRange(nr, nc) && arr[nr][nc] == '1' && wall == 0 && visited[nr][nc][wall] == 0){
                    visited[nr][nc][wall+1] = visited[now.row][now.col][wall] + 1;
                    q.add(new Coord(nr, nc, wall+1));
                }
            }
        }

        int val1= visited[N-1][M-1][0];
        int val2= visited[N-1][M-1][1];
        if(val1 != 0 && val2 != 0){
            System.out.println(Math.min(val1, val2));
        }else if(val1 == 0 && val2 == 0){
            System.out.println(-1);
        }else{
            System.out.println(val1 == 0 ? val2 : val1);
        }

    }

    static boolean inRange(int r, int c){
        if(r >= 0 && r < N && c >= 0 && c < M){
            return true;
        }
        return false;
    }

    static class Coord{
        int row;
        int col;
        int wall;

        Coord(int r, int c, int w){
            this.row = r;
            this.col = c;
            this.wall = w;
        }
    }
}
