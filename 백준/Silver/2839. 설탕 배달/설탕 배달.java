import java.util.Scanner;

//설탕 배달
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = 0;
		
		while(true) {
			if(N < 3) {
				if(N != 0) cnt = -1;
				break;
			}
			if(N >= 5 && (N % 5 == 0 || (N - 5) % 3 == 0)) {
				N -= 5;
				cnt += 1;
			}
			else if(N >= 3) {
				N -= 3;
				cnt += 1;
			}
		}
		System.out.println(cnt);
	}

}
