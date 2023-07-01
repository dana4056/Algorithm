import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static long INF = 10000000000L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        long[] dis = new long[N+1];
        int[] route = new int[N+1];
        ArrayList<Node>[] graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++){
            graph[i] = new ArrayList<>();
            if(i != 1){
                dis[i] = -INF;
            }
        }


        for (int i = 0 ; i < M ; i++){
            String[] UVW = br.readLine().split(" ");
            int from = Integer.parseInt(UVW[0]);
            int to = Integer.parseInt(UVW[1]);
            int time = Integer.parseInt(UVW[2]);

            graph[from].add(new Node(to, time));
        }


        // 도착지까지 연결되어있지 않을 경우
        boolean[] checked = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        checked[1] = true;
        q.add(1);
        while(!q.isEmpty()){
            int now = q.poll();

            for(Node next : graph[now]){
                if(!checked[next.to]){
                    checked[next.to] = true;
                    q.add(next.to);
                }
            }
        }
        if(!checked[N]){
            System.out.println(-1);
            return;
        }

        for(int i = 1 ; i <= N ; i++){
            for(int now = 1 ; now <= N ; now++){
                if(dis[now] == -INF) continue;
                for(Node next : graph[now]){
                    if(dis[next.to] < dis[now] + next.time){
                        dis[next.to] = dis[now] + next.time;
                        route[next.to] = now;

                        if(i == N){
                            dis[next.to] = INF;
                        }
                    }
                }
            }
        }

        if(dis[N] == INF ){
            System.out.println(-1);
        }else{
            Stack<Integer> stack = new Stack<>();
            int now = N;
            while (now != 0) {
                stack.push(now);
                now = route[now];
            }
            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
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
