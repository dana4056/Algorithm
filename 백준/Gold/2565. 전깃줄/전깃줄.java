import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        PriorityQueue<Pair> pairs = new PriorityQueue<>();

        for(int i = 0 ; i < N ; i++){
            String[] AB = br.readLine().split(" ");
            int A = Integer.parseInt(AB[0]);
            int B = Integer.parseInt(AB[1]);
            pairs.add(new Pair(A, B));
        }

        for(int i = 0 ; i < N ; i++){
            Pair poll = pairs.poll();
            arr[i] = poll.B;
        }

        int MAX = -1;
        for(int i = 0 ; i < N ; i++){
            dp[i] = 1;
            for(int j = 0 ; j < i ; j++){
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
            MAX = Math.max(MAX, dp[i]);
        }

        System.out.println(N-MAX);

    }
    static class Pair implements Comparable<Pair>{
        int A;
        int B;

        Pair(int a, int b){
            this.A = a;
            this.B = b;
        }

        @Override
        public int compareTo(Pair p){
            return this.A - p.A;
        }
    }
}
