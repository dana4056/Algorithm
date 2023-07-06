import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());    // 도시
        int M = Integer.parseInt(br.readLine());    // 버스

        long[][] dist = new long[N+1][N+1];

        for(int i = 1 ; i <= N ; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for(int i = 0 ;i < M ; i++){
            String[] ABC = br.readLine().split(" ");
            int a = Integer.parseInt(ABC[0]);
            int b = Integer.parseInt(ABC[1]);
            int c = Integer.parseInt(ABC[2]);

            dist[a][b] = Math.min(dist[a][b], c);

        }

        for(int k = 1 ; k <= N ; k++){
            for(int i = 1 ; i <= N ; i++){
                for(int j = 1 ; j <= N ; j++){
                    if(dist[i][k] + dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] +dist[k][j];
                    }
                }
            }
        }


        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                if(dist[i][j] == INF){
                    sb.append(0).append(" ");
                }else{
                    sb.append(dist[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }
}
