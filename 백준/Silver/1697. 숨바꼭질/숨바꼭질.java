import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

//MainB1697 숨바꼭질
public class Main {

	static Queue<Node> q;
	static int[] arr;
	static int K, MIN = 9999999;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());  //수빈
		K = Integer.parseInt(st.nextToken());  //동생
		
		arr = new int[100001];
		q = new ArrayDeque<Node>();
		
		BFS(N, 0);
		System.out.println(MIN);
	}

	private static void BFS(int n, int h) {
		if(n == K) {
			if(h < MIN) MIN = h;
			return;
		}
		if(arr[n] != 1) {
			if(n-1>=0 && n-1<100001) q.add(new Node(n-1, h+1)); //탐색할 다음 노드들 추가
			if(n+1>=0 && n+1<100001) q.add(new Node(n+1, h+1)); //탐색할 다음 노드들 추가
			if(2*n>=0 && 2*n<100001) q.add(new Node(2*n, h+1)); //탐색할 다음 노드들 추가
		}
		arr[n] = 1;
		if(!q.isEmpty()) {
			Node next = q.poll();
			BFS(next.getValue(), next.getHeight()); //다음 노드 탐색
			arr[n] = 0;
		}
	}
}


class Node{
	private int value;
	private int height;
	
	public Node(int value, int height) {
		super();
		this.value = value;
		this.height = height;
	}

	public int getValue() {
		return value;
	}

	public int getHeight() {
		return height;
	}
}
