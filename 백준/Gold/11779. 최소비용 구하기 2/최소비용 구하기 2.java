import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main {
    static long INF = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Node>[] graph = new ArrayList[N+1];
        boolean[] visited = new boolean[N+1];
        long[] dist = new long[N+1];
        int[] route = new int[N+1];
        for(int i = 1 ;i <= N ; i++){
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for(int i = 0 ; i < M ; i++){
            String[] SET = br.readLine().split(" ");
            int s = Integer.parseInt(SET[0]);
            int e = Integer.parseInt(SET[1]);
            int t = Integer.parseInt(SET[2]);

            graph[s].add(new Node(e, t, 0));
        }

        String[] SE = br.readLine().split(" ");
        int start = Integer.parseInt(SE[0]);
        int end = Integer.parseInt(SE[1]);
        dist[start] = 0;

        PriorityQueue<Node> q = new PriorityQueue<>();
        visited[start] = true;
        q.add(new Node(start, 0, 0));

        while (!q.isEmpty()){
            Node now = q.poll();
            visited[now.to] = true;
            if(visited[end]) break;

            for(Node next : graph[now.to]){
                if(!visited[next.to]){
                    if(dist[now.to] + next.time < dist[next.to]){
                        dist[next.to] = dist[now.to] + next.time;   // 최단 거리 업댓
                        route[next.to] = now.to;                    // 경로 복원

                        q.add(new Node(next.to, next.time , dist[next.to]));
                    }
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        int idx = end;
        stack.push(end);
        for(int i = 0 ; i < N ; i++){
            if(stack.peek() != route[idx] && route[idx] != 0){
                stack.push(route[idx]);
                idx = route[idx];
            }
        }

        sb.append(dist[end]).append("\n");
        sb.append(stack.size()).append("\n");

        while (!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
    static class Node implements Comparable<Node>{
        int to;
        int time;
        long dis;

        Node(int to, int time, long dis){
            this.to = to;
            this.time = time;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o){
            return (int) (this.dis - o.dis);
        }
    }
}
