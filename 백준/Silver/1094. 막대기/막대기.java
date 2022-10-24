import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//#1.막대기
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
        int X = Integer.parseInt(br.readLine());  //목표 막대 길이 입력

        int sum = 0, cnt = 0;
        //			int[] arr = new int[10];

        int now = 64;
        while(now != 0) {
            if(now + sum == X) { //딱 나누어 떨어질때..?
                cnt += 1;
                break;
            }

            now = now /2 ;

            if(now + sum < X) {
                //					arr[cnt] = now;
                sum += now;
                cnt ++;

            }

            if(now == 1) { // 마지막 1 추가
                //					arr[cnt] = 1;
            }
        }
        System.out.println(cnt);
    }
}

