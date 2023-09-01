import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] NM = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[] inDegree = new int[N+1];
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i++){
            String[] AB = br.readLine().split(" ");
            int A = Integer.parseInt(AB[0]);
            int B = Integer.parseInt(AB[1]);

            inDegree[B] += 1;
            graph[A].add(B);
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 1 ; i <= N ; i++){
            if(inDegree[i] == 0) q.add(i);
        }

        for(int i = 0 ; i < N ; i++){
            int now = q.poll();
            sb.append(now).append(" ");

            for(int next : graph[now]){
                inDegree[next] -= 1;
                if(inDegree[next] == 0) q.add(next);
            }
        }
        System.out.println(sb);
    }
}
