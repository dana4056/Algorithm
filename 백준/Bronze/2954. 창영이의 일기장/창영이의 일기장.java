import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] words = br.readLine().split(" ");


        for(int i = 0 ; i < words.length ; i++){
            for(int j = 0 ; j < words[i].length() ; j++){
                char ch = words[i].charAt(j);
                if(isAEIOU(ch)){
                    sb.append(ch);
                    j += 2;
                }else {
                    sb.append(ch);
                }
            }
            sb.append(' ');
        }

        System.out.println(sb);
    }
    private static boolean isAEIOU(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        return false;
    }
}
