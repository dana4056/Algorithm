import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//MainB9205_맥주마시면서걸어가기
public class Main {

	static List<int[]> stores;
	static int fr, fc;
	static int ans = 0;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int TC = Integer.parseInt(br.readLine());
        
        for(int tc = 1 ; tc <= TC ; tc++) {
        	ans = 0;
            
            int n = Integer.parseInt(br.readLine()); //편의점 개수
            
            // 상근이 집 좌표
            String[] home = br.readLine().split(" ");
            int hc = Integer.parseInt(home[0]);
            int hr = Integer.parseInt(home[1]);
            
            stores = new ArrayList<int[]>();
            for(int i = 0 ; i < n ; i++) {
                // 편의점 좌표
                String[] store = br.readLine().split(" ");
                int sc = Integer.parseInt(store[0]);    
                int sr = Integer.parseInt(store[1]);
                
                // x,y,방문여부
                stores.add(new int[]{sr,sc,0});
            }
            
            // 락페 좌표
            String[] festival = br.readLine().split(" ");
            fc = Integer.parseInt(festival[0]);
            fr = Integer.parseInt(festival[1]);
            
            boolean isStoreInRange = false;
            boolean isHomeInRange = false;
            
            if(calDistance(fr, fc, hr, hc) <= 1000) {
            	isHomeInRange = true;
            	System.out.println("happy");
            	continue;
            }
            
            for(int[] s:stores) {
        		int r = s[0];
        		int c = s[1];
            	if(calDistance(fr, fc, r, c) <= 1000) {
            		isStoreInRange = true;
            		break;
            	}
            }
            
            if(!isStoreInRange && !isHomeInRange) {
            	System.out.println("sad");
            	continue;
            }else {
            	BFS(hr, hc);
            	
            	if(ans == 1) {
            		System.out.println("happy");
            	}else {
            		System.out.println("sad");
            	}
            }
        }
    }
    
    private static void BFS(int hr, int hc) {
    	Queue<int[]> q = new LinkedList<int[]>();
    	q.add(new int[] {hr,hc,0});
    	
    	while(q.size() != 0) {
    		int[] now = q.poll();
    		int nrow = now[0];
    		int ncol = now[1];
    		now[2] = 1;
    		
        	if(calDistance(nrow, ncol, fr, fc) <= 1000) {
        		ans = 1;
        		return;
        	}
    		
        	for(int[] s:stores) {
        		int r = s[0];
        		int c = s[1];
        		int visited = s[2];
        		
        		// 현재 위치에서 갈 수 있고 안가본 편의점이면
        		if(calDistance(nrow, ncol, r, c) <= 1000 && visited == 0 && ans == 0) {
        			q.add(s);
        		}
        	}
    	}
	}

    // x 좌표의 차이 + y 좌표의 차이 
    public static int calDistance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}