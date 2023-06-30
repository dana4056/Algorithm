import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static long INF = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        long[] dis = new long[N+1];
        ArrayList<Node>[] graph = new ArrayList[N+1];

        // 거리배열 및 그래프 초기화
        for(int i = 1 ; i <= N ; i++ ){
            graph[i] = new ArrayList<>();
            if(i != 1){
                dis[i] = INF;
            }
        }

        // 그래프 입력
        for(int i = 0; i < M ; i++){
            String[] ABC = br.readLine().split(" ");
            int from = Integer.parseInt(ABC[0]);
            int to = Integer.parseInt(ABC[1]);
            int time = Integer.parseInt(ABC[2]);

            graph[from].add(new Node(to, time));
        }

        // 벨만 포드
        boolean minusCycle = false;
        for(int i = 1 ; i <= N ; i++){
            boolean update = false;
            for(int now = 1 ; now <= N ; now++){
                for(Node next : graph[now]){
                    if(dis[now] != INF && dis[now] + next.time < dis[next.to]){
                        dis[next.to] = dis[now] + next.time;
                        update = true;
                    }
                    if(i == N && update) {
                        minusCycle = true;
                        sb.append(-1);
                        break;
                    }
                }
                if(minusCycle) {
                    break;
                }
            }
        }

        if(!minusCycle){
            for(int i = 2 ; i <= N ; i++){
                sb.append(dis[i] == INF ? -1 : dis[i]).append("\n");
            }
        }

        System.out.print(sb);
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
