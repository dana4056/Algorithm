import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, L, total;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NL = br.readLine().split(" ");
        N = Integer.parseInt(NL[0]);
        L = Integer.parseInt(NL[1]);
        arr = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j++){
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        arrSearch1();
        arrSearch3();

        System.out.println(total);

    }
    static void arrSearch1(){
        for(int i = 0 ; i < N ; i++){
            int cnt = 1;
            boolean possible = true;
            boolean decreaseMode = false;
            for(int j = 1 ; j< N ; j++){
                if(decreaseMode && cnt == L){
                    decreaseMode = false;
                    cnt = 0;
                }

                // 전 칸이랑 높이 같을 떄
                if(arr[i][j] == arr[i][j-1]){
                    cnt++;
                }
                // 전 칸보다 한 칸 클 떄
                else if(arr[i][j] == arr[i][j-1] + 1){
                    if(cnt >= L){
                        cnt = 1;
                    }else{
                         possible = false;
                         break;
                    }
                }
                // 전 칸보다 한 칸 작을 때
                else if(arr[i][j] == arr[i][j-1] - 1){
                    if(decreaseMode && cnt < L){
                        possible = false;
                        break;
                    }
                    decreaseMode = true;
                    cnt = 1;
                }
                else{
                    possible = false;
                    break;
                }
            }
            if(decreaseMode && cnt < L){
                possible = false;
            }
            if(possible){
                total++;
            }
        }
    }

    static void arrSearch3(){
        for(int i = 0 ; i < N ; i++){
            int cnt = 1;
            boolean possible = true;
            boolean decreaseMode = false;
            for(int j = 1 ; j < N ; j++){
                if(decreaseMode && cnt == L){
                    decreaseMode = false;
                    cnt = 0;
                }
                // 전 칸이랑 높이 같을 떄
                if(arr[j][i] == arr[j-1][i]){
                    cnt++;
                }
                // 전 칸보다 한 칸 클 때
                else if(arr[j][i] == arr[j-1][i] + 1){
                    if(cnt >= L){
                        cnt = 1;
                    }else{
                        possible = false;
                        break;
                    }
                }
                // 전 칸보다 한 칸 작을 때
                else if(arr[j][i] == arr[j-1][i] - 1){
                    if(decreaseMode && cnt < L){
                        possible = false;
                        break;
                    }
                    decreaseMode = true;
                    cnt = 1;
                }
                else{
                    possible = false;
                    break;
                }
            }
            if(decreaseMode && cnt < L){
                possible = false;
            }
            if(possible){
                total++;
            }
        }
    }
}
