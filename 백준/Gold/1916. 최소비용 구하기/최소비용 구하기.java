import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M;
	static final int INF = Integer.MAX_VALUE;
	static int[] distance;
	static boolean[] visited;
	static Queue<Node> q;
	static HashMap<Integer, ArrayList<Node>> map;
	// map에 키 값으로 이미 출발 정점을 알고 있기 때문에
	// Node가 갖고 있어야 할 정보는 이 간선이 나아가는 다음 정점의 번호, 그 간선의 가중치
	static class Node{
		int to, cost;
		public Node(int to, int cost){
			this.to = to;
			this.cost = cost;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		map = new HashMap<Integer, ArrayList<Node>>();
		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if(map.containsKey(from)){
				map.get(from).add(new Node(to, cost));
			}else {
				ArrayList<Node> nodes = new ArrayList();
				nodes.add(new Node(to, cost));
				map.put(from, nodes);
			}
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		// 입력 종료


		// 출발점부터 index 지점까지의 최단 거리를 기억하는 배열
		distance = new int[N + 1];
		visited = new boolean[N + 1];

		// 출발점으로부터 최단 거리만을 기억할 것이므로 Infinite 값으로 초기화
		Arrays.fill(distance, INF);
		// 출발점에서 출발점으로 향하는 거리는 0이므로 0으로 값 할당
		distance[start] = 0;

		q = new LinkedList<>();
		q.add(new Node(start, 0)); // 시작점, 시작점에서 시작점으로 가는 비용은 0

		while(!q.isEmpty()){
			// 일단 큐에서 꺼내면 현재 지점으로 판단
			Node now = q.poll();

			// 방문한 지점이라면 다시 방문하지 않음
			if(visited[now.to]) continue;

			// 현재 지점 방문 처리
			visited[now.to] = true;
			// 현재 지점과 인접한 노드가 존재한다면
			if(map.get(now.to) != null){
				// now.to : 현재 노드의 정점(즉 다음 노드를 기준으로 한다면 출발점)
				// next : 현재(now) 간선이 연결되어 있는 다음 정점
				for(Node next: map.get(now.to)){
					// 만약 현재 정점까지의 최단거리 + 현재 정점으로부터 이어져있는 간선의 목적지까지의 비용 < 기억되고 있는 목적지까지의 최단거리
					if(distance[now.to] + next.cost < distance[next.to]){
						// 라면 목적지까지의 최단거리 갱신
						distance[next.to] = distance[now.to] + next.cost;
					}
				}
			}
			// 다음 최단거리 노드 찾기
			nextNode();
		}
		System.out.println(distance[end]);
	}

	private static void nextNode() {
		int min = INF;
		int next = -1;

		for(int i = 1; i <= N; i++){
			if(!visited[i] && distance[i] < min){
				next = i;
				min = distance[i];
			}
		}
		if(next > 0) q.add(new Node(next, min));
	}
}
