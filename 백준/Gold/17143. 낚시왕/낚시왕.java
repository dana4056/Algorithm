import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
	static int R, C, M;
	static Shark[][] arr;
	static List<Shark> sharks;
	static int[] dr = {0,-1,1,0,0}; // -,위,아래,오,왼
	static int[] dc = {0,0,0,1,-1}; // -,위,아래,오,왼
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] RCM = br.readLine().split(" ");
		
		R = Integer.parseInt(RCM[0]);
		C = Integer.parseInt(RCM[1]);
		M = Integer.parseInt(RCM[2]);
	
		arr = new Shark[R+1][C+1];
		sharks = new ArrayList<Shark>();
		
		for(int i = 0 ; i < M ; i++) {
			String[] temp = br.readLine().split(" ");
			int r = Integer.parseInt(temp[0]);
			int c = Integer.parseInt(temp[1]);
			int s = Integer.parseInt(temp[2]);
			int d = Integer.parseInt(temp[3]);
			int z = Integer.parseInt(temp[4]);
			
			Shark shark = new Shark(r, c, s, d, z);
			sharks.add(shark);
			arr[r][c] = shark;
		}
		int sum = 0;
		for(int col = 1 ; col <= C; col++) {
			for(int row = 1 ; row <= R ; row++) {
				if(arr[row][col] != null) {
					sum += arr[row][col].getSize();
					sharks.remove(arr[row][col]);
					arr[row][col] = null;
					break;
				}
			}
			moveShark();
		}
		
		System.out.println(sum);
	}

	private static void moveShark() {
		for(int i = 1 ; i<=R ; i++) {
			for(int j = 1 ; j <= C ; j++) {
				arr[i][j] = null;
			}
		}
		
		for(Shark s :sharks) {
			int row = s.getRow();
			int col = s.getCol();
			int speed = s.getSpeed();
			int dir = s.getDir();
			
			for(int i = 0 ; i < speed; i++) {
				int nr = row + dr[dir];
				int nc = col + dc[dir];
				
				if(inRange(nr,nc)) {
					row = nr;
					col = nc;
				}else { //범위 밖
					switch(dir) {
					case 1:
						dir = 2;
						break;
					case 2:
						dir = 1;
						break;
					case 3:
						dir = 4;
						break;
					case 4:
						dir = 3;
						break;
					}
					row = row + dr[dir];
					col = col + dc[dir];				
				}
			}
			s.setRow(row);
			s.setCol(col);
			s.setDir(dir);
		}
		

		int len = sharks.size();
		for( int i = len - 1 ; i >= 0; i--) {
			Shark s = sharks.get(i);
			
			int row = s.getRow();
			int col = s.getCol();
			int size = s.getSize();
			 
			if(arr[row][col] == null) {
				arr[row][col] = s;
			}
			else if(arr[row][col] != null && arr[row][col].getSize() < size) {
				sharks.remove(arr[row][col]);
				arr[row][col] = s;
			}else if (arr[row][col] != null && arr[row][col].getSize() > size) {
				sharks.remove(s);
			}
		}
			
	}

	private static boolean inRange(int nr, int nc) {
		if(nr > 0 && nr <= R && nc > 0 && nc <= C) {
			return true;
		}else {
			return false;			
		}
	}
}

class Shark {
	int row;
	int col;
	int speed;
	int dir;
	int size;
	
	public Shark(int row, int col, int speed, int dir, int size) {
		super();
		this.row = row;
		this.col = col;
		this.speed = speed;
		this.dir = dir;
		this.size = size;
	}
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getDir() {
		return dir;
	}
	public void setDir(int dir) {
		this.dir = dir;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

}
