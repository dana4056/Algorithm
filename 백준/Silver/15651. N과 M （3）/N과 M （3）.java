import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//중복순열
public class Main {
    static int[] nums;
    static int N, M, total;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        nums = new int[M];

        perm2(0);
        System.out.print(sb);
    }

    private static void perm2(int cnt){
        if(cnt == M){
            for(int i = 0 ; i < M ; i++){
                sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1 ; i <= N ; i++){
            nums[cnt] = i;
            perm2(cnt+1);
        }
    }
}
