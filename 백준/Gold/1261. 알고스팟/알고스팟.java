import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int[] dr = {-1,1,0,0};   //상하좌우
    static int[] dc = {0,0,-1,1};   //상하좌우
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] MN = br.readLine().split(" ");
        M = Integer.parseInt(MN[0]);
        N = Integer.parseInt(MN[1]);

        int[][] arr = new int[N][M];
        int[][] dp = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for(int i = 0 ; i < N ; i++){
            String line = br.readLine();
            for(int j = 0 ; j < M ; j++){
                arr[i][j] = line.charAt(j) == '1' ? 1 : 0;
                if(!(i == 0 && j == 0)){
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        PriorityQueue<Coord> q = new PriorityQueue<>();
        visited[0][0] = true;
        q.add(new Coord(0,0,0));

        while (!q.isEmpty()){
            Coord now = q.poll();

            if(now.row == N-1 && now.col == M-1){
                System.out.println(now.cnt);
                break;
            }

            // 테이블 갱신
            for(int i = 0 ; i < 4 ; i++){
                int nr = now.row + dr[i];
                int nc = now.col + dc[i];
                if(inRange(nr, nc) && !visited[nr][nc]){
                    dp[nr][nc] = Math.min(dp[nr][nc], dp[now.row][now.col] + arr[nr][nc]);
                    visited[nr][nc] = true;
                    q.add(new Coord(nr, nc, dp[nr][nc]));
                }

            }
        }

    }

    private static boolean inRange(int r, int c) {
        if(r >= 0 && r < N && c >= 0 && c < M){
            return true;
        }
        return false;
    }

    static class Coord implements Comparable<Coord>{
        int row;
        int col;
        int cnt;

        Coord(int r, int c, int cnt){
            this.row = r;
            this.col = c;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Coord o){
            return this.cnt - o.cnt;
        }
    }
}
