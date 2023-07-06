import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, MAX;
    static int[][] origin, copy;
    static int[] select = new int[5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        origin = new int[N][N];
        copy = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            String[] line = br.readLine().split(" ");
            for (int j = 0 ;j < N ; j++){
                origin[i][j] = Integer.parseInt(line[j]);
                MAX = Math.max(MAX, origin[i][j]);
            }
        }

        perm(0);
        System.out.println(MAX);
    }
    static void perm(int cnt){
        if(cnt == 5){
            copyArr(origin, copy);
            for(int i = 0 ; i < 5 ; i++){
                setDirection(select[i]);
            }
            return;
        }

        for(int i = 0 ; i < 4 ; i++){
            select[cnt] = i;
            perm(cnt+1);
        }
    }
    static void setDirection(int dir){
        switch(dir){
            case 0: //상
                moveBlock(0,0,1,1, 'C');
                break;
            case 1: //하
                moveBlock(N-1,0,-1,1, 'C');
                break;
            case 2: //좌
                moveBlock(0,0,1,1, 'R');
                break;
            case 3: //우
                moveBlock(0, N-1,1,-1, 'R');
                break;
        }
    }

    private static void moveBlock(int r, int c, int dr, int dc, char ch) {
        int row = r;
        int col = c;
        int[][] copy2 = new int[N][N];

        if(ch == 'R'){
            row = r;
            for(int i = 0 ; i < N ; i++){
                col = c;

                //0제거
                for(int j = 0; j < N ; j++){
                    if(copy[row][col] == 0){
                        int nc = col+dc;
                        while (nc < N && nc >= 0 && copy[row][nc] == 0){
                            nc += dc;
                        }
                        if(nc < N && nc >= 0){
                            copy[row][col] = copy[row][nc];
                            copy[row][nc] = 0;
                        }
                    }
                    col += dc;
                }

                col = c;
                int idx = c;
                for(int j = 0 ; j < N ; j++){
                    if(copy[row][col] != 0){
                        if(col+dc < N && col+dc >= 0 && copy[row][col] == copy[row][col+dc]){
                            copy2[row][idx] = copy[row][col] * 2;
                            MAX = Math.max(MAX, copy2[row][idx]);
                            copy[row][col+dc] = 0;
                        }else{
                            copy2[row][idx] = copy[row][col];
                        }
                        idx+=dc;
                    }
                    col += dc;
                }
                row += dr;
            }

        }else if(ch == 'C'){
            col = c;
            for(int i = 0 ; i < N ; i++){
                row = r;

                //0제거
                for(int j = 0; j < N ; j++){
                    if(copy[row][col] == 0){
                        int nr = row + dr;
                        while (nr < N && nr >= 0 && copy[nr][col] == 0){
                            nr += dr;
                        }
                        if(nr < N && nr >= 0){
                            copy[row][col] = copy[nr][col];
                            copy[nr][col] = 0;
                        }
                    }
                    row += dr;
                }


                row = r;
                int idx = r;
                for(int j = 0 ; j < N ; j++){
                    if(copy[row][col] != 0){
                        if(row+dr < N && row+dr >= 0 && copy[row][col] == copy[row+dr][col]){
                            copy2[idx][col] = copy[row][col] * 2;
                            MAX = Math.max(MAX, copy2[idx][col]);
                            copy[row+dr][col] = 0;
                        }else{
                            copy2[idx][col] = copy[row][col];
                        }
                        idx += dr;
                    }
                    row += dr;
                }
                col += dc;
            }
        }
        copyArr(copy2, copy);
    }

    static void copyArr(int[][] arr1, int[][] arr2){

        for(int i = 0 ; i < N ; i++){
            arr2[i] = arr1[i].clone();
        }
    }
}
