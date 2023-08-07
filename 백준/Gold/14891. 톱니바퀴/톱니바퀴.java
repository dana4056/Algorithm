import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] gear;
    static Queue<Cmd> q;
    static boolean[] visited = new boolean[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gear = new char[4][8];
        q = new LinkedList<>();

        for(int i = 0 ; i < 4 ; i++){
            String line = br.readLine();
            for(int j = 0 ; j < 8 ; j++){
                gear[i][j] = line.charAt(j);
            }
        }

        int K = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < K ; i++){
            String[] ND = br.readLine().split(" ");
            int N = Integer.parseInt(ND[0]) - 1;    // 톱니바퀴 번호
            int D = Integer.parseInt(ND[1]);    // 방향


            q.add(new Cmd(N, D));
            Arrays.fill(visited, false);
            visited[N] = true;

            checkConnection(N, D);

            while (!q.isEmpty()){
                Cmd c = q.poll();
                if(c.dir == 1){
                    turnRight(c.num);
                }else{
                    turnLeft(c.num);
                }
            }
        }

        int cnt = 0;
        for(int i = 0 ; i < 4 ; i++){
            if(gear[i][0] == '1'){
                cnt += (int)Math.pow(2.0, (double) i);
            }
        }
        System.out.println(cnt);
    }

    private static void checkConnection(int n, int d) {
        if(n - 1 >= 0 && n - 1 < 4 && !visited[n-1]) {
            visited[n-1] = true;
            if(gear[n - 1][2] != gear[n][6]){
                q.add(new Cmd(n-1, d * -1));
                checkConnection(n-1, d*-1);
            }
        }
        if(n + 1 >= 0 && n + 1 < 4 && !visited[n+1]){
            visited[n+1] = true;
            if(gear[n][2] != gear[n+1][6]){
                q.add(new Cmd(n + 1, d * -1));
                checkConnection(n+1, d*-1);
            }
        }
    }

    static void turnRight(int n){
        char[] arr = new char[8];
        arr[0] = gear[n][7];

        for(int i = 1 ; i < 8 ; i++){
            arr[i] = gear[n][i-1];
        }

        gear[n] = arr;

    }

    static void turnLeft(int n){
        char[] arr = new char[8];
        arr[7] = gear[n][0];

        for(int i = 6 ; i >= 0; i--){
            arr[i] = gear[n][i+1];
        }
        gear[n] = arr;
    }

    static class Cmd{
        int num;
        int dir;

        Cmd(int n, int d){
            this.num = n;
            this.dir = d;
        }
    }
}
