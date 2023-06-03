import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NH = br.readLine().split(" ");
        int N = Integer.parseInt(NH[0]);
        int H = Integer.parseInt(NH[1]);
        int[] sumList = new int[H+1];

        for(int i = 0 ; i < N ; i++){
            int stone = Integer.parseInt(br.readLine());

            if(i % 2 == 0){ // 석순일 떄
                sumList[0] += 1;
                sumList[stone] -= 1;
            }else{          // 종유석일 떄
                sumList[H-stone] += 1;
                sumList[H] -= 1;
            }
        }

        int cnt = 0;
        int MIN = Integer.MAX_VALUE;
        for(int i = 0 ; i < H ; i++){
            if(i > 0){
                sumList[i] += sumList[i-1];
            }
            if(sumList[i] < MIN){
                cnt = 0;
                MIN = sumList[i];
            }
            if(sumList[i] == MIN){
                cnt++;
            }
        }
        System.out.println(MIN+" "+cnt);
    }
}
