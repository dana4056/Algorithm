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
        char[] gender = new char[N+1];
        parents = new int[N+1];

        String line = br.readLine();
        for(int i = 1 ; i <= N ; i++){
            gender[i] = line.charAt((i-1) * 2);
            parents[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i = 0 ; i < M ; i++){
            String[] UVD = br.readLine().split(" ");
            int U = Integer.parseInt(UVD[0]);
            int V = Integer.parseInt(UVD[1]);
            int D = Integer.parseInt(UVD[2]);

            pq.add(new Edge(U, V, D));
        }

        int cnt = 0, disSum = 0;
        while(cnt < N-1 && !pq.isEmpty()){
            Edge now = pq.poll();

            // 성별 같으면 연결 X
            if(gender[now.a] == gender[now.b]) continue;

            int aRoot = rootNode(now.a);
            int bRoot = rootNode(now.b);

            // 사이클 생성 시 연결 X
            if(aRoot == bRoot) continue;

            disSum += now.dis;
            cnt++;

            if(aRoot < bRoot){
                parents[bRoot] = aRoot;
            }else{
                parents[aRoot] = bRoot;
            }
        }

        System.out.println(cnt == N-1 ? disSum : -1);
    }

    private static int rootNode(int n) {
        if(parents[n] == n) return n;
        return rootNode(parents[n]);
    }

    static class Edge implements Comparable<Edge>{
        int a;
        int b;
        int dis;

        Edge(int a, int b, int d){
            this.a = a;
            this.b = b;
            this.dis = d;
        }

        @Override
        public int compareTo(Edge e){
            return this.dis - e.dis;
        }
    }
}
