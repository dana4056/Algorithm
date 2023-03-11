import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, M;
	static int[] nums;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		nums = new int[M+1];

		comb(1, 0);

		System.out.println(sb);

	}

	private static void comb(int idx, int cnt) {
		nums[cnt] = idx;
		if(cnt == M){
			for(int i = 1 ; i <= M ; i++) {
				sb.append(nums[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		// nums[cnt] = idx;

		for(int i = idx ; i <= N ; i++){
			comb(i, cnt+1);
		}
	}
}
