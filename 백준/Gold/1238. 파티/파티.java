import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static boolean[] visited;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NMX = br.readLine().split(" ");
		N = Integer.parseInt(NMX[0]);
		int M = Integer.parseInt(NMX[1]);
		int X = Integer.parseInt(NMX[2]);

		ArrayList<Node>[] graph = new ArrayList[N+1];	// 인접리스트로 그래프 구현
		int[][] DP = new int[N+1][N+1];
		visited = new boolean[N+1];

		for(int i = 1 ; i <= N ; i++){
			graph[i] = new ArrayList<>();
			for(int j = 1 ; j <= N ; j++){
				if(i != j){
					DP[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		for(int i = 0 ; i < M ; i++){
			String[] SET = br.readLine().split(" ");
			int start = Integer.parseInt(SET[0]);
			int end = Integer.parseInt(SET[1]);
			int time = Integer.parseInt(SET[2]);

			graph[start].add(new Node(end, time));
		}

		// start번째 노드에서 모든 노드까지의 최단거리 구하기
		for(int start = 1 ; start <= N ; start++){
			for(int i = 0 ; i < N ; i++){
				//DP[i]에서 가장 거리 짧은 노드를 현재 노드로
				int now = minDistanceIdx(DP[start]);
				visited[now] = true;

				//현재 노드의 인접노드에 대해 갱신
				for(Node node : graph[now]){
					int next = node.to;
					int time = node.time;
					DP[start][next] = Math.min(DP[start][next], DP[start][now] + time);
				}
			}
			// 방문노드 초기화
			for(int n = 1 ; n <= N ; n++){
				visited[n] = false;
			}
		}

		int MAX = -1;
		for(int n = 1 ; n <= N ; n++){
			int dis = DP[n][X] + DP[X][n];
			MAX = Math.max(MAX, dis);
		}

		System.out.println(MAX);
	}

	private static int minDistanceIdx(int[] arr) {
		int min = Integer.MAX_VALUE;
		int min_idx = -1;

		for(int i = 1 ; i <= N ; i++){
			if(arr[i] < min && !visited[i]){
				min = arr[i];
				min_idx = i;
			}
		}
		return min_idx;
	}

	static class Node{
		int to;
		int time;
		Node(int to, int time){
			this.to = to;
			this.time = time;
		}
	}
}
