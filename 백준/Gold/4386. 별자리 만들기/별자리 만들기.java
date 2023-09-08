import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[][] stars = new double[N][2];
        parents = new int[N];

        for(int i = 0 ; i < N ; i++){
            String[] XY = br.readLine().split(" ");
            double X = Double.parseDouble(XY[0]);
            double Y = Double.parseDouble(XY[1]);

            stars[i][0] = X;
            stars[i][1] = Y;

            parents[i] = i;
        }

        PriorityQueue<Star> pq = new PriorityQueue<>();
        for(int i = 0 ; i < N ; i++){
            for(int j = i+1 ; j < N ; j++){
                double ax = stars[i][0];
                double ay = stars[i][1];
                double bx = stars[j][0];
                double by = stars[j][1];
                double dis = Math.sqrt(Math.pow(ax - bx, 2.0) + Math.pow(ay - by, 2.0));
                pq.add(new Star(i, j, dis));
            }
        }

        int cnt = 0;
        double sum = 0.0;
        while (cnt < N-1 && !pq.isEmpty()){
            Star now = pq.poll();
            // 사이클 발생확인
            int aRoot = rootParent(now.A);
            int bRoot = rootParent(now.B);
            if(aRoot == bRoot) continue;

            sum += now.dis;
            cnt += 1;

            parents[bRoot] = aRoot;
            parents[now.B] = aRoot;
        }

        System.out.printf("%.2f", sum);
    }

    static int rootParent (int a){
        if(parents[a] == a) return a;
        return rootParent(parents[a]);
    }
    static class Star implements Comparable<Star>{
        int A;
        int B;
        double dis;

        Star(int a, int b, double d){
            this.A = a;
            this.B = b;
            this.dis = d;
        }

        @Override
        public int compareTo(Star s){
            return (int)(this.dis - s.dis);
        }
    }
}
