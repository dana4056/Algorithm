import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] sticks = new int[N];
		int max = 0;
		int cnt = 0;

		for(int i = 0 ; i < N ; i++){
			int len = Integer.parseInt(br.readLine());
			sticks[i] = len;
		}

		for(int i = N-1 ; i >= 0 ; i--){
			if(sticks[i] > max){
				cnt++;
				max = sticks[i];
			}
		}
		System.out.println(cnt);
	}
}
