import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	
	static int N;
	static int ans = 999999;
	static int[] population;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());	  // 지역수
		int[] population = new int[N+1];		  // 각 지역 인구수 배열
		boolean[] visited = new boolean[N+1];		  // 각 지역 인구수 배열
		List<Area> areas = new ArrayList<Area>(); // 지역 리스트 

		String[] temp = br.readLine().split(" ");
		//인구수 배열 생성
		for(int i = 1 ; i <= N ; i++) {
			population[i] = Integer.parseInt(temp[i-1]);
		}
		
		for(int i = 1 ; i <= N ; i++) {
			String[] edge = br.readLine().split(" ");
			int n = Integer.parseInt(edge[0]);
			int[] conn = new int[n];
			for(int j = 0 ; j < n ; j++) {
				// i:구역번호  tmp:연결되어있는구역들
				int tmp = Integer.parseInt(edge[j+1]);
				conn[j] = tmp;
			}
			areas.add(new Area(i, conn));
		}
		
//		System.out.println(areas);
		
		
		for(int i = 0 ; i < (1<<N) ; i++) {
			List<Area> Aarea = new ArrayList<Area>(); // 지역 리스트 
			List<Area> Barea = new ArrayList<Area>(); // 지역 리스트 
			for(int j = 0 ; j < N ; j ++) {
				if((i & (1<<j)) != 0) {
					Aarea.add(areas.get(j));
				}else {
					Barea.add(areas.get(j));					
				}
			}
			
			//구역이 나뉘지 않았을 경우
			if(Aarea.size() == 0 || Barea.size() == 0) continue;
			
			Queue<Area> Aq = new LinkedList<Area>();
			Queue<Area> Bq = new LinkedList<Area>();
			Aq.add(Aarea.get(0));
			Bq.add(Barea.get(0));
			int Acnt = 0, Bcnt = 0;
			int Apop = 0 , Bpop = 0;
			while(Aq.size() != 0) {
				Acnt++;
				Area now = Aq.poll();
				visited[now.no] = true;
				Apop += population[now.no];
				
				for(int n : now.conn) {
					Area next = areas.get(n-1);
					if(!visited[next.no] && Aarea.contains(next) && !Aq.contains(next)) {
						Aq.add(next);						
					}
				}
			}
			
			visited = new boolean[N+1];
			if(Acnt != Aarea.size()) continue;
			
			while(Bq.size() != 0) {
				Bcnt++;
				Area now = Bq.poll();
				visited[now.no] = true;
				Bpop += population[now.no];
				
				for(int n : now.conn) {
					Area next = areas.get(n-1);
					if(!visited[next.no] && Barea.contains(next) && !Bq.contains(next)) {
						Bq.add(next);						
					}
				}
			}
			visited = new boolean[N+1];
			
			
			if(Bcnt != Barea.size()) continue;
			if(Math.abs(Apop - Bpop) < ans) {
				ans = Math.abs(Apop - Bpop);
			}

		}
		if(ans == 999999) {
			System.out.println(-1);
		}else {
			System.out.println(ans);			
		}
	}

}


class Area{
	int no;
	int[] conn;
	
	public Area(int no, int[] conn) {
		super();
		this.no = no;
		this.conn = conn;
	}
}