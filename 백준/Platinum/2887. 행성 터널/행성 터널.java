import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		parents = new int[N];

		PriorityQueue<Planet> xAxis = new PriorityQueue<>();
		PriorityQueue<Planet> yAxis = new PriorityQueue<>();
		PriorityQueue<Planet> zAxis = new PriorityQueue<>();

		for(int i = 0 ; i < N ; i++){
			parents[i] = i;
			String[] xyz = br.readLine().split(" ");
			int x = Integer.parseInt(xyz[0]);
			int y = Integer.parseInt(xyz[1]);
			int z = Integer.parseInt(xyz[2]);

			xAxis.add(new Planet(i, x));
			yAxis.add(new Planet(i, y));
			zAxis.add(new Planet(i, z));
		}

		PriorityQueue<Tunnel> tunnels = new PriorityQueue<Tunnel>();

		Planet x = xAxis.poll();
		Planet y = yAxis.poll();
		Planet z = zAxis.poll();
		for(int i = 0 ; i < N-1 ; i++){
			Planet nx = xAxis.poll();
			Planet ny = yAxis.poll();
			Planet nz = zAxis.poll();
			tunnels.add(new Tunnel(x.no, nx.no, Math.abs(x.axis - nx.axis)));
			tunnels.add(new Tunnel(y.no, ny.no, Math.abs(y.axis - ny.axis)));
			tunnels.add(new Tunnel(z.no, nz.no, Math.abs(z.axis - nz.axis)));
			x = nx; y = ny; z = nz;
		}

		int edge = 0;
		long cost = 0;
		while (edge < N-1){
			Tunnel now = tunnels.poll();
			int aRoot = getRoot(now.A);
			int bRoot = getRoot(now.B);

			if(aRoot == bRoot) continue;

			edge++;
			cost += now.dis;

			if(aRoot < bRoot){
				parents[bRoot] = aRoot;
			}else{
				parents[aRoot] = bRoot;
			}
		}

		System.out.println(cost);
	}

	private static int getRoot(int n) {
		if(n == parents[n]) return n;
		return getRoot(parents[n]);
	}

	static class Planet implements Comparable<Planet>{
		int no;
		int axis;

		Planet(int n, int a){
			this.no = n;
			this.axis = a;
		}

		public int compareTo(Planet p){
			return this.axis - p.axis;
		}
	}

	static class Tunnel implements Comparable<Tunnel>{
		int A;
		int B;
		int dis;

		Tunnel(int a, int b, int d){
			this.A = a;
			this.B = b;
			this.dis = d;
		}

		public int compareTo(Tunnel t){
			return this.dis - t.dis;
		}
	}
}
