import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		ArrayList<Integer>[] graph = new ArrayList[N+1];
		for(int i = 1 ; i <= N ; i++){
			graph[i] = new ArrayList<>();
		}

		int[] indegree = new int[N+1];
		for(int i = 0 ; i < M ; i++){
			String[] line = br.readLine().split(" ");
			for(int j = 1 ; j < Integer.parseInt(line[0]) ; j++){
				int from = Integer.parseInt(line[j]);
				int to = Integer.parseInt(line[j+1]);

				graph[from].add(to);
				indegree[to] += 1;
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for(int i = 1 ; i <= N ; i++){
			if(indegree[i] == 0){
				q.add(i);
			}
		}

		List<Integer> answer = new ArrayList<>();
		while (!q.isEmpty()){
			int now = q.poll();
			answer.add(now);

			for(int adj : graph[now]){
				indegree[adj] -= 1;
				if(indegree[adj] == 0) q.add(adj);
			}
		}

		StringBuilder sb = new StringBuilder();
		if(answer.size() == N){
			for(int a : answer){
				sb.append(a).append("\n");
			}
		}else{
			sb.append(0);
		}
		System.out.print(sb);
	}
}
