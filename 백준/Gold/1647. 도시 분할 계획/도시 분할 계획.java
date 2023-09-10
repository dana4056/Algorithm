import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        parents = new int[N+1];
        for(int i = 1 ; i <= N ; i++){
            parents[i] = i;
        }

        PriorityQueue<Edge> q = new PriorityQueue<Edge>();
        for(int i = 0 ; i < M ; i++){
            String[] ABC = br.readLine().split(" ");
            int A = Integer.parseInt(ABC[0]);
            int B = Integer.parseInt(ABC[1]);
            int C = Integer.parseInt(ABC[2]);

            q.add(new Edge(A, B, C));
        }

        int edgeCnt = 0, totalCost = 0;
        while (edgeCnt < N-2){
            Edge now = q.poll();

            int aRoot = getParent(now.A);
            int bRoot = getParent(now.B);

            if(aRoot == bRoot)  continue;

            edgeCnt++;
            totalCost += now.cost;
            if(aRoot < bRoot) parents[bRoot] = aRoot;
            else parents[aRoot] = bRoot;
        }

        System.out.println(totalCost);
    }

    static int getParent(int n){
        if(parents[n] == n) return n;
        return getParent(parents[n]);
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
