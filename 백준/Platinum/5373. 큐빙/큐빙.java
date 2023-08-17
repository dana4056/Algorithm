import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int[][][] front = new int[6][3][3];
    static int[][] side = {{38,37,36,29,28,27,20,19,18,11,10,9},
                            {0,3,6,18,21,24,45,48,51,44,41,38},
                            {6,7,8,27,30,33,47,46,45,17,14,11},
                            {8,5,2,36,39,42,53,50,47,26,23,20},
                            {2,1,0,9,12,15,51,52,53,35,32,29},
                            {24,25,26,33,34,35,42,43,44,15,16,17}};
    static char[] arr = new char[54];
    static Map<Character, Integer> frontNum = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        frontNum.put('U', 0);
        frontNum.put('L', 1);
        frontNum.put('F', 2);
        frontNum.put('R', 3);
        frontNum.put('B', 4);
        frontNum.put('D', 5);

        for(int i = 0 ; i < 6 ; i++){
            int s = 0;
            for(int r = 0 ; r < 3 ; r++){
                for(int c = 0 ; c < 3 ; c++){
                    front[i][r][c] = 9 * i + s;
                    s++;
                }
            }
        }

        for(int tc = 0 ; tc < T ; tc++){
            int N = Integer.parseInt(br.readLine());
            String[] cmd = br.readLine().split(" ");

            initCube();

            for(int i = 0 ; i < N ; i++){
                turnCube(cmd[i]);
            }

            for(int i = 0 ; i < 3 ; i++){
                for(int j = 0 ; j < 3 ; j++){
                    sb.append(arr[i*3+j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);

    }

    private static void turnCube(String s) {
        int fn = frontNum.get(s.charAt(0)); // front number
        char dir = s.charAt(1);
        int cnt = dir == '+' ? 1 : 3;
        
        for(int n = 0 ; n < cnt ; n++){
            // 큐브 옆 면 회전
            char[] tmp = new char[3];
            for(int i = 11 ; i >= 0 ; i--){
                if(i >= 9) tmp[11-i] = arr[side[fn][i]];

                if(i > 2){
                    arr[side[fn][i]] = arr[side[fn][i-3]];
                }else{
                    arr[side[fn][i]] = tmp[2-i];
                }
            }

            // 큐브 정면 회전
            char[][] tmp2 = new char[3][3];
            for(int i = 0 ; i < 3 ; i++){
                for(int j = 0 ; j < 3 ; j++){
                    tmp2[j][2-i] = arr[front[fn][i][j]];
                }
            }
            for(int i = 0 ; i < 3 ; i++){
                for(int j = 0 ; j < 3 ; j++){
                    arr[front[fn][i][j]] = tmp2[i][j];
                }
            }
        }
    }

    private static void initCube() {
        for(int c = 0 ; c < 6 ; c++){
            char color = ' ';
            switch (c){
                case 0: color = 'w'; break;
                case 1: color = 'g'; break;
                case 2: color = 'r'; break;
                case 3: color = 'b'; break;
                case 4: color = 'o'; break;
                case 5: color = 'y'; break;
            }
            for(int i = 0; i < 9 ; i++){
                arr[9 * c + i] = color;
            }
        }
    }

}
