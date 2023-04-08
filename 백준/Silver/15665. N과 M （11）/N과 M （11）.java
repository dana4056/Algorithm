import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[] nums, picks;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        nums = new int[N];
        picks = new int[M];
        sb = new StringBuilder();

        String[] tmp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(tmp[i]);
        }

        Arrays.sort(nums);
        perm(0);

        System.out.print(sb);
    }

    private static void perm(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(picks[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1; // 중복 방지를 위한 변수
        for (int i = 0; i < N; i++) {
            if (nums[i] != prev) {
                picks[cnt] = nums[i];
                prev = nums[i];
                perm(cnt + 1);
            }
        }
    }
}
