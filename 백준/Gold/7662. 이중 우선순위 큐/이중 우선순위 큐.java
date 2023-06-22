import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int k = Integer.parseInt(br.readLine());
            Map<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Integer> min = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < k; i++) {
                String[] input = br.readLine().split(" ");
                char ch = input[0].charAt(0);
                int num = Integer.parseInt(input[1]);

                if (ch == 'I') {
                    map.put(num, map.getOrDefault(num, 0) + 1);

                    min.add(num);
                    max.add(num);
                } else {
                    if (map.size() == 0) continue;

                    PriorityQueue<Integer> que = num == 1 ? max : min;
                    removeVisited(que, map);
                }
            }

            if (map.size() == 0){
                sb.append("EMPTY").append("\n");
            }
            else {
                int n = removeVisited(max, map);
                sb.append(n).append(" ").append(map.size() > 0 ? removeVisited(min, map) : n).append("\n");
            }

        }
        System.out.print(sb);

    }

    static int removeVisited(PriorityQueue<Integer> que, Map<Integer, Integer> map) {
        int num;
        while (true) {
            num = que.poll();
            int cnt = map.getOrDefault(num, 0);

            if (cnt == 0) continue;

            if (cnt == 1){
                map.remove(num);
            }
            else{
                map.put(num, cnt - 1);
            }
            break;
        }
        return num;
    }
}


