import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int V, E;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] VE = br.readLine().split(" ");
        int V = Integer.parseInt(VE[0]);
        int E = Integer.parseInt(VE[1]);
        Long sum = 0l;
        int cnt = 0;

        // 처음엔 모든 노드들이 자신이 부모
        parents = new int[V+1];
        for(int i = 1 ; i <= V ; i++){
            parents[i] = i;
        }

        PriorityQueue<Node> q = new PriorityQueue<>();
        for(int i = 0 ; i < E ; i++){
            String[] ABC = br.readLine().split(" ");
            int A = Integer.parseInt(ABC[0]);
            int B = Integer.parseInt(ABC[1]);
            int C = Integer.parseInt(ABC[2]);

            q.add(new Node(A, B, C));
        }

        while(!q.isEmpty() && cnt < V){
            Node now = q.poll();
            int A = now.A;
            int B = now.B;

            // 사이클 발생 여부 확인
            int rootA = findRoot(A);
            int rootB = findRoot(B);
            if(rootA == rootB) continue;

            // 루트 노드끼리 연결
            sum += now.W;
            cnt++;
            parents[rootA] = rootB;
            parents[A] = rootB;
        }
        System.out.println(sum);

    }

    private static int findRoot(int n) {
        if(parents[n] == n) return n;   // 최상위 노드일때 (자신)
        else{
            return findRoot(parents[n]);
        }
    }

    static class Node implements Comparable<Node>{
        int A;
        int B;
        int W;

        Node(int a, int b, int w){
            this.A = a;
            this.B = b;
            this.W = w;
        }

        @Override
        public int compareTo(Node n){
            return this.W - n.W;
        }
    }
}
