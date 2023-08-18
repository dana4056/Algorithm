 import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStreamReader;
 import java.util.Arrays;

 public class Main {
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String[] NM = br.readLine().split(" ");
         int N = Integer.parseInt(NM[0]);
         int M = Integer.parseInt(NM[1]);
         long[] arr = new long[N];

         for(int i = 0 ; i < N ; i++){
             arr[i] = Integer.parseInt(br.readLine());
         }
         Arrays.sort(arr);

         long start = 0, ans = 0;
         long end = arr[0] * M;

         while(start <= end){
             long mid = (start + end) / 2;

             long cnt = 0;
             for (int i = 0; i < N; i++) {
                 cnt += (mid / arr[i]);
             }

             if (cnt >= M) {
                 ans = mid;
                 end = mid - 1;
             } else {
                 start = mid + 1;
             }
         }
         System.out.println(ans);
     }

 }
