import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long ans = N;
        String[] tmp = br.readLine().split(" ");
        String[] BC = br.readLine().split(" ");
        int B = Integer.parseInt(BC[0]);
        int C = Integer.parseInt(BC[1]);


        for(int i = 0 ; i < N ; i++){
            int people = Integer.parseInt(tmp[i]);
            people -= B;
            if(people > 0){
                if(people % C > 0){
                    ans += (people / C) + 1;
                }else{
                    ans += people / C;
                }
            }
        }

        System.out.println(ans);
    }
}
