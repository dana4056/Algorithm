import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine(); // 대상문자열
        String sub = br.readLine(); // 폭발문자열

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < str.length() ; i++){
            sb.append(str.charAt(i));
            if(sb.length() >= sub.length()){
                boolean isSame = true;
                for(int j = 0 ; j < sub.length() ; j++){
                    if(sb.charAt(sb.length() - sub.length() + j) != sub.charAt(j)) isSame = false;
                }
                if(isSame){
                    int start = sb.length() - sub.length();
                    int end = sb.length();
                    sb.delete(start, end);
                }
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb);
    }
}


