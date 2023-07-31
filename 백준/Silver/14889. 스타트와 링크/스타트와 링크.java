import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, linkSum, startSum;
    static int[][] arr;
    static int[] startTeam;
    static boolean[] selected;
    static int[] linkTeam;
    static int[] pair= new int[2];
    static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j++){
                arr[i][j] =  Integer.parseInt(line[j]);
            }
        }

        selected = new boolean[N];
        startTeam = new int[N/2];
        linkTeam = new int[N/2];

        comb(0, 0);
        System.out.println(MIN);
    }

    private static void comb(int cnt, int start) {
        if(cnt == N/2){
            pairComb(0, 0, 'S');

            int idx = 0;
            for(int i = 0 ; i < N ; i++){
                if(!selected[i]){
                    linkTeam[idx++] = i;
                }
            }
            pairComb(0, 0, 'L');

            MIN = Math.min(MIN, Math.abs(startSum - linkSum));
            linkSum = startSum = 0;
            return;
        }

        for(int i = start ; i < N ; i++){
            startTeam[cnt] = i;
            selected[i] = true;
            comb(cnt+1, i+1);
            selected[i] = false;
        }
    }

    private static void pairComb(int cnt, int start, char team) {
        if(cnt == 2){
            if(team == 'S'){
                startSum += arr[pair[0]][pair[1]] + arr[pair[1]][pair[0]];
            }else{
                linkSum += arr[pair[0]][pair[1]] + arr[pair[1]][pair[0]];
            }
            return;
        }

        for(int i = start ; i < N/2 ; i++){
            if(team == 'S'){
                pair[cnt] = startTeam[i];
                pairComb(cnt+1, i+1, 'S');
            }else{
                pair[cnt] = linkTeam[i];
                pairComb(cnt+1, i+1, 'L');
            }
        }
    }
}
