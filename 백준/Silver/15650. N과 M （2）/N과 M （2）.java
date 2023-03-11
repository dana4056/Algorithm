import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		visited = new boolean[N+1];

		comb(0, 0);
		System.out.println(sb);

	}

	private static void comb(int idx, int cnt) {
		visited[idx] = true;

		if(cnt == M){
			for(int i = 1 ; i <= N ; i++) {
				if(visited[i]) {
					sb.append(i).append(" ");
				}
			}
			sb.append("\n");
			return;
		}

		for(int i = idx+1 ; i <= N ; i++){
			comb(i, cnt+1);
			visited[i] = false;
		}
	}
}
