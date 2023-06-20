import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M;
    static char[][] arr;
    static boolean[][] visited;
    static Queue<Coord> q = new LinkedList<>();
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        arr = new char[N][M];
        visited = new boolean[N][M];

        int origin = 0, cnt = 1;
        for(int i = 0 ; i < N ; i++){
            String line = br.readLine();
            for(int j = 0 ; j < M ; j++){
                arr[i][j] = line.charAt(j*2);
                if(arr[i][j] == '1') origin++;  // 처음에 치즈 몇 칸인지 체크
            }
        }

        while(true){
            int del = oneHourLater();
            if(origin - del <= 0){
                break;
            }
            origin -= del;
            cnt++;
        }

        System.out.println(cnt);
        System.out.println(origin);
    }
    static int oneHourLater(){
        int deleted = 0;

        boolean found = false;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ;j < M ; j++){
                if(arr[i][j] == '0'){
                    visited[i][j] = true;
                    q.add(new Coord(i, j));
                    found = true;
                    break;
                }
            }
            if(found) break;
        }

        while(!q.isEmpty()){
            Coord poll = q.poll();

            for(int i = 0 ; i < 4 ; i++){
                int nr = poll.row + dr[i];
                int nc = poll.col + dc[i];
                if(inRange(nr, nc) && !visited[nr][nc]){
                    if(arr[nr][nc] == '0'){
                        visited[nr][nc] = true;
                        q.add(new Coord(nr, nc));
                    }else{
                        arr[nr][nc] = '0';
                        visited[nr][nc] = true;
                        deleted++;
                    }
                }
            }
        }


        for(int i = 0 ; i < N ; i++){
            Arrays.fill(visited[i], false);
        }
        return deleted;
    }
    static boolean inRange(int row, int col){
        if(row >= 0 && row < N && col >= 0 && col < M){
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

