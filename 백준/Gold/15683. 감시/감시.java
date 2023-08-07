import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int N, M, C, wall;
    static int MIN = Integer.MAX_VALUE;
    static char[][] origin;
    static char[][] copy;
    static int[] selDir = new int[8];
    static int[][] cam = new int[8][3];
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static ArrayList<Integer>[][] dirList = new ArrayList[6][4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        initialDir();
        
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        origin = new char[N][M];
        copy = new char[N][M];

        for(int i = 0 ; i < N ; i++){
            String line = br.readLine();
            for(int j = 0 ; j < M ; j++){
                char ch = line.charAt(j*2);
                origin[i][j] = ch;
                copy[i][j] = ch;
                if(ch != '0' && ch != '6'){
                    cam[C][0] = ch - 48;
                    cam[C][1] = i;
                    cam[C][2] = j;
                    C++;
                }else if(ch == '6'){
                    wall++;
                }
            }
        }
        selecCCTV(0);
        System.out.println(MIN);
    }

    private static void selecCCTV(int cnt) {
        if(cnt == C){
            MIN = Math.min(MIN, calArea());
            return;
        }

        int camNo = cam[cnt][0];
        switch (camNo){
            case 1:
            case 3:
            case 4:
                for(int i = 0 ; i < 4 ; i++){
                    selDir[cnt] = i;
                    selecCCTV(cnt + 1);
                }
                break;
            case 2:
                for(int i = 0 ; i < 2 ; i++){
                    selDir[cnt] = i;
                    selecCCTV(cnt + 1);
                }
                break;
            case 5:
                selDir[cnt] = 0;
                selecCCTV(cnt + 1);
                break;
        }
    }

    private static int calArea() {
        int area = (N * M) - wall - C;

        for(int i = 0 ; i < C ; i++){
            int camNo = cam[i][0];
            int dir = selDir[i];

            for(int d : dirList[camNo][dir]){
                int r = cam[i][1] + dr[d];
                int c = cam[i][2] + dc[d];
                while(r >= 0 && r < N && c >= 0 && c < M){
                    if(copy[r][c] == '6'){
                        break;
                    }else if(copy[r][c] == '0'){
                        copy[r][c] = '#';
                        area--;
                    }
                    r += dr[d];
                    c += dc[d];
                }
            }
        }

        // 복사본 원상복구
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                copy[i][j] = origin[i][j];
            }
        }

        return area;
    }

    private static void initialDir() {
        dirList[1][0] = new ArrayList<>(Arrays.asList(3));
        dirList[1][1] = new ArrayList<>(Arrays.asList(1));
        dirList[1][2] = new ArrayList<>(Arrays.asList(2));
        dirList[1][3] = new ArrayList<>(Arrays.asList(0));
        dirList[2][0] = new ArrayList<>(Arrays.asList(2,3));
        dirList[2][1] = new ArrayList<>(Arrays.asList(0,1));
        dirList[3][0] = new ArrayList<>(Arrays.asList(0,3));
        dirList[3][1] = new ArrayList<>(Arrays.asList(1,3));
        dirList[3][2] = new ArrayList<>(Arrays.asList(2,1));
        dirList[3][3] = new ArrayList<>(Arrays.asList(0,2));
        dirList[4][0] = new ArrayList<>(Arrays.asList(0,2,3));
        dirList[4][1] = new ArrayList<>(Arrays.asList(0,1,3));
        dirList[4][2] = new ArrayList<>(Arrays.asList(1,2,3));
        dirList[4][3] = new ArrayList<>(Arrays.asList(0,1,2));
        dirList[5][0] = new ArrayList<>(Arrays.asList(0,1,2,3));
    }
}
