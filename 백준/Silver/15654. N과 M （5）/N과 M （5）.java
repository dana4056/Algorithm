import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, M;
	static int[] nums;
	static int[] select;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NM = br.readLine().split(" ");
		String[] nums_temp = br.readLine().split(" ");

		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		nums = new int[N];			// 고를 숫자 리스트
		select = new int[M];		// 고른 숫자 리스트
		visited = new boolean[N];	// 해당 숫자 골랐는지
		for(int i = 0 ; i < N ; i++){
			nums[i] = Integer.parseInt(nums_temp[i]);
		}
		Arrays.sort(nums);		// 오름차순으로 정렬

		perm(0);

		System.out.println(sb);
	}

	private static void perm(int cnt) {

		if(cnt == M){
			for(int i = 0 ; i < M ; i++) {
				sb.append(select[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for(int i = 0 ; i < N ; i++){
			if(!visited[i]){
				select[cnt] = nums[i];
				visited[i] = true;

				perm(cnt+1);
				visited[i] = false;
			}
		}
	}
}
