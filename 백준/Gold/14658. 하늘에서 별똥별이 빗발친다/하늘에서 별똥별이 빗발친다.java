import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static int N, M, L, K;
	static int MAX = Integer.MIN_VALUE;
	static List<Spot> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NMLK = br.readLine().split(" ");
		N = Integer.parseInt(NMLK[0]);
		M = Integer.parseInt(NMLK[1]);
		L = Integer.parseInt(NMLK[2]);
		K = Integer.parseInt(NMLK[3]);

		for(int i = 0 ; i < K ; i++){
			String[] XY = br.readLine().split(" ");
			int X = Integer.parseInt(XY[0]);
			int Y = Integer.parseInt(XY[1]);

			arr.add(new Spot(X, Y));
		}


		for(Spot a : arr){
			for(Spot b : arr){
				checkArea(a.x, b.y);
			}
		}

		System.out.println(K - MAX);
	}

	static void checkArea(int X, int Y){
		int cnt = 0;
		for(Spot spot : arr){
			int x = spot.x;
			int y = spot.y;
			if(x >= X && x <= X+L && y >= Y && y <= Y+L) cnt++;
		}
		MAX = Math.max(MAX, cnt);
	}


	static class Spot{
		int x;
		int y;

		Spot(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
