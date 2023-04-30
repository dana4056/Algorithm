import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];

		String answer = "Hing";

		for(int i = 0 ; i < N ; i++){
			String[] tmp = br.readLine().split(" ");
			for(int j = 0 ; j < N ; j++){
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0));

		while (!q.isEmpty()){
			Node now = q.poll();
			int r = now.r;
			int c = now.c;
			int delta = map[now.r][now.c];

			map[now.r][now.c] = 0;

			if(delta == -1){
				answer = "HaruHaru";
				break;
			}

			if(c+delta < N && map[r][c+delta] != 0){
				q.add(new Node(r, c+delta));	// 오른쪽 이동
			}
			if(r+delta < N && map[r+delta][c] != 0){
				q.add(new Node(r+delta, c));	// 아래로 이동
			}
		}
		System.out.println(answer);
	}

	static class Node{
		int r;
		int c;

		Node(int row, int col){
			this.r = row;
			this.c = col;
		}
	}
}
