import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M, X, Y;
    static int[] dice = new int[6];
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NMXYK = br.readLine().split(" ");
        N = Integer.parseInt(NMXYK[0]);
        M = Integer.parseInt(NMXYK[1]);
        X = Integer.parseInt(NMXYK[2]);
        Y = Integer.parseInt(NMXYK[3]);
        int K = Integer.parseInt(NMXYK[4]);

        map = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        String cmds = br.readLine();
        for(int i = 0 ; i < K*2 ; i += 2){
            char cmd = cmds.charAt(i);
            moveDice(cmd);
        }

        System.out.print(sb);
    }

    private static void moveDice(char cmd) {
        switch (cmd){
            case '1':   // 동
                if(Y + 1 < M){
                    moveToEast();
                }
                break;
            case '2':   // 서
                if(Y - 1 >= 0){
                    moveToWest();
                }
                break;
            case '3':   // 북
                if(X - 1 >= 0){
                    moveToNorth();
                }
                break;
            case '4':   // 남
                if(X + 1 < N){
                    moveToSouth();
                }
                break;
        }
    }

    private static void moveToSouth() {
        int tmp = dice[5];
        dice[5] = dice[4];
        dice[4] = dice[2];
        dice[2] = dice[0];
        dice[0] = tmp;

        X += 1;
        copyMapAndDice();
    }

    private static void moveToNorth() {
        int tmp = dice[0];
        dice[0] = dice[2];
        dice[2] = dice[4];
        dice[4] = dice[5];
        dice[5] = tmp;

        X -= 1;
        copyMapAndDice();
    }

    private static void moveToWest() {
        int tmp = dice[1];
        dice[1] = dice[2];
        dice[2] = dice[3];
        dice[3] = dice[5];
        dice[5] = tmp;

        Y -= 1;
        copyMapAndDice();
    }

    private static void moveToEast() {
        int tmp = dice[5];
        dice[5] = dice[3];
        dice[3] = dice[2];
        dice[2] = dice[1];
        dice[1] = tmp;

        Y += 1;
        copyMapAndDice();
    }

    private static void copyMapAndDice() {
        if(map[X][Y] == 0){
            map[X][Y] = dice[5];
        }else{
            dice[5] = map[X][Y];
            map[X][Y] = 0;
        }
        sb.append(dice[2]).append("\n");
    }
}
