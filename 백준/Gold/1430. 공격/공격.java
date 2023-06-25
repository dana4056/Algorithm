import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NRDXY = br.readLine().split(" ");
		int N = Integer.parseInt(NRDXY[0]);		// 탑 개수
		int R = Integer.parseInt(NRDXY[1]);		// 사정거리
		int D = Integer.parseInt(NRDXY[2]);		// 초기 에너지
		int er = Integer.parseInt(NRDXY[3]);		// 적 row
		int ec = Integer.parseInt(NRDXY[4]);		// 적 col

		Queue<Tower> q = new LinkedList<>();
		List<Tower> towers = new ArrayList<>();
		double power = 0;

		for(int i = 0 ; i < N ; i++){
			String[] RC = br.readLine().split(" ");
			int tr = Integer.parseInt(RC[0]);
			int tc = Integer.parseInt(RC[1]);
			double dis = Math.sqrt(Math.pow((er - tr), 2) + Math.pow((ec - tc), 2));

			if (dis <= R){
				power += D;
				q.add(new Tower(tr, tc, 0));
			}else{
				towers.add(new Tower(tr, tc, -1));
			}
		}

		while (!q.isEmpty()){
			Tower now = q.poll();

			for(int i = towers.size()-1 ; i >= 0 ; i--){
				Tower next = towers.get(i);
				double dis = Math.sqrt(Math.pow((now.row - next.row), 2) + Math.pow((now.col - next.col), 2));
				if(next.level < 0 && dis <= R){
					next.level = now.level + 1;
					power += D / Math.pow(2, next.level);
					q.add(next);
					towers.remove(i);
				}
			}
		}
		System.out.println(power);
	}
    
	private static class Tower{
		int row;
		int col;
		int level;

		Tower(int r, int c, int l){
			this.row = r;
			this.col = c;
			this.level = l;
		}
	}
}


