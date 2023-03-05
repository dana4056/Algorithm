import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int INF = Integer.MAX_VALUE;
    static int[] DP;
    static boolean[] visited;
    static int V;
    static PriorityQueue<Node> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] VE = br.readLine().split(" ");
        V = Integer.parseInt(VE[0]);                    // 정점수
        int E = Integer.parseInt(VE[1]);                // 간선수
        int start = Integer.parseInt(br.readLine());    // 시작노드

        ArrayList<Node>[] nodes = new ArrayList[V+1];   // 인접리스트
        DP = new int[V+1];                              // 시작노드에서 모든 노드까지 걸리는 거리
        visited = new boolean[V+1];                     // 방문 여부 확인
        Arrays.fill(DP, INF);

        pq = new PriorityQueue<Node>();
        DP[start] = 0;

        for(int i = 0 ; i < V+1 ; i++){
            // 인접리스트 초기화
            nodes[i] = new ArrayList<Node>();
        }


        for(int i = 0 ; i < E ; i++){
            String[] uvw = br.readLine().split(" ");
            int u = Integer.parseInt(uvw[0]);               // 출발노드
            int v = Integer.parseInt(uvw[1]);               // 도착노드
            int w = Integer.parseInt(uvw[2]);               // 가중치(비용)

            nodes[u].add(new Node(v, w));
        }

        // 다익스트라
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            int now = pq.poll().to;

            if(visited[now]) continue;
            visited[now] = true;

            for(Node node : nodes[now]){
                if(DP[now] + node.weight < DP[node.to]){
                    DP[node.to] = DP[now] + node.weight;
                    pq.offer(new Node(node.to, DP[node.to]));
                }
            }
        }

        // 정답 출력
        for(int i = 1 ; i <= V ; i++){
            sb.append(DP[i] == INF ? "INF" : DP[i]).append("\n");
        }
        System.out.println(sb);
    }

}

class Node implements Comparable<Node>{
    int to;
    int weight;

    public Node(int t, int w) {
        to = t;
        weight = w;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}