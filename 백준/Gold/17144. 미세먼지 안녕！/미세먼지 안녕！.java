import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] arr;
    static int[][] copy;
    static int[] machine;
    static int R, C, T;
    static int[] dr = {0,-1,0,1};   //좌상우하
    static int[] dc = {-1,0,1,0};   //좌상우하
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] RCT = br.readLine().split(" ");
        R = Integer.parseInt(RCT[0]);
        C = Integer.parseInt(RCT[1]);
        T = Integer.parseInt(RCT[2]);

        arr = new int[R][C];
        copy = new int[R][C];
        machine = new int[]{-1,-1};

        for(int i = 0 ; i < R ; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0 ; j < C ; j++){
                arr[i][j] = Integer.parseInt(line[j]);
                if(arr[i][j] == -1 && machine[0] == -1){
                    machine[0] = i;
                    machine[1] = j;
                }
            }
        }

        int spread = 0;
        int nr = 0, nc = 0;
        for(int i = 0 ; i < T ; i++){
            initCopy();
            for(int r = 0 ; r < R ; r++){
                for(int c = 0 ; c < C ; c++){
                    spread = 0;
                    if(arr[r][c] > 0){
                        for(int s = 0 ; s < 4 ; s++){
                            nr = r + dr[s];
                            nc = c + dc[s];
                            if(inRange(nr, nc, 0, R-1, 0, C-1) && copy[nr][nc] != -1){
                                spread++;
                            }
                        }

                        copy[r][c] += arr[r][c] - (arr[r][c] / 5) * spread;

                        for(int s = 0 ; s < 4 ; s++){
                            nr = r + dr[s];
                            nc = c + dc[s];
                            if(inRange(nr, nc, 0, R-1, 0, C-1) && copy[nr][nc] != -1){
                                copy[nr][nc] += arr[r][c] / 5;
                            }
                        }
                    }
                }
            }
            copyToOrigin();
            running();
        }

        int total = 0;
        for(int q = 0 ; q < R ; q++){
            for(int w = 0 ; w < C ; w++){
                total += arr[q][w];
            }
        }
        System.out.println(total+2);
    }

    private static void copyToOrigin() {
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                arr[i][j] = copy[i][j];
            }
        }
    }

    private static void initCopy() {
        for(int i = 0 ; i < R ; i++){
            Arrays.fill(copy[i], 0);
        }
        copy[machine[0]][machine[1]] = -1;
        copy[machine[0]+1][machine[1]] = -1;

    }

    public static void running(){
        // 윗 공기 반시계
        int nr = machine[0], nc = machine[1];
        int dir = 0;
        int upNum = (C * 2) + (nr * 2) - 2;
        for(int i = 0 ; i < upNum ; i++){
            nr += dr[dir];
            nc += dc[dir];
            if(!inRange(nr, nc, 0, machine[0], 0, C-1)){
                nr = nr - dr[dir] + dr[(dir + 1) % 4];
                nc = nc - dc[dir] + dc[(dir + 1) % 4];
                dir = (dir + 1) % 4;
            }
            if(i == upNum - 1){
                arr[nr+dr[(dir+2)%4]][nc+dc[(dir+2)%4]] = 0;
            }else{
                arr[nr+dr[(dir+2)%4]][nc+dc[(dir+2)%4]] = arr[nr][nc];
            }
        }

        // 아랫 공기 시계
        nr = machine[0] + 1;
        nc = machine[1];
        dir = 0;
        int downNum = (C * 2) + ((R - nr) * 2) - 4;
        for(int i = 0 ; i < downNum ; i++){
            nr += dr[dir];
            nc += dc[dir];
            if(!inRange(nr, nc, machine[0] + 1, R-1, 0, C-1)){
                nr = nr - dr[dir] + dr[(dir + 3) % 4];
                nc = nc - dc[dir] + dc[(dir + 3) % 4];
                dir = (dir + 3) % 4;
            }
            if(i == downNum - 1){
                arr[nr+dr[(dir+2)%4]][nc+dc[(dir+2)%4]] = 0;
            }else{
                arr[nr+dr[(dir+2)%4]][nc+dc[(dir+2)%4]] = arr[nr][nc];
            }
        }

        arr[machine[0]][machine[1]] = -1;
        arr[machine[0]+1][machine[1]] = -1;
    }


    public static boolean inRange(int r, int c, int r1, int r2, int c1, int c2){
        if(r >= r1 && r <= r2 && c >= c1 && c <= c2){
            return true;
        }
        return false;
    }
}
