import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int MAX = -1;
		int[] arr = new int[N];
		int[] dp1 = new int[N];
		int[] dp2 = new int[N];

		String[] line = br.readLine().split(" ");
		for(int i = 0 ; i < N ; i++){
			arr[i] = Integer.parseInt(line[i]);
			dp1[i] = 1;
			dp2[i] = 1;
		}

		for(int i = 0 ; i < N ; i++){
			for(int j = 0 ; j < i ; j++){
				if(arr[j] < arr[i] && dp1[j] + 1 > dp1[i]){
					dp1[i] = dp1[j] + 1;
				}
			}

			for(int j = N-1 ; j > (N-1) - i ; j--){
				if(arr[j] < arr[(N-1) - i] && dp2[j] + 1 > dp2[(N-1) - i]){
					dp2[(N-1) - i] = dp2[j] + 1;
				}
			}
		}

		for(int i = 0 ; i < N ; i++){
			MAX = Math.max(MAX, dp1[i]+dp2[i]-1);
		}

		System.out.println(MAX);

	}
}
