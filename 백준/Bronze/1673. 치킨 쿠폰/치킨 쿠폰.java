import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();


        while(input != null){
            String[] NK = input.split(" ");

            int N = Integer.parseInt(NK[0]);
            int K = Integer.parseInt(NK[1]);    //나누는 수

            int order  = 0;
            int coupon = N;
            int stamp = 0;

            while(coupon > 0){
                order += coupon;
                stamp += coupon;
                coupon = 0;
                coupon += stamp / K;
                stamp = stamp % K;
            }
            

            System.out.println(order);
            input = br.readLine();
        }
    }
}
