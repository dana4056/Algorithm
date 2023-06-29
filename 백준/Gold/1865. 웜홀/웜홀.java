import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < TC ; tc++) {
            String[] NMW = br.readLine().split(" ");
            int N = Integer.parseInt(NMW[0]);   // 지점
            int M = Integer.parseInt(NMW[1]);   // 도로
            int W = Integer.parseInt(NMW[2]);   // 웜홀
            int[] dis = new int[N+1];

            ArrayList<Node>[] graph = new ArrayList[N+1];
            for(int i = 0 ; i <= N ; i++){
                graph[i] = new ArrayList<>();
            }

            String[] SET = null;
            for(int i = 0 ; i < M ; i++){
                SET = br.readLine().split(" ");
                int start = Integer.parseInt(SET[0]);
                int end = Integer.parseInt(SET[1]);
                int time = Integer.parseInt(SET[2]);

                graph[start].add(new Node(end, time));
                graph[end].add(new Node(start, time));
            }

            for(int i = 0 ; i < W ; i++){
                SET = br.readLine().split(" ");
                int start = Integer.parseInt(SET[0]);
                int end = Integer.parseInt(SET[1]);
                int time = Integer.parseInt(SET[2]);

                graph[start].add(new Node(end, time * -1));
            }


            // 모든 정점 -> 시작 정점점
            boolean update = false;

            for(int i = 0 ; i < N ; i++){
                update = false;
                for(int now = 1 ; now <= N ;now++){
                    for(Node next : graph[now]){
                        if(dis[next.to] > dis[now] + next.time){
                            dis[next.to] = dis[now] + next.time;
                            update = true;
                        }
                    }
                }
                if(!update) break;
            }

            if(update){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }

        }
        System.out.print(sb);
    }

    static class Node {
        int to;
        int time;

        Node(int to, int time){
            this.to = to;
            this.time = time;
        }
    }
}
