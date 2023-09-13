import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] AB = br.readLine().split(" ");
		double A = Double.parseDouble(AB[0]);
		double B = Double.parseDouble(AB[1]);

		System.out.println(A/B);
	}
}
