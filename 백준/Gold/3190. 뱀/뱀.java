import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] arr;
    static int N;
    static int direction = 3;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[] now = {1,1};
    static Queue<int[]> snake = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 보드 크기
        int K = Integer.parseInt(br.readLine());    // 사과 개수
        arr = new int[N+1][N+1];
        arr[1][1] = 2;

        for(int i = 0 ; i < K ; i++){
            String[] RC = br.readLine().split(" ");
            int ar = Integer.parseInt(RC[0]);   // apple row
            int ac = Integer.parseInt(RC[1]);   // apple col
            arr[ar][ac] = 1;
        }

        int L = Integer.parseInt(br.readLine());    // 방향 전환 횟수
        Queue<Rotation> rotate = new LinkedList<>();
        for(int i = 0 ; i < L ; i++){
            String[] tmp = br.readLine().split(" ");
            int time = Integer.parseInt(tmp[0]);
            char dir = tmp[1].charAt(0);
            rotate.add(new Rotation(time, dir));
        }

        Rotation nextDir = rotate.poll();
        snake.add(new int[]{1,1});
        int time = 0;
        boolean gameOver = false;
        while(!gameOver){
            gameOver = moveSnake();
            time++;

            if(nextDir != null && time == nextDir.time){
                //방향 전환
                changeDir(direction, nextDir.dir);
                if(!rotate.isEmpty()){
                    nextDir = rotate.poll();
                }else{
                    nextDir = null;
                }
            }
        }

        System.out.println(time);

    }

    private static boolean moveSnake() {
        boolean stop = false;
        int nextR = now[0] + dr[direction];
        int nextC = now[1] + dc[direction];

        // 벽 이상일 떄
        if(!inRange(nextR, nextC) || (inRange(nextR, nextC) && arr[nextR][nextC] == 2)){
            stop = true;
            return stop;
        }


        if(arr[nextR][nextC] == 0) {
            // 꼬리 단축
            int[] poll = snake.poll();
            arr[poll[0]][poll[1]] = 0;
        }

        //머리 삽입
        arr[nextR][nextC] = 2;
        now[0] = nextR;
        now[1] = nextC;
        snake.add(new int[]{now[0], now[1]});

        return stop;
    }

    private static void changeDir(int now, char dir) {
        switch (now){
            case 0:     // 상
                direction = (dir == 'L'? 2 : 3);
                break;
            case 1:     // 하
                direction = (dir == 'L'? 3 : 2);
                break;
            case 2:     // 좌
                direction = (dir == 'L'? 1 : 0);
                break;
            case 3:     // 우
                direction = (dir == 'L'? 0 : 1);
                break;
        }
    }

    static boolean inRange(int r, int c){
        if(r > 0 && r <= N && c > 0 && c <= N ){
            return true;
        }
        return false;
    }

    static class Rotation {
        int time;
        char dir;

        Rotation(int t, char d){
            this.time = t;
            this.dir = d;
        }
    }
}
