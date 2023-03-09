import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

//ABCDE
public class Main {

	static int ans;
	static Map<Integer, List<Integer>> node = new HashMap<>();
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//인접 리스트 생성
		int a, b;
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(in.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if(node.containsKey(a)) {  
				node.get(a).add(b);   //a -> b
				
				//b -> a
				if(node.containsKey(b)) {
					node.get(b).add(a);
				}else {
					ArrayList<Integer> temp2 = new ArrayList<Integer>();
					temp2.add(a);
					node.put(b, temp2);
				}
				
			}else {
				//a -> b
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(b);
				node.put(a, temp);
				
				//b -> a
				if(node.containsKey(b)) {
					node.get(b).add(a);
				}else {
					ArrayList<Integer> temp2 = new ArrayList<Integer>();
					temp2.add(a);
					node.put(b, temp2);
				}
				
				
			}
		}
		for(int n:node.keySet()) {
			visited = new boolean[N+1];
			dfs(n, 0);
		}
		System.out.println(ans);
	}

	private static void dfs(int now, int cnt) {
		if(ans == 1) return;
		if(cnt == 4) {
			ans = 1;
			return;
		}
		visited[now] = true;
		if(node.get(now) != null) {
			for(int n: node.get(now)) {
				if(!visited[n]) {
					dfs(n, cnt+1);
					visited[n] = false;	
				}
			}
		}
	}

}

/*
5 5
0 1
1 2
2 3
3 0
1 4
*/