import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int NumA = Integer.parseInt(br.readLine());
        String StrB = br.readLine();
        int NumB = Integer.parseInt(StrB);

        for(int i = 2 ; i >= 0 ; i--){
            sb.append(NumA * Integer.parseInt(StrB.charAt(i)+"")).append("\n");
        }
        sb.append(NumA * NumB);

        System.out.println(sb);
    }

}
