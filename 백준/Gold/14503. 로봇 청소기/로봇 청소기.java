import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M, R, C, dir;
    static char[][] map;
    static int cnt;
    static int[] dr = {-1,0,1,0};   //북동남서
    static int[] dc = {0,1,0,-1};   //북동남서
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        String[] RCD = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        R = Integer.parseInt(RCD[0]);
        C = Integer.parseInt(RCD[1]);
        dir = Integer.parseInt(RCD[2]);
        map = new char[N][M];

        for(int i = 0 ; i < N ; i++){
            String line = br.readLine();
            for(int j = 0 ; j < M ; j++){
                map[i][j] = line.charAt(j*2);
            }
        }

        boolean stop = false;
        while(!stop){
            if(map[R][C] == '0'){
                cnt++;
                map[R][C] = '2';
            }

            boolean noClean = false;
            for(int i = 0 ; i < 4 ; i++){
                int nr = R + dr[i];
                int nc = C + dc[i];
                if(inRange(nr, nc) && map[nr][nc] == '0'){
                    noClean = true;
                    break;
                }
            }

            if(noClean){
                turn();
                straight();
            }else{
                if(!back()){
                    stop = true;
                }
            }
        }

        System.out.println(cnt);

    }
    static boolean inRange(int r, int c){
        if(r >= 0 && r < N && c >= 0 && c < M){
            return true;
        }
        return false;
    }

    // 반시계 방향 회전
    static void turn(){
        dir = (dir + 3) % 4;
    }

    // 보고있는 방향대로 직진
    static void straight(){
        int nr = R + dr[dir];
        int nc = C + dc[dir];
        if(inRange(nr, nc) && map[nr][nc] == '0'){
            R = nr;
            C = nc;
        }
    }

    // 후진
    static boolean back(){
        int nr = R + dr[(dir + 2) % 4];
        int nc = C + dc[(dir + 2) % 4];
        if(inRange(nr, nc) && map[nr][nc] != '1'){
            R = nr;
            C = nc;
            return true;
        }
        return false;
    }
}
