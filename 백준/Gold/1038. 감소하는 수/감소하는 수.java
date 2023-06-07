import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main{
	static int N;
	static List<Long> nums = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		if(N >= 1023){
			System.out.println(-1);
		}else{
			for(int i = 0 ; i < 10 ; i++){
				DFS(i,1);
			}
			Collections.sort(nums);
			System.out.println(nums.get(N));
		}

	}
	private static void DFS(long num, int idx) {
		if (idx > 10)
			return;

		nums.add(num);
		for (int i = 0; i < num % 10; i++) {
			DFS((num * 10) + i, idx + 1);
		}

	}

}
