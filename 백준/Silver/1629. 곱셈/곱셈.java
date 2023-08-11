import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long A, B, C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] ABC = br.readLine().split(" ");
		A = Long.parseLong(ABC[0]);
		B = Long.parseLong(ABC[1]);
		C = Long.parseLong(ABC[2]);

		System.out.println(pow(A, B));
	}

	public static long pow(long A, long num) {

		if(num == 1) {
			return A % C;
		}

		long temp = pow(A, num / 2);

		if(num % 2 == 1) {
			return (temp * temp % C) * A % C;
		}
		return temp * temp % C;
	}
}
