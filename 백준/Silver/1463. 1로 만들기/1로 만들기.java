import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[][] table;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		table = new int[3][N+1];
		table[0][1] = table[1][1] = table[2][1] = 0;

		for(int i = 0 ; i < 3 ; i++){
			for(int j = 2 ; j < N+1 ; j++){
				table[i][j] = 99999;
			}
		}

		for(int i = 2 ; i <= N ; i++){
			if(i % 3 == 0){
				table[0][i] = beforeMin(i/3) + 1;
			}
			if(i % 2 == 0){
				table[1][i] = beforeMin(i/2) + 1;
			}
			table[2][i] = beforeMin(i-1) + 1;
		}

		System.out.println(beforeMin(N));
	}

	static int beforeMin(int idx){
		return Math.min(Math.min(table[0][idx], table[1][idx]), table[2][idx]);
	}
}
