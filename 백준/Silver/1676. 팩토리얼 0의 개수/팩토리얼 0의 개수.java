import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long fact = 1;
		int cnt = 0;
		int cnt_two = 0, cnt_five = 0;

		for(int i = 1 ; i <= N ; i++){
			int num = i;
			while(num % 10 == 0){
				cnt++;
				num /= 10;
			}
			while (num % 5 == 0){
				cnt_five++;
				num /= 5;
			}
			while(num % 2 == 0){
				cnt_two++;
				num /= 2;
			}
		}

		while(cnt_two > 0 && cnt_five > 0){
			cnt++;
			cnt_two--;
			cnt_five--;
		}

		System.out.println(cnt);
	}
}
