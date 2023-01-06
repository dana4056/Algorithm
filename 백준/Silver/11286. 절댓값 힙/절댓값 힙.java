import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<value> pq = new PriorityQueue<>();
		
		int N = sc.nextInt();
		for(int i = 0 ; i < N ; i++) {
			int cmd = sc.nextInt();
			if(cmd != 0) {
				pq.add(new value(cmd));
			}else {
				if(pq.isEmpty()) {
					sb.append("0");
					sb.append("\n");
				}else {
					sb.append(pq.poll().origin);
					sb.append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}

class value implements Comparable<value> {
	int origin;
	int abs;
	
	public value(int origin) {
		super();
		this.origin = origin;
		this.abs = Math.abs(origin);
	}

	@Override
	public int compareTo(value o) {
		// TODO Auto-generated method stub
		return this.abs == o.abs?this.origin - o.origin:this.abs - o.abs;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}
