import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
	static int N, M, K;
	static int[][] arr, nutrients;
	static int[] dr = {-1,-1,-1,0,0,1,1,1};
	static int[] dc = {-1,0,1,-1,1,-1,0,1};
	static PriorityQueue<Tree>[][] trees;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NMK = br.readLine().split(" ");
		N = Integer.parseInt(NMK[0]);
		M = Integer.parseInt(NMK[1]);
		K = Integer.parseInt(NMK[2]);

		arr = new int[N+1][N+1];
		nutrients = new int[N+1][N+1];
		trees = new PriorityQueue[N+1][N+1];

		for(int i = 1 ; i <= N ; i++){
			String[] line = br.readLine().split(" ");
			for(int j = 1 ; j <= N ; j++){
				arr[i][j] = 5;
				nutrients[i][j] = Integer.parseInt(line[j-1]);
				trees[i][j] = new PriorityQueue<>();
			}
		}

		for(int i = 0 ; i < M ; i++){
			String[] XYZ = br.readLine().split(" ");
			int x = Integer.parseInt(XYZ[0]);
			int y = Integer.parseInt(XYZ[1]);
			int z = Integer.parseInt(XYZ[2]);
			trees[x][y].add(new Tree(z, 1));
		}

		int year = 0;
		while(year < K){
			// 봄 & 여름
			for(int i = 1 ; i <= N ; i++){
				for(int j = 1 ; j <= N ; j++){
					int size = trees[i][j].size();
					if(size > 0){
						int nutrient = 0;
						for(int n = 0 ; n < size ; n++){
							Tree poll = trees[i][j].poll();
							int age = poll.age;
							int day = poll.day;

							if(age <= arr[i][j]){
								arr[i][j] -= age;
								trees[i][j].add(new Tree(age+1, day+1));
							}else{
								nutrient += age / 2;
							}
						}
						arr[i][j] += nutrient;
					}
				}
			}

			// 가을
			for(int i = 1 ; i <= N ; i++){
				for(int j = 1 ; j <= N ; j++){
					PriorityQueue<Tree> q = trees[i][j];
					int size = q.size();
					if(size > 0){
						List<Tree> list = new ArrayList<>(q);
						for(Tree tree: list){
							int age = tree.age, day = tree.day;
							if(age % 5 == 0){
								for(int k = 0 ; k < 8 ; k++){
									int nr = i+dr[k];
									int nc = j+dc[k];
									if(inRange(nr, nc)){
										trees[nr][nc].add(new Tree(1, day ));
									}
								}
							}
						}
					}
				}
			}

			// 겨울
			addNutrients();
			year += 1;
		}

		int cnt = 0;
		for(int i = 1 ; i <= N ; i++){
			for(int j = 1 ; j <= N ; j++){
				cnt += trees[i][j].size();
			}
		}

		System.out.println(cnt);
	}
	public static void addNutrients(){
		for(int i = 1 ; i <= N ; i++){
			for(int j = 1 ; j <= N ; j++){
				arr[i][j] += nutrients[i][j];
			}
		}
	}

	public static boolean inRange(int r, int c){
		if(r >= 1 && r <= N && c >= 1 && c <= N){
			return true;
		}
		return false;
	}

	private static class Tree implements Comparable<Tree>{
		int age;
		int day;

		Tree(int a, int d){
			this.age = a;
			this.day = d;
		}

		@Override
		public int compareTo(Tree t){
			if(this.day == t.day){
				return this.age - t.age;
			}else{
				return this.day - t.day;
			}
		}
	}
}
