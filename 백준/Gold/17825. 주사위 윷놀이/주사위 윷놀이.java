import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] nums = new int[10];
	static Node[][] board = new Node[33][2];
	static int[] mal = new int[4];
	static int MAX = -1;
	static boolean[] visited = new boolean[33];
	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");

		for(int i = 0 ; i < 10 ; i++){
			nums[i] = Integer.parseInt(tmp[i]);
		}

		fillBoard();

		perm(0, 0);
		System.out.println(MAX);
	}

	private static void perm(int cnt, int sum) {
		if(cnt == 10){
			MAX = Math.max(MAX, sum);
			return;
		}

		for(int i = 0 ; i < 4 ; i++){
			int n = nums[cnt];
			int now = mal[i];
			int next = now;
			if(next == 21) continue;
			// i번째 말 n번 이동
			for(int j = 0 ; j < n ; j++){

				if(j == 0 && (next == 5 || next == 10 || next == 15)){
					next = board[next][1].to;
				}else {
					next = board[next][0].to;
				}
				// 도착시 이동 정지
				if(next == 21){
					break;
				}
			}
			int origin  = mal[i];
			if(next == 21){
				visited[now] = false;
				mal[i] = next;
				perm(cnt + 1, sum );
				visited[now] = true;
				mal[i] = origin;

			}
			else if(!visited[next]){
				visited[now] = false;
				visited[next] = true;
				mal[i] = next;
				perm(cnt + 1, sum + board[next][0].value);
				visited[now] = true;
				visited[next] = false;
				mal[i] = origin;
			}
		}
	}

	private static void fillBoard() {
		for(int i = 0 ; i <= 20 ; i++){
			board[i][0] = new Node(i + 1, i * 2);
		}

		board[5][1] = new Node(22, 10);
		board[10][1] = new Node(29, 20);
		board[15][1] = new Node(28, 30);

		board[22][0] = new Node(23, 13);
		board[23][0] = new Node(24, 16);
		board[24][0] = new Node(25, 19);
		board[25][0] = new Node(31, 25);
		board[26][0] = new Node(25, 26);
		board[27][0] = new Node(26, 27);
		board[28][0] = new Node(27, 28);
		board[29][0] = new Node(30, 22);
		board[30][0] = new Node(25, 24);
		board[31][0] = new Node(32, 30);
		board[32][0] = new Node(20, 35);
	}
	static class Node{

		int to;
		int value;
		boolean exist;

		Node(int t, int v){
			this.to = t;
			this.value = v;
		}
	}
}
