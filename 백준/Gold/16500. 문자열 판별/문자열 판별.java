import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        HashSet<String> set = new HashSet<>();
        int[] dp = new int[str.length()+1];
        dp[str.length()] = 1;

        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++){
            set.add(br.readLine());
        }

        for(int i = str.length() - 1 ; i>= 0 ; i--){
            for(int j = i+1 ; j <= str.length() ; j++){
                if(dp[j] == 1){
                    if(set.contains(str.substring(i, j))){
                        dp[i] = 1;
                    }
                }
            }
        }

        System.out.println(dp[0]);
    }
}
