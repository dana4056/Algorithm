import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] TAB = br.readLine().split(" ");
		int T = Integer.parseInt(TAB[0]);
		int A = Integer.parseInt(TAB[1]);
		int B = Integer.parseInt(TAB[2]);
		boolean[] visited = new boolean[T+1];

        // fullness[0]: 포만감
		// fullness[1]: 물마신 횟수
		int[] fullness = new int[]{0, 0};
		Queue<int[]> q = new LinkedList<>();
		q.add(fullness);
		int MAX = Integer.MIN_VALUE;
		while (!q.isEmpty()){
			int[] now = q.poll();
			int full = now[0];
			int water = now[1];
			MAX = Math.max(MAX, full);

			if(full + A <= T && !visited[full + A]){
				visited[full + A] = true;
				q.add(new int[] {full + A, water});
			}
			if(full + B <= T && !visited[full + B]){
				visited[full + B] = true;
				q.add(new int[] {full + B, water});
			}
			if(water == 0 && !visited[full / 2]){
				visited[full / 2] = true;
				q.add(new int[] {full / 2, water + 1});
			}
		}

		System.out.println(MAX);
	}
}
