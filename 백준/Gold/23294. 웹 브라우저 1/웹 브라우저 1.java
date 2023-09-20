import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] NQC = br.readLine().split(" ");
		int N = Integer.parseInt(NQC[0]);	// 웹 페이지 종류
		int Q = Integer.parseInt(NQC[1]);	// 작업 개수
		int C = Integer.parseInt(NQC[2]);	// 캐시 최대 용량
		int[] caps = new int[N+1];

		String[] line = br.readLine().split(" ");
		for(int i = 1 ; i <= N ; i++){
			caps[i] = Integer.parseInt(line[i-1]);
		}

		Deque<Integer> blue = new ArrayDeque<>();
		Deque<Integer> green = new ArrayDeque<>();
		Deque<Integer> back = blue;
		Deque<Integer> front = new ArrayDeque<>();
		Integer now = null;

		int cap = 0, bCap = 0, fCap = 0;
		for(int i = 0 ; i < Q ; i++){
			String[] cmd = br.readLine().split(" ");

			if(cmd[0].equals("B")){
				if(back.size() > 0){
					front.add(now);
					fCap += caps[now];
					now = back.pollLast();
					bCap -= caps[now];
				}
			}

			else if(cmd[0].equals("F")){
				if(front.size() > 0){
					back.add(now);
					bCap += caps[now];
					now = front.pollLast();
					fCap -= caps[now];
				}
			}

			else if(cmd[0].equals("A")){
				if(cap > 0){
					front.clear();
					cap -= fCap; fCap = 0;
					back.add(now);
					bCap += caps[now];
				}

				// 페이지 접속
				now = Integer.parseInt(cmd[1]);
				cap += caps[now];

				while(cap > C && !back.isEmpty()) {
					int poll = back.pollFirst();
					bCap -= caps[poll];
					cap -= caps[poll];
				}
			}

			else if(cmd[0].equals("C")){
				Deque<Integer> empty = blue.size() == 0 ? blue : green;
				Deque<Integer> full = blue.size() > 0 ? blue : green;

				int page = 0;
				while(!full.isEmpty()){
					int next = full.pollFirst();
					if(next == page) {
						bCap -= caps[next];
						cap -= caps[next];
						continue;
					}

					empty.add(next);
					page = next;
				}

				full.clear();
				back = empty;
			}
		}

		sb.append(now).append("\n");
		if(back.size() == 0){
			sb.append(-1);
		}else{
			while(!back.isEmpty()){
				sb.append(back.pollLast()).append(" ");
			}
		}
		sb.append("\n");
		if(front.size() == 0){
			sb.append(-1);
		}else{
			while(!front.isEmpty()){
				sb.append(front.pollLast()).append(" ");
			}
		}

		System.out.println(sb);
	}
}
