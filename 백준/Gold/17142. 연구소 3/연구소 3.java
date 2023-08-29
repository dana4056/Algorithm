import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, MIN = Integer.MAX_VALUE, blank;
    static int[][] arr;
    static int[][] copy;
    static int[][] select;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static List<int[]> virus = new ArrayList<>();
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        arr = new int[N][N];
        copy = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j++){
                char ch = line[j].charAt(0);
                switch (ch){
                    case '0':
                        arr[i][j] = 0;
                        blank++;
                        break;
                    case '1':   //벽
                        arr[i][j] = -1;
                        break;
                    case '2':   //바이러스 (비활성)
                        arr[i][j] = -2;
                        virus.add(new int[]{i,j});
                        break;
                }
            }
        }

        select = new int[virus.size()][2];
        comb(0,0);
        System.out.println(MIN == Integer.MAX_VALUE ? -1 : MIN);
    }

    private static void comb(int start, int cnt) {
        if(cnt == M){
            //BFS함수 호출
            MIN = Math.min(spreadVirus(), MIN);
            return;
        }

        for(int i = start ; i < virus.size() ; i++){
            select[cnt][0] = virus.get(i)[0];
            select[cnt][1] = virus.get(i)[1];
            comb(i+1, cnt+1);
        }

    }

    private static int spreadVirus() {
        copyArr();
        int time = 0;

        int cnt = blank;
        while(!q.isEmpty() && cnt > 0){
            int[] now = q.poll();

            for(int i = 0 ; i < 4 ; i++){
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if(inRange(nr, nc)){
                    if(copy[nr][nc] == 0 || copy[nr][nc] == -2){
                        if(copy[nr][nc] == -2) {
                            copy[nr][nc] = -3;
                        }else{
                            copy[nr][nc] = now[2] + 1;
                            time = Math.max(time, now[2] + 1);
                            cnt--;
                        }
                        q.add(new int[]{nr, nc, now[2] + 1});
                    }
                }
            }
        }

        return cnt > 0 ? Integer.MAX_VALUE : time;
    }

    private static void copyArr() {
        for(int i = 0 ; i < N ; i++){
            for(int j = 0; j < N ; j++){
                copy[i][j] = arr[i][j];
            }
        }
        q.clear();
        for(int i = 0 ; i < M ; i++){
            copy[select[i][0]][select[i][1]] = -3;
            q.add(new int[]{select[i][0], select[i][1], 0});
        }
    }

    private static boolean inRange(int r, int c) {
        if(r >= 0 && r < N && c >= 0 && c < N) return true;
        return false;
    }
}
