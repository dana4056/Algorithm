import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");

        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        if(N == K){
            System.out.println(0);
            return;
        }

        PriorityQueue<Node> q = new PriorityQueue<>();

        visited[N] = true;
        q.add(new Node(N, 0, 0));

        while(!q.isEmpty()){
            Node now = q.poll();

            if(now.value == K){
                System.out.println(now.cnt);
                break;
            }

            if(now.value * 2 <= 100000 && now.value * 2 >= 0 && !visited[now.value * 2]){
                visited[now.value * 2] = true;
                q.add(new Node(now.value * 2, now.cnt, now.height + 1));
            }

            if(now.value + 1 <= 100000 && !visited[now.value + 1]){
                visited[now.value + 1] = true;
                q.add(new Node(now.value + 1, now.cnt + 1, now.height + 1));
            }
            if(now.value - 1 >= 0 && now.value - 1 <= 100000 && !visited[now.value - 1]){
                visited[now.value - 1] = true;
                q.add(new Node(now.value - 1, now.cnt + 1, now.height + 1));
            }
        }
    }


    static class Node implements Comparable<Node>{
        int value;
        int cnt;
        int height;


        Node(int v, int c, int h){
            this.value = v;
            this.cnt = c;
            this.height = h;
        }

        @Override
        public int compareTo(Node o) {
            if(this.height == o.height){
                return this.cnt - o.cnt;
            }
            return this.height - o.height;
        }
    }
}

