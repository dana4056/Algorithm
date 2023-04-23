import java.util.Scanner;

// Z
public class Main{

	static int r, c;
	static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		f(N, 0, 0);
		System.out.println(ans);
	}
	
	static void f(int N, int s_row, int s_col) {  //N, start row, start col
		if(N == 0) {
			return;
		}
		int areaNo = 0;
		int row = s_row, col = s_col;
		int half = (int)Math.pow(2, N-1);
		
		if(r < row + half && c < col + half) {
			areaNo = 1;
		}
		else if(r < row + half && c >= col + half) {
			col += half;
			areaNo = 2;
		}
		else if(r >= row + half && c < col + half) {
			row += half;
			areaNo = 3;
		}
		else if(r >= row + half && c >= col + half) {
			row += half;
			col += half;
			areaNo = 4;
		}
		ans += (areaNo-1)* half * half;
		
		f(N-1, row, col);
	}

}
