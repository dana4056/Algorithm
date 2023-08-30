import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, end;
    static ArrayList<Integer>[] graph;
    static int[] times;
    static int[] indegree;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < T ; tc++){
            String[] NM = br.readLine().split(" ");
            N = Integer.parseInt(NM[0]);
            int M = Integer.parseInt(NM[1]);

            times = new int[N+1];
            dp = new int[N+1];
            graph = new ArrayList[N+1];

            String[] line = br.readLine().split(" ");
            for(int i = 1 ; i <= N ; i++){
                times[i] = Integer.parseInt(line[i-1]);
                graph[i] = new ArrayList<>();
            }

            indegree = new int[N + 1];
            for(int i = 0 ; i < M ; i++){
                String[] FT = br.readLine().split(" ");
                int from = Integer.parseInt(FT[0]);
                int to = Integer.parseInt(FT[1]);

                graph[from].add(to);
                indegree[to]++;
            }

            end = Integer.parseInt(br.readLine());

            dp = new int[N + 1];
            topologySort();
            sb.append(dp[end]).append("\n");
        }
        System.out.print(sb);
    }

    public static void topologySort() {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                dp[i] = times[i];
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int current = q.poll();

            for(int i = 0; i < graph[current].size(); i++) {
                int next = graph[current].get(i);
                dp[next] = Math.max(dp[current] + times[next], dp[next]);
                indegree[next]--;
                if(indegree[next] == 0) q.offer(next);
            }
        }
    }
}
