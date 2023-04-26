import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

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
        q.add(new Node(N, 0, 0));
        while(!q.isEmpty()){
            Node now = q.poll();
            visited[now.value] = true;

            if(now.value * 2 == K){
                System.out.println(now.cnt);
                break;
            }
            if(now.value - 1 == K || now.value + 1 == K){
                System.out.println(now.cnt + 1);
                break;
            }

            if(now.value * 2 <= 100000 && now.value*2 >= 0 && !visited[now.value * 2]){
                q.add(new Node(now.value * 2, now.cnt, now.height + 1));
            }
            if(now.value - 1 >= 0 && now.value - 1 <= 100000 && !visited[now.value - 1]){
                q.add(new Node(now.value - 1, now.cnt + 1, now.height + 1));
            }
            if(now.value + 1 <= 100000 && !visited[now.value + 1]){
                q.add(new Node(now.value + 1, now.cnt + 1, now.height + 1));
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

