import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static char[] select = new char[9];
    static StringBuilder sb = new StringBuilder();
    static StringBuilder tmp = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < T ; tc++){
            N = Integer.parseInt(br.readLine());
            perm(1);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void perm(int cnt) {
        if(cnt == N){

            tmp.delete(0,tmp.length());
            int sum = 0, blank = 0, cache = 0;
            for(int i = N ; i > 1 ; i--){
                switch (select[i-1]){
                    case '+':
                        if(cache == 0) sum += i;
                        else {
                            sum += cache + (i * Math.pow(10.0, blank));
                            cache = 0;
                            blank = 0;
                        }
                        break;
                    case '-':
                        if(cache == 0) sum -= i;
                        else {
                            sum -= cache + (i * Math.pow(10.0, blank));
                            cache = 0;
                            blank = 0;
                        }
                        break;
                    case ' ':
                        cache += i * Math.pow(10.0, blank);
                        blank += 1;
                        break;
                }
                tmp.append(i).append(select[i-1]);
            }
            tmp.append(1);

            if(select[1] == ' '){
                sum += cache + (1 * Math.pow(10.0, blank));
            }else{
                sum += 1;
            }

            if(sum == 0){
                sb.append(tmp.reverse()).append("\n");
            }
            return;
        }

        for(int i = 0 ; i < 3 ; i++){
            switch (i){
                case 0: select[cnt] = ' '; break;
                case 1: select[cnt] = '+'; break;
                case 2: select[cnt] = '-'; break;
            }
            perm(cnt+1);
        }
    }
}
