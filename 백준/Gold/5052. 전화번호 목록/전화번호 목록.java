import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 0 ; tc<TC ; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			String num = null;
			Map<Character, List<String>> map = new HashMap<>();
			boolean isStop = false;
			
			for(int i = 0 ; i < n ; i++) {
			
				num = br.readLine();
				
				if(isStop) continue;
				num = num.replace(" ", "");
				
				char f = num.charAt(0);
				
				//맵에 추가
				if(!map.containsKey(f)) {
					List<String> list = new ArrayList<>();
					list.add(num);
					
					map.put(f, list);
				}else {
					
					List<String> startF = map.get(f);
					
					for(String s: startF) {
						if(s.length() >= num.length() ) {
							if(s.substring(0, num.length()).equals(num)) {
								System.out.println("NO");
								isStop = true;
								break;
							}							
						}else {
							if(num.substring(0, s.length()).equals(s)) {
								System.out.println("NO");
								isStop = true;
								break;
							}
						}
					
					}
				}
				if(!isStop) map.get(f).add(num);
			}
			if(!isStop) System.out.println("YES");
		}
	}
}
