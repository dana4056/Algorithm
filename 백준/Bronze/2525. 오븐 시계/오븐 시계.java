import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] HM = br.readLine().split(" ");
        int H = Integer.parseInt(HM[0]);
        int M = Integer.parseInt(HM[1]);
        int M2 = Integer.parseInt(br.readLine());

        int rM = M + (M2 % 60);
        if(rM >= 60){
            H += 1;
            rM -= 60;
        }
        int rH = (H + (M2 / 60)) % 24;

        System.out.println(rH+" "+rM);

    }
}
