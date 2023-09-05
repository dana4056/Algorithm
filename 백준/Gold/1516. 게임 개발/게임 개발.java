import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] inDegree = new int[N+1];
        int[] times = new int[N+1];
        int[] costs = new int[N+1];
        ArrayList<Integer>[] graph = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 1 ; i <= N ; i++){
            String[] line = br.readLine().split(" ");
            times[i] = Integer.parseInt(line[0]);

            int idx = 1, n = Integer.parseInt(line[idx]);
            while(n > 0){
                graph[n].add(i);
                inDegree[i] += 1;
                n = Integer.parseInt(line[++idx]);
            }
        }

        Queue<Building> q = new LinkedList<>();
        for(int i = 1 ; i <= N ; i++){
            if(inDegree[i] == 0) {
                q.add(new Building(i, times[i]));
                inDegree[i] = -1;    //방문처리
                costs[i] = times[i];
            }
        }

        while(!q.isEmpty()){
            Building now = q.poll();

            for(int adj : graph[now.node]){
                inDegree[adj] -= 1;
                costs[adj] = Math.max(costs[adj], now.time + times[adj]);

                if(inDegree[adj] == 0){
                    inDegree[adj] = -1;
                    q.add(new Building(adj, costs[adj]));
                }
            }
        }

        for(int i = 1 ; i <= N ; i++){
            sb.append(costs[i]).append("\n");
        }

        System.out.print(sb);
    }

    static class Building{
        int node;
        int time;

        Building(int n, int t){
            this.node = n;
            this.time = t;
        }
    }
}
