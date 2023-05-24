import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] arr = new int[96002]; // 8000년 * 12개월 + 1(1부터 셀거임) + 1(끝인덱스는 한칸 뒤에 표시)
		int N = Integer.parseInt(br.readLine());

		for(int i = 0 ; i < N ; i++){
			String[] time = br.readLine().split(" ");
			String[] start_str = time[0].split("-");
			String[] end_str = time[1].split("-");

			int sY = Integer.parseInt(start_str[0]);
			int sM = Integer.parseInt(start_str[1]);
			int eY = Integer.parseInt(end_str[0]);
			int eM = Integer.parseInt(end_str[1]);

			int sIdx = (sY - 2000) * 12 + sM;
			int eIdx = (eY - 2000) * 12 + eM + 1;

			arr[sIdx] += 1;
			arr[eIdx] -= 1;
		}
		long MAX = 0;
		int MAX_IDX = 0;
		for(int i = 1  ; i <= 96001 ; i++){
			arr[i] = arr[i-1] + arr[i];

			if(arr[i] > MAX){
				MAX = arr[i];
				MAX_IDX = i;
			}
		}

		int year = 2000 + (MAX_IDX % 12 == 0 ? MAX_IDX / 12 - 1 : MAX_IDX / 12);
		int month = MAX_IDX % 12 == 0 ? 12 : MAX_IDX % 12;
		
		sb.append(year)
			.append("-")
			.append(month < 10 ? "0"+month : month);

		System.out.println(sb);
	}
}
