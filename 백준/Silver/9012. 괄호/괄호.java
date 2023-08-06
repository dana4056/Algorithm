import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++){
            String s = br.readLine();
            int open = 0;
            boolean correct = true;
            for(int j = 0 ; j < s.length() ; j++){
                char ch = s.charAt(j);
                if(ch == '('){
                    open++;
                }else{
                    if(open == 0){
                        correct = false;
                        break;
                    }else{
                        open--;
                    }
                }
            }
            if(open == 0 && correct){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
        }
        System.out.print(sb);
    }
}
