import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dis;
    static boolean[] visited;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < TC ; tc++){
            String[] ndc = br.readLine().split(" ");
            n = Integer.parseInt(ndc[0]);       // 컴퓨터 개수   (정점)
            int d = Integer.parseInt(ndc[1]);   // 의존관계 개수 (간선)
            int c = Integer.parseInt(ndc[2]);   // 감염 컴퓨터 번호

            dis = new int[n+1];                 // 다익스트라 거리 테이블
            visited = new boolean[n+1];

            // 인접리스트 선언 및 초기화
            ArrayList<Com>[] graph = new ArrayList[n+1];
            for(int i = 0 ; i <= n ; i++){
                graph[i] = new ArrayList<Com>();

                // 거리배열 초기화
                if(i != c){
                    dis[i] = Integer.MAX_VALUE;
                }
            }

            for (int i = 0 ; i < d ; i++){
                String[] abs = br.readLine().split(" ");
                int to = Integer.parseInt(abs[0]);
                int from = Integer.parseInt(abs[1]);
                int time = Integer.parseInt(abs[2]);

                graph[from].add(new Com(to, time));
            }

            Queue<Integer> q = new LinkedList<>();
            visited[c] = true;
            q.add(c);
            
            // 거리배열 업데이트
            while (!q.isEmpty()){
                int now = q.poll();

                for(Com com : graph[now]){
                    int to = com.to;
                    int time = com.time;

                    dis[to] = Math.min(dis[to], dis[now] + time);
                }
                int next = minDistance();
                if(next != -1){
                    visited[next] = true;
                    q.add(next);
                }
            }
            
            int cnt = 0, max = Integer.MIN_VALUE;
            for(int i = 1 ; i <= n ; i++){
                if(dis[i] != Integer.MAX_VALUE){
                    cnt++;
                    max = Math.max(max, dis[i]);
                }
            }
            sb.append(cnt).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }

    private static int minDistance() {
        int idx = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i <= n ; i++){
            if(!visited[i] && dis[i] < min){
                min = dis[i];
                idx = i;
            }
        }
        return idx;
    }

    static class Com {
        int to;
        int time;

        Com(int to, int time){
            this.to = to;
            this.time = time;
        }
    }
}
