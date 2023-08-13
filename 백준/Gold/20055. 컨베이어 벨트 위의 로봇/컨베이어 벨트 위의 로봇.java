import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int N, K;
	static int[] belt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = br.readLine().split(" ");
		N = Integer.parseInt(NK[0]);
		K = Integer.parseInt(NK[1]);
		belt = new int[2*N];

		String[] line = br.readLine().split(" ");
		// 0: 올리는 위치, N-1: 내리는 위치
		for(int i = 0 ; i < 2*N ; i++){
			belt[i] = Integer.parseInt(line[i]);
		}

		int zero = 0, cnt = 0;
		List<Integer> robots = new ArrayList<>();
		Queue<Integer> remove = new LinkedList<>();
		while(zero < K){
			// 1. 회전
			// 컨베이어 벨트 회전
			int tmp = belt[2*N-1];
			for(int i = 2*N-1 ; i > 0 ; i--){
				belt[i] = belt[i-1];
			}
			belt[0] = tmp;

			// 로봇 회전
			for(int i = 0 ; i < robots.size() ; i++){
				int idx = robots.get(i);
				idx = (idx + 1) % (2 * N);
				if(idx >= N-1){
					remove.add(i);
				}
				robots.set(i, idx);
			}

			// 로봇 내리기
			while(!remove.isEmpty()){
				int poll = remove.poll();
				robots.remove(poll);
			}
			// 2. 로봇이동
			for(int i = 0 ; i < robots.size() ; i++){
				int idx = robots.get(i);

				int next = (idx + 1) % (2 * N);
				if(belt[next] >= 1 && !robots.contains(next)){
					robots.set(i, next);
					belt[next] -= 1;
					if(belt[next] == 0){
						zero++;
					}
					if(next >= N-1){
						remove.add(i);
					}
				}
			}

			// 로봇 내리기
			while(!remove.isEmpty()){
				int poll = remove.poll();
				robots.remove(poll);
			}
			// 3. 로봇 올리기
			if(belt[0] > 0){
				robots.add(0);
				belt[0] -= 1;
				if(belt[0] == 0){
					zero++;
				}
			}
			cnt++;
		}

		System.out.println(cnt);
	}

}
