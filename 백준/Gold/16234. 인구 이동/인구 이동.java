import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] arr;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NLR = br.readLine().split(" ");
        N = Integer.parseInt(NLR[0]);
        L = Integer.parseInt(NLR[1]);
        R = Integer.parseInt(NLR[2]);
        arr = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        for(int i = 0; i < N ; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j++){
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean move = true;
        while(move){
            for(int i = 0 ; i < N ; i++){
                Arrays.fill(visited[i], false);
            }
            move = false;

            for(int r = 0; r < N ; r++){
                for(int c = 0 ; c < N ; c++){

                    int sum = 0;
                    List<int[]> united = new ArrayList<>();
                    if(!visited[r][c]) {
                        visited[r][c] = true;
                        int[] nation = new int[]{r, c};
                        q.add(nation);
                        united.add(nation);
                        sum += arr[r][c];
                    }
                    else continue;

                    while(!q.isEmpty()){
                        int[] now = q.poll();
                        for(int i = 0 ; i < 4 ; i++){
                            int nr = now[0] + dr[i];
                            int nc = now[1] + dc[i];
                            if(inRange(nr, nc) && !visited[nr][nc] && possibleUnited(now[0], now[1], nr, nc)){
                                visited[nr][nc] = true;
                                int[] nation = new int[]{nr, nc};
                                q.add(nation);
                                united.add(nation);
                                sum += arr[nr][nc];
                            }
                        }
                    }

                    if(united.size() > 1){
                        move = true;
                        int population = sum / united.size();
                        for(int[] n: united){
                            arr[n[0]][n[1]] = population;
                        }
                    }
                }
            }
            if(move) cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean possibleUnited(int r1, int c1, int r2, int c2) {
        int gap = Math.abs(arr[r1][c1] - arr[r2][c2]);
        if(gap >= L && gap <= R) return true;
        return false;
    }

    private static boolean inRange(int r, int c) {
        if( r >= 0 && r < N && c >= 0 && c < N) return true;
        return false;
    }
}
