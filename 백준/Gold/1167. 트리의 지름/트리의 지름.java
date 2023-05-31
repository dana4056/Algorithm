import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static ArrayList<Vertex>[] tree;
	static int diameter, startV;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int V = Integer.parseInt(br.readLine());
		tree = new ArrayList[V+1];
		visited = new boolean[V+1];
		ArrayList<Integer> leaves = new ArrayList<>();

		for(int i = 1 ; i <= V ; i++){
			tree[i] = new ArrayList<>();
		}

		for(int i = 1 ; i <= V ; i++){
			String eInfo = br.readLine();

			String[] infos = eInfo.split(" ");
			int from = Integer.parseInt(infos[0]);
			int nowIdx = 1;

			while(Integer.parseInt(infos[nowIdx]) != -1) {
				int to = Integer.parseInt(infos[nowIdx++]);
				int val = Integer.parseInt(infos[nowIdx++]);

				tree[from].add(new Vertex(to, val));
			}
		}

		
		visited[1] = true;
		DFS(1, 0);
		visited[1] = false;

		diameter = 0;
		visited[startV] = true;
		DFS(startV, 0);

		System.out.println(diameter);

	}

	private static void DFS(int now, int sum) {
		if(tree[now].size() == 1 && visited[tree[now].get(0).to]){
			if(sum > diameter){
				diameter = sum;
				startV = now;
			}
			return;
		}

		for(Vertex v : tree[now]){
			int next = v.to;
			if(!visited[next]){
				visited[next] = true;
				DFS(next, sum + v.val);
				visited[next] = false;
			}
		}
	}

	static class Vertex{
		int to;
		int val;

		Vertex(int t, int v){
			this.to = t;
			this.val = v;
		}
	}
}
