import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        Map<Character, LinkedList> map = new HashMap<>();

        for(int tc = 0 ; tc < T ; tc++){
            char[] arr = br.readLine().toCharArray();
            int W = arr.length;
            int K = Integer.parseInt(br.readLine());
            int MAX = Integer.MIN_VALUE, MIN = Integer.MAX_VALUE;

            for(int i = 0 ; i < W ; i++){
                char ch = arr[i];
                if(map.get(ch) == null){
                    LinkedList<Integer> ll = new LinkedList<Integer>();
                    ll.add(i);
                    map.put(ch, ll);
                }else{
                    LinkedList<Integer> ll = map.get(ch);
                    ll.add(i);
                }
            }

            char ch = ' ';
            int start = 0, end = 0, len = 0;
            for(int i = 0 ; i < W ; i++){
                ch = arr[i];
                LinkedList<Integer> list = map.get(ch);

                if(K-1 < list.size()){
                    end = list.get(K-1);
                }else{
                    end = -1;
                }
                start = list.poll();

                if(end != -1){
                    len = end - start + 1;

                    MIN = Math.min(MIN, len);
                    MAX = Math.max(MAX, len);
                }
            }

            if(MIN == Integer.MAX_VALUE){
                sb.append("-1\n");
            }else{
                sb.append(MIN).append(" ").append(MAX).append("\n");
            }
        }
        System.out.println(sb);
    }
}
