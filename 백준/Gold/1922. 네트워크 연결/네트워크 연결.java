import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parents = new int[N+1];

        for(int i = 1 ; i <= N ; i++){
            parents[i] = i;
        }

        PriorityQueue<Edge> q = new PriorityQueue<>();
        for(int i = 0 ; i < M ; i++){
            String[] ABC = br.readLine().split(" ");
            int A = Integer.parseInt(ABC[0]);
            int B = Integer.parseInt(ABC[1]);
            int C = Integer.parseInt(ABC[2]);

            q.add(new Edge(A, B, C));
        }

        int cnt = 0, total = 0;
        while(cnt < N-1){
            Edge now = q.poll();

            int aRoot = getRoot(now.A);
            int bRoot = getRoot(now.B);

            if(aRoot == bRoot) continue;

            cnt++;
            total += now.cost;

            if(aRoot < bRoot){
                parents[bRoot] = aRoot;
            }else{
                parents[aRoot] = bRoot;
            }
        }

        System.out.println(total);
    }

    private static int getRoot(int n) {
        if(parents[n] == n) return n;
        return getRoot(parents[n]);
    }

    static class Edge implements Comparable<Edge>{
        int A;
        int B;
        int cost;

        Edge(int a, int b, int c){
            this.A = a;
            this.B = b;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge e){
            return this.cost - e.cost;
        }
    }
}
