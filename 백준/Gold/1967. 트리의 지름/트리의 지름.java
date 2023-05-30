import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static int length;		//트리의 지름
	static ArrayList<Node>[] tree;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 노드 개수

		tree = new ArrayList[N+1];
		visited = new boolean[N+1];
		ArrayList<Integer> leaf = new ArrayList<>();

		for(int i = 0 ; i < N+1 ; i++){			// 인접리스트 초기화
			tree[i] = new ArrayList<>();
		}

		int lastParent = 1;
		for(int i = 0 ; i < N-1 ; i++){
			String[] psv = br.readLine().split(" ");	// parent, son, value
			int parent = Integer.parseInt(psv[0]);
			int son = Integer.parseInt(psv[1]);
			int value = Integer.parseInt(psv[2]);
			lastParent = parent;
			// 부모 -> 자식
			tree[parent].add(new Node(son, value));

			// 자식 -> 부모
			tree[son].add(new Node(parent, value));
		}

		for(int i = 1 ; i <= N ; i++){
			if(tree[i].size() == 1){
				leaf.add(i);
			}
		}

		for(int i : leaf){
			visited[i] = true;
			DFS(i, 0);
			Arrays.fill(visited, false);
		}

		System.out.println(length);

	}

	private static void DFS(int now, int sum) {
		if(tree[now].size() == 1 && visited[tree[now].get(0).to]){	// 끝 노드일 경우
			length = Math.max(sum, length);
			return;
		}

		for(Node node : tree[now]){
			int next = node.to;
			if(!visited[next]){
				visited[next] = true;
				DFS(next, sum + node.val);
				visited[next] = false;
			}
		}
	}

	static class Node{
		int to;
		int val;

		Node(int t, int v){
			this.to = t;
			this.val = v;
		}
	}
}
