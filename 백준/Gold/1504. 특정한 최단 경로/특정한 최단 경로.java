import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static boolean[] visited;
    static int[][] dist;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NE = br.readLine().split(" ");
        N = Integer.parseInt(NE[0]);
        int E = Integer.parseInt(NE[1]);
        int INF = Integer.MAX_VALUE;

        ArrayList<Node>[] graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        dist = new int[N+1][N+1];

        for(int i = 1 ; i <= N ; i++){
            graph[i] = new ArrayList<>();

            for(int j = 1 ; j <= N ; j++){
                if(i == j) continue;
                dist[i][j] = INF;
            }
        }

        for(int i = 0 ; i < E ; i++){
            String[] SEV = br.readLine().split(" ");
            int start = Integer.parseInt(SEV[0]);
            int end = Integer.parseInt(SEV[1]);
            int value = Integer.parseInt(SEV[2]);

            graph[start].add(new Node(end, value));
            graph[end].add(new Node(start, value));
        }

        String[] V1V2 = br.readLine().split(" ");
        int V1 = Integer.parseInt(V1V2[0]);
        int V2 = Integer.parseInt(V1V2[1]);

        int[] startNodes = {1,V1,V2,N};

        for(int i : startNodes){
            for(int n = 1 ; n <= N ; n++){
                int now = nextNode(i);
                if(now == 0){
                    break;
                }
                visited[now] = true;
                if(graph[now].size() > 0){
                    for(Node next : graph[now]){
                        int to = next.to;
                        int val = next.value;

                        if(!visited[to]){
                            dist[i][to] = Math.min(dist[i][to], dist[i][now] + val);
                        }
                    }
                }
            }

            for(int n = 1 ; n <= N ; n++){
                visited[n] = false;
            }
        }

        int ans1 = INF, ans2 = INF;
        if(dist[1][V1] != INF && dist[V1][V2] != INF && dist[V2][N] != INF){
            ans1 = dist[1][V1]+dist[V1][V2]+dist[V2][N];
        }
        if(dist[1][V2] != INF && dist[V2][V1] != INF && dist[V1][N] != INF){
            ans2 = dist[1][V2]+dist[V2][V1]+dist[V1][N];
        }

        if(ans1 == INF && ans2 == INF){
            System.out.println(-1);
        }else{
            System.out.println(Math.min(ans1, ans2));
        }
    }

    private static int nextNode(int i) {
        int MAX = Integer.MAX_VALUE;
        int idx = 0;

        for(int j = 1 ; j <= N ; j++){
            if(!visited[j] && dist[i][j] < MAX){
                MAX = dist[i][j];
                idx = j;
            }
        }
        return idx;
    }

    static class Node{
        int to;
        int value;

        Node(int t, int v){
            this.to = t;
            this.value = v;
        }
    }
}
