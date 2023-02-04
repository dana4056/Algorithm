import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for(int t = 0 ; t < T ; t++){
			String[] inputs = br.readLine().split(" ");

			int x1 = Integer.parseInt(inputs[0]);
			int y1 = Integer.parseInt(inputs[1]);
			int r1 = Integer.parseInt(inputs[2]);
			int x2 = Integer.parseInt(inputs[3]);
			int y2 = Integer.parseInt(inputs[4]);
			int r2 = Integer.parseInt(inputs[5]);

			double dir = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

			if(dir == 0) {
				if(r1 == r2) sb.append(-1).append("\n");					// 두 원이 일치
				else sb.append(0).append("\n");
			}
			else if(dir == r1 + r2) sb.append(1).append("\n");				// 두 원이 외접
			else if(dir == (Math.abs(r1 - r2)))	sb.append(1).append("\n"); 	// 두 원이 내접
			else if(dir < (Math.abs(r1 - r2)))	sb.append(0).append("\n"); 	// 한 원이 다른 원 안에 위치
			else if(dir < r1 + r2) sb.append(2).append("\n");				// 두 점에의 교점이 2개
			else if(dir > r1 + r2) sb.append(0).append("\n");				// 그냥 안만나
		}
		System.out.println(sb);
	}
}
