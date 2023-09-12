import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parents = new int[N+1];

        PriorityQueue<Edge> q = new PriorityQueue<Edge>();
        for(int i = 0 ; i < N ; i++){
            parents[i+1] = i+1;
            String[] line = br.readLine().split(" ");
            for(int j = i ; j < N ; j++){
                int cost = Integer.parseInt(line[j]);
                if(cost > 0){
                    q.add(new Edge(i+1, j+1, cost));
                }
            }
        }

        int cnt = 0;
        long total = 0;
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
