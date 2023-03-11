import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 순열
public class Main {
	static int N, M;
	static int[] nums;
	static int[] select;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static List<String> selectList = new ArrayList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NM = br.readLine().split(" ");
		String[] nums_temp = br.readLine().split(" ");

		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		nums = new int[N];			// 고를 숫자 리스트
		select = new int[M];		// 고른 숫자 리스트
		visited = new boolean[N];
		for(int i = 0 ; i < N ; i++){
			nums[i] = Integer.parseInt(nums_temp[i]);
		}
		Arrays.sort(nums);		// 오름차순으로 정렬

		perm(0);

		System.out.print(sb);
	}

	private static void perm(int cnt) {

		if(cnt == M){
			String str = Arrays.toString(select);
			if(!selectList.contains(str)){
				selectList.add(str);
				for(int j = 0 ; j < M ; j++){
					sb.append(select[j]).append(" ");
				}
				sb.append("\n");
			}
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
