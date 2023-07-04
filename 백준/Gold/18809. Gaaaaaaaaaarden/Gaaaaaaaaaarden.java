import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int N, M, G, R;
    static char[][] arr;        // 정원
    static char[][] copy;       // 정원 복사
    static int[][] levels;      // 각 배양액의 레벨(도달 시간)
    static int[][] bae;         // 배양액 뿌릴 수 있는 곳 좌표 인덱스
    static int[] selectIdx;     // 선택한 배양액 뿌릴 곳
    static char[] select;       // 선택한 곳에 뿌릴 배양액 종류 순서
    static int ans;             // 최종 정답 (꽃 개수 최대값)
    static int Gcnt, Rcnt, baeCnt;
    static int[] dr = {-1, 1, 0, 0};    //상하좌우
    static int[] dc = {0, 0, -1, 1};
    static PriorityQueue<Coord> q = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NMGR = br.readLine().split(" ");
        N = Integer.parseInt(NMGR[0]);
        M = Integer.parseInt(NMGR[1]);
        G = Integer.parseInt(NMGR[2]);
        R = Integer.parseInt(NMGR[3]);
        arr = new char[N][M];
        copy = new char[N][M];
        levels = new int[N][M];
        bae = new int[10][2];
        selectIdx = new int[G+R];
        select = new char[G+R];


        for(int i = 0 ; i < N ; i++){
            String line = br.readLine();
            for(int j = 0 ; j < M ; j++){
                arr[i][j] = line.charAt(j*2);
                if(arr[i][j] == '2'){
                    bae[baeCnt][0] = i; // 배양액 행
                    bae[baeCnt][1] = j; // 배양액 열
                    baeCnt++;
                }
            }
        }
        comb(0,0);

        System.out.println(ans);
    }
    // 조합 -> 순열
    private static void comb(int start, int cnt) {
        if(cnt == G+R){
            perm(0);
            return;
        }

        for(int i = start ; i < baeCnt ; i++){
            selectIdx[cnt] = i;
            comb(i+1, cnt+1);
        }
    }

    private static void perm(int cnt) {
        q.clear();
        if(cnt == G+R){
            for(int i = 0 ; i < N ; i++){
                Arrays.fill(levels[i], -1);
                for(int j = 0 ; j < M ; j++){
                    copy[i][j] = arr[i][j];
                }
            }
            for(int i = 0 ; i < G+R ; i++){
                int r = bae[selectIdx[i]][0];
                int c = bae[selectIdx[i]][1];
                if(select[i] == 'G'){
                    copy[r][c] = 'G';
                    levels[r][c] = 0;
                    q.add(new Coord(r, c, 'G', 0));
                }else{
                    copy[r][c] = 'R';
                    levels[r][c] = 0;
                    q.add(new Coord(r, c, 'R', 0));
                }
            }

            bfs();
            return;
        }

        // i는 배양액 종류(0:G, 1:R)
        for(int i = 0 ; i < 2 ; i++){
            if(i == 0 && Gcnt < G){     // 초록색 배양액 선택
                Gcnt++;
                select[cnt] = 'G';
                perm(cnt+1);
                Gcnt--;
            }else if(i == 1 && Rcnt < R){          // 빨간색 배양액 선택
                Rcnt++;
                select[cnt] = 'R';
                perm(cnt+1);
                Rcnt--;
            }
        }
    }

    private static void bfs() {
        int flower = 0;

        while (!q.isEmpty()){
            Coord now = q.poll();
            int r = now.row;
            int c = now.col;
            char color = now.color;
            int l = now.level;

            // 이미 꽃 핀 자리면 확산 X
            if(copy[r][c] == 'F') continue;

            for(int i = 0 ; i < 4 ; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(inRange(nr, nc) && copy[nr][nc] != '0'){
                    if(copy[nr][nc] == '1' || copy[nr][nc] == '2'){
                        levels[nr][nc] = l + 1;
                        copy[nr][nc] = color;
                        q.add(new Coord(nr, nc, color, l+1));
                    }else{
                        if((copy[nr][nc] == 'G' || copy[nr][nc] == 'R') && copy[nr][nc] != color && levels[nr][nc] == l + 1){
                            copy[nr][nc] = 'F';
                            flower++;
                        }
                    }
                }
            }
        }
        ans = Math.max(ans, flower);
    }

    private static boolean inRange(int r, int c){
        if(r >= 0 && r < N && c >= 0 && c < M){
            return true;
        }
        return false;
    }

    static class Coord implements Comparable<Coord>{
        int row;
        int col;
        char color;
        int level;

        Coord(int row, int col, char color, int level){
            this.row = row;
            this.col = col;
            this.color = color;
            this.level = level;
        }

        @Override
        public int compareTo(Coord o) {
            return this.level - o.level;
        }
    }
}
