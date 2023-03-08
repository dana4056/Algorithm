import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static ArrayList<Integer>[] nodes;
	static int N;
	static int[] parents;
	static boolean[] visted;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		nodes = new ArrayList[N+1];
		parents = new int[N+1];
		visted = new boolean[N+1];

		for(int i = 1 ; i <= N ; i++){
			nodes[i] = new ArrayList();
		}

		for(int i = 0 ; i < N-1 ; i++){
			String[] temp = br.readLine().split(" ");
			int node1 = Integer.parseInt(temp[0]);
			int node2 = Integer.parseInt(temp[1]);

			nodes[node1].add(node2);
			nodes[node2].add(node1);
		}

		dfs(1);

		for(int i = 2 ; i <= N ; i++){
			sb.append(parents[i]).append("\n");
		}
		System.out.print(sb);
	}

	static void dfs(int node){

		visted[node] = true;

		for(Integer n: nodes[node]){
			if(!visted[n]){
				parents[n] = node;
				dfs(n);
			}
		}
	}
}
