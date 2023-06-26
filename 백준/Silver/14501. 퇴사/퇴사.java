import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static int N, MAX;
	static List<Consulting> arr = new ArrayList<>();
	static boolean[] visited;
	static boolean[] selected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		selected = new boolean[N];

		for(int i = 0 ; i < N ;i++){
			String[] TP = br.readLine().split(" ");
			int T = Integer.parseInt(TP[0]);
			int P = Integer.parseInt(TP[1]);

			arr.add(new Consulting(T, P));
		}

		subset(0);
		System.out.println(MAX);
	}

	private static void subset(int cnt) {
		if(cnt == N){
			int sum = 0;
			boolean done = false;
			for(int i = 0 ; i < N ; i++){
				if(selected[i]){
					Consulting con = arr.get(i);
					for(int j = i ; j < i + con.time ; j++){
						if(j >= N || visited[j]) {
							done = true;
							break;
						}
						visited[j] = true;
					}
					if(done) break;
					else sum += con.pay;
				}
			}
			if(!done){
				MAX = Math.max(MAX, sum);
			}
			Arrays.fill(visited, false);
			return;
		}

		selected[cnt] = true;
		subset(cnt+1);

		selected[cnt] = false;
		subset(cnt+1);

	}

	static class Consulting {
		int time;
		int pay;

		Consulting(int t, int p){
			this.time = t;
			this.pay = p;
		}
	}
}
