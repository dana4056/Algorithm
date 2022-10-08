import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main{
	
	static int p;
	static int[] chcnts;
	static String dna;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input1 = in.readLine().split(" ");
		int s = Integer.parseInt(input1[0]);
		p = Integer.parseInt(input1[1]);
		
		dna = in.readLine().trim();
		
		String[] input2 = in.readLine().trim().split(" "); 
		Map<Character,Integer> map = new HashMap<>();

		map.put('A', Integer.parseInt(input2[0]));
		map.put('C', Integer.parseInt(input2[1]));
		map.put('G', Integer.parseInt(input2[2]));
		map.put('T', Integer.parseInt(input2[3]));
		
		
		chcnts = new int[4]; //A, C, G, T

		int cnt = 0;
		
		for(int i = 0 ; i <= s-p ; i++) {
			
			if(i == 0) {
				for(int j = 0 ;j < p;j++) {
					calCnts(j, 1);
				}
				if(map.get('A') > chcnts[0]) continue;
				if(map.get('C') > chcnts[1]) continue;
				if(map.get('G') > chcnts[2]) continue;
				if(map.get('T') > chcnts[3]) continue;
				cnt++;
			}
			else if(i-1>=0 && i+(p-1)<dna.length()) {
				calCnts(i-1, -1);
				calCnts(i+(p-1), 1);
				
				if(map.get('A') > chcnts[0]) continue;
				if(map.get('C') > chcnts[1]) continue;
				if(map.get('G') > chcnts[2]) continue;
				if(map.get('T') > chcnts[3]) continue;
				cnt++;	
			}
		}
		System.out.println(cnt);
	}
	
	static void calCnts(int idx, int n) {
		switch(dna.charAt(idx)) {
		case 'A': chcnts[0] += n; break;
		case 'C': chcnts[1] += n; break;
		case 'G': chcnts[2] += n; break;
		case 'T': chcnts[3] += n; break;
		}
	}
	
}
