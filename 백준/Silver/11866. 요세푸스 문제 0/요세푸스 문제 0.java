import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		Queue<Integer> q = new LinkedList<>();

		for(int i = 1 ; i <= N ; i++){
			q.add(i);
		}

		int cnt = 0;
		int len = 0;
		sb.append("<");
		while (!q.isEmpty()){
			cnt++;
			int poll = q.poll();
			if(cnt == K){
				cnt = 0;
				len++;
				if(len != N){
					sb.append(poll).append(", ");
				}else{
					sb.append(poll).append(">");
				}
			}else{
				q.add(poll);
			}
		}

		System.out.println(sb);
	}
}
