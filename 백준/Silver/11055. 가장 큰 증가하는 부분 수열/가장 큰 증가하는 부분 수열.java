import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		int MAX = -1;

		String[] nums = br.readLine().split(" ");
		for(int i = 1 ; i <= N ; i++){
			arr[i] = Integer.parseInt(nums[i-1]);
		}

		for(int i = 1 ; i <= N ; i++){
			for(int j = 0 ; j < i ; j++){
				if(arr[j] < arr[i]){
					dp[i] = Math.max((dp[j] + arr[i]), dp[i]);
					MAX = Math.max(MAX, dp[i]);
				}
			}
		}
		System.out.println(MAX);
	}
}
