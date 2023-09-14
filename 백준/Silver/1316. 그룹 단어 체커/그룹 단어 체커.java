import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[] visited = new boolean[26];
		int cnt = 0;
		for(int i = 0 ; i < N ; i++){
			char[] chars = br.readLine().toCharArray();
			boolean group = true;
			for(int j = 0 ; j < chars.length ; j++){
				if(j > 0 && chars[j] == chars[j-1]) continue;

				if(visited[chars[j] - 97]){
					group = false;
					break;
				}else{
					visited[chars[j] - 97] = true;
				}
			}

			if (group) cnt++;
			Arrays.fill(visited, false);
		}
		System.out.println(cnt);
	}
}
