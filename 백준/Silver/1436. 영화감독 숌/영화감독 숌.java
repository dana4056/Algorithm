import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;
        int flag = 1000;

        // 초기화
        long num = 666;
        int digit = 3;
        while(cnt < N){
            if(num == flag){
                digit++;
                flag *= 10;
            }
            int sixCnt = 0;
            long copy = num;
            for(int i = digit-1 ; i >= 0 ; i-- ){
                int n = (int) (copy / Math.pow(10, i));
                copy = copy % (int)Math.pow(10, i);

                if(n == 6){
                    sixCnt++;
                    if(sixCnt == 3){
                        cnt++;
                        break;
                    }
                }else{
                    sixCnt = 0;
                }
            }
            num++;
        }

        System.out.println(num-1);
    }
}
