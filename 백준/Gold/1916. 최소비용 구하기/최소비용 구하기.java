import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    static int start, end;
    static int N, M;
    static int[] dp;
    static boolean[] visited;
    static Map<Integer, ArrayList<Node>> map = new HashMap<Integer, ArrayList<Node>>();
    static Queue<Integer> q = new LinkedList<>();
    static class Node {
        int start;
        int end;
        int cost;

        public Node(int s, int e, int c){
            start = s;
            end = e;
            cost = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dp = new int[N+1];
        visited = new boolean[N+1];
/****************************************/
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 입력
        for(int i = 0 ; i < M ; i++){
            String[] sec = br.readLine().split(" ");
            int s = Integer.parseInt(sec[0]);
            int e = Integer.parseInt(sec[1]);
            int c = Integer.parseInt(sec[2]);

            Node node = new Node(s, e, c);

            if(map.containsKey(s)){
                map.get(s).add(node);
            }else {
                ArrayList<Node> nodes = new ArrayList<Node>();
                nodes.add(node);
                map.put(s, nodes);
            }
        }

        String[] se = br.readLine().split(" ");
        start = Integer.parseInt(se[0]);
        end = Integer.parseInt(se[1]);

        dp[start] = 0;

        // 큐에 다음 노드 넣기
        q.add(start);

        while(!q.isEmpty()){
            updateDP(q.poll());
        }
        System.out.println(dp[end]);
    }

    private static void updateDP(int now) {
/******************************************/
        if(visited[now]) return;
        visited[now] = true;

        ArrayList<Node> nodes = map.get(now);

        if(nodes != null){
            for(Node node: nodes){
                if(node.end == start) continue;

                if(dp[now] + node.cost < dp[node.end]){
                    dp[node.end] = dp[now] + node.cost;
                }
            }
        }
        nextNode();
    }

    // 방문하지 않은 노드 중에서 가장 적은 비용의 노드 선택
    private static void nextNode() {
        int min = Integer.MAX_VALUE;
        int next = -1;

        for(int i = 1 ; i <= N ; i++){
            if(!visited[i] && dp[i] < min){
                min = dp[i];
                next = i;
            }
        }
        if(next > 0) q.add(next);
    }
}
