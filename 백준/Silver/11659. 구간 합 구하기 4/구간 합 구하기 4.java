import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] str1 = in.readLine().split(" ");
		int N = Integer.parseInt(str1[0]);
		int M = Integer.parseInt(str1[1]);
		
		String[] str2 = in.readLine().split(" ");
		int[] nums = new int[N];
		for(int i = 0;i < N;i++) {
			nums[i] = Integer.parseInt(str2[i]);
		}
		
		
		int[] sums = new int[N];
		
		for(int i = 0 ;i < N; i++) {
			
			if(i == 0) sums[i] = nums[i];
			else {
				sums[i] = sums[i-1] + nums[i];				
			}
		}
		
		
		
		for(int i = 0 ;i < M; i++) {
			String[] str3 = in.readLine().split(" ");
			int sidx = Integer.parseInt(str3[0]);
			int eidx = Integer.parseInt(str3[1]);
			if(sidx == 1) {
				sb.append(sums[eidx-1]);
				sb.append("\n");
			}else {
				sb.append(sums[eidx-1] - sums[sidx-2]);
				sb.append("\n");			
			}
		}
		System.out.println(sb.toString());

	}

}
