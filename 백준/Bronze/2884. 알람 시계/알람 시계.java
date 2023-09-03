import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] HM = br.readLine().split(" ");
		int H = Integer.parseInt(HM[0]);
		int M = Integer.parseInt(HM[1]);

		int minutes = H * 60 + M;
		minutes = (minutes + 1395) % 1440;

		sb.append(minutes / 60).append(" ").append(minutes % 60);
		System.out.println(sb);
	}
}
