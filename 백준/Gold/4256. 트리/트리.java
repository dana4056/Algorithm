import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] pre;
	static int[] in;
	static Node[] nodes;
	static int preIdx;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int tc = 0 ; tc < T ; tc++){
			preIdx = 0;
			int N = Integer.parseInt(br.readLine());
			pre = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			nodes = new Node[N+1];
			makeTree(0, N-1);

			postOrder(pre[0]);
			sb.append("\n");
		}
		System.out.print(sb);
	}

	private static void postOrder(int root) {
		if(nodes[root].left != -1){
			postOrder(nodes[root].left);
		}
		if(nodes[root].right != -1){
			postOrder(nodes[root].right);
		}
		sb.append(root).append(" ");
	}

	static Node makeTree(int start, int end){
		// 리프 노드일때
		if(end < start){
			return null;
		}

		Node node = new Node(pre[preIdx]);
		int arrIdx = node.middle;
		preIdx++;

		int inIdx = searchIdx(start, end, node.middle);

		int left = -1, right = -1;
		Node lNode = makeTree(start, inIdx - 1);
		if(lNode != null){
			node.left = lNode.middle;
		}
		Node rNode = makeTree(inIdx + 1, end);
		if(rNode != null){
			node.right = rNode.middle;
		}
		nodes[arrIdx] = node;

		return node;
	}
	static int searchIdx(int start, int end, int target){
		int idx = 0;
		for(int i = start ; i <= end ; i++){
			if(in[i] == target){
				idx = i;
				break;
			}
		}
		return idx;
	}
	static class Node{
		int middle;
		int left;
		int right;

		Node(int m){
			this.middle = m;
			this.left = -1;
			this.right = -1;
		}
	}
}
