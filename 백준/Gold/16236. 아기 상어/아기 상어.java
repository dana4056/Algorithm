import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int eatCnt, size = 2, totalMove;
    static int[] dr = {-1,0,0,1}; // 상좌우하
    static int[] dc = {0,-1,1,0}; // 상좌우하
    static int[] fishes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        fishes = new int[7];

        PriorityQueue<Shark> q = new PriorityQueue<>();
        for(int i = 0 ; i < N ; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j++){
                arr[i][j] = Integer.parseInt(line[j]);
                if(arr[i][j] > 0 && arr[i][j] <= 6){
                    fishes[arr[i][j]] += 1;
                }
                if(arr[i][j] == 9){
                    visited[i][j] = true;
                    q.add(new Shark(i, j, 0));
                    arr[i][j] = 0;
                }
            }
        }

        if(targetFishes(size) > 0){
            while(!q.isEmpty()){
                Shark now = q.poll();
                int r = now.row;
                int c = now.col;
                // 물고기 하나 먹었을 떄
                if(arr[r][c] > 0 && arr[r][c] < size){
                    eatCnt++;               // 물고기 먹을 횟수 카운팅
                    fishes[arr[r][c]] -= 1;
                    arr[r][c] = 0;          // 먹힌 물고기 -> 빈칸
                    totalMove += now.move;  // 이동한 회수 카운팅

                    if(eatCnt == size){
                        eatCnt = 0;
                        size++;
                    }

                    // 다시 탐색 시작
                    q.clear();
                    if(targetFishes(size) > 0){
                        for(int i = 0 ; i < N ; i++){
                            Arrays.fill(visited[i], false); // 방문 배열 초기화
                        }
                        visited[r][c] = true;
                        q.add(new Shark(r, c, 0));
                    }
                    continue;
                }

                for(int i = 0 ; i < 4 ; i++){
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if(inRange(nr, nc) && !visited[nr][nc] && arr[nr][nc] <= size){
                        visited[nr][nc] = true;
                        q.add(new Shark(nr, nc, now.move+1));
                    }
                }
            }
        }

        System.out.println(totalMove);
    }

    private static int targetFishes(int size) {
        int cnt = 0;
        for (int i = 1 ; i <= 6 ; i++){
            if(i < size){
                cnt += fishes[i];
            }
        }
        return cnt;
    }

    static boolean inRange(int r, int c){
        if( r >= 0 && r < N && c >= 0 && c < N){
            return true;
        }
        return false;
    }


    static class Shark implements Comparable<Shark>{
        int row;
        int col;
        int move;

        Shark(int r, int c, int m){
            this.row = r;
            this.col = c;
            this.move = m;
        }

        @Override
        public int compareTo(Shark s) {
            if(this.move == s.move){
                if(this.row == s.row){
                    return this.col - s.col;
                }else{
                    return this.row - s.row;
                }
            }
            return this.move - s.move;
        }
    }
}
