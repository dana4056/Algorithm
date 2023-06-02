import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] Hdr = {-2,-1,1,2,2,1,-1,-2};   // 말의 행 움직임
    static int[] Hdc = {-1,-2,-2,-1,1,2,2,1};   // 말의 열 움직임
    static int[] Mdr = {-1,1,0,0};              // 원숭이의 행 움직임
    static int[] Mdc = {0,0,-1,1};              // 원숭이의 열 움직임
    static int[][][] visited;
    static int W, H, K;
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        String[] WH = br.readLine().split(" ");
        W = Integer.parseInt(WH[0]);
        H = Integer.parseInt(WH[1]);
        arr = new char[H][W];
        visited = new int[H][W][K+1];

        for(int r = 0 ; r < H ; r++){
            String rowInput = br.readLine();
            for(int c = 0 ; c < W*2 ; c+=2){
                arr[r][c/2] = rowInput.charAt(c);
            }
        }

        Queue<Monkey> q = new LinkedList<>();
        visited[0][0][0] = 1;
        q.add(new Monkey(0,0,0));

        while(!q.isEmpty()){
            Monkey now = q.poll();

            // 원숭이식 이동
            for(int i = 0 ; i < 4 ; i++){
                int nr = now.row + Mdr[i];
                int nc = now.col + Mdc[i];
                int cnt = now.cnt;

                if(inRange(nr, nc) && arr[nr][nc] == '0' && visited[nr][nc][cnt] == 0){
                    visited[nr][nc][cnt] = visited[now.row][now.col][cnt] + 1;
                    q.add(new Monkey(nr, nc, cnt));
                }
            }

            // 말식 이동
            for(int i = 0 ; i < 8 ; i++){
                int nr = now.row + Hdr[i];
                int nc = now.col + Hdc[i];
                int cnt = now.cnt;

                if(inRange(nr, nc) && arr[nr][nc] == '0' && cnt < K && visited[nr][nc][cnt+1] == 0){
                    visited[nr][nc][cnt+1] = visited[now.row][now.col][cnt] + 1;
                    q.add(new Monkey(nr, nc, cnt+1));
                }
            }
        }

        int MIN = Integer.MAX_VALUE;
        for(int i = 0 ;i <= K ; i++){
            MIN = Math.min(visited[H-1][W-1][i]==0?Integer.MAX_VALUE:visited[H-1][W-1][i], MIN);
        }
        System.out.println(MIN == Integer.MAX_VALUE ? -1 : MIN-1);

    }

    static boolean inRange(int r, int c){
        if(r >= 0 && r < H && c >= 0 && c < W){
            return true;
        }
        return false;
    }

    static class Monkey{
        int row;
        int col;
        int cnt;

        Monkey(int r, int c, int k){
            this.row = r;
            this.col = c;
            this.cnt = k;
        }
    }
}
