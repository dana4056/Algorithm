import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static Deque<Integer> blue = new ArrayDeque<>();
	static Deque<Integer> green = new ArrayDeque<>();
	static Deque<Integer> back = blue;
	static Deque<Integer> front = new ArrayDeque<>();
	static int now;
	static int[] caps;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NQ = br.readLine().split(" ");
		int N = Integer.parseInt(NQ[0]);	// 웹 페이지 종류
		int Q = Integer.parseInt(NQ[1]);	// 작업 개수
		caps = new int[N+1];

		for(int i = 0 ; i < Q ; i++){
			String[] cmd = br.readLine().split(" ");

			switch (cmd[0].charAt(0)){
				case 'B':
					backward();
					break;
				case 'F':
					frontward();
					break;
				case 'A':
					access(Integer.parseInt(cmd[1]));
					break;
				case 'C':
					compress();
					break;
			}
		}

		System.out.println(printAnswer());
	}

	private static String printAnswer() {
		StringBuilder sb = new StringBuilder();
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
		return sb.toString();
	}

	static void backward(){
		if(back.size() > 0){
			front.add(now);
			now = back.pollLast();
		}
	}

	static void frontward(){
		if(front.size() > 0){
			back.add(now);
			now = front.pollLast();
		}
	}

	static void access(int page){
		if(now > 0){
			front.clear();
			back.add(now);
		}

		// 페이지 접속
		now = page;
	}

	static void compress(){
		Deque<Integer> empty = blue.size() == 0 ? blue : green;
		Deque<Integer> full = blue.size() > 0 ? blue : green;

		int page = 0;
		while(!full.isEmpty()){
			int next = full.pollFirst();
			if(next == page) continue;

			empty.add(next);
			page = next;
		}

		full.clear();
		back = empty;
	}
}
