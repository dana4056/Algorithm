import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//순열
public class Main {
    static boolean[] visited;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        visited = new boolean[N+1];
        nums = new int[M];

        perm(0);
        System.out.print(sb);
    }
    private static void perm(int cnt){
        if(cnt == M){
            for(int i = 0 ; i < M ; i++){
                sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1 ; i <= N ; i++){
            if(!visited[i]){
                visited[i] = true;
                nums[cnt] = i;
                perm(cnt+1);
                visited[i] = false;
            }
        }
    }
}
