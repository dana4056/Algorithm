import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//조합
public class Main {
    static int N, M;
    static int[] selected;
    static List<Integer> nums = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        selected = new int[M];

        String[] tmp = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++){
            nums.add(Integer.parseInt(tmp[i]));
        }
        //정렬
        Collections.sort(nums);

        comb(0,0);

        System.out.print(sb);
    }
    private static void comb(int start, int cnt){
        if(cnt == M){
            for(int i = 0 ; i < M ;i++){
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start ; i < nums.size() ; i++){
            selected[cnt] = nums.get(i);
            comb(i+1, cnt+1);
        }
    }
}
