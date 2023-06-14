import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int mine = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N-1 ; i++){
            q.add(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;
        while (!q.isEmpty() && q.peek() >= mine) {
            cnt++;
            mine++;
            q.add(q.poll() - 1);
        }
        System.out.println(cnt);
    }
}
