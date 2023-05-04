import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int total;
	static int N;
	static boolean[] visited;
	static int[] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		board = new int[N+1];

		func(1);
		System.out.println(total);
	}

	private static void func(int cnt) {
		if(cnt == N+1){
			total++;
			return;
		}

		for(int c = 1 ; c <= N ; c++){
			if(!visited[c]){
				if(isPossible(cnt, c)){
					visited[c] = true;
					board[cnt] = c;
					func(cnt+1);
					visited[c] = false;
				}
			}
		}
	}

	private static boolean isPossible(int idx, int val) {
		for(int i = 1 ; i < idx ; i++){
			if(Math.abs(i - idx) == Math.abs(board[i] - val)) return false;
		}
		return true;
	}
}
