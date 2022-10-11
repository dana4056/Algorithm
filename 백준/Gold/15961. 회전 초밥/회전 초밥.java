import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//MainB15961_회전초밥
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] Ndkc = br.readLine().split(" ");
		int N = Integer.parseInt(Ndkc[0]);	//벨트 위 접시 수
		int d = Integer.parseInt(Ndkc[1]);	//초밥의 가짓수
		int k = Integer.parseInt(Ndkc[2]);	//연속해서 먹는 접시 수
		int c = Integer.parseInt(Ndkc[3]);	//쿠폰 번호
		int MAX = -9999;
		
		int[] containCnt = new int[d+1];
		int[] belt = new int[N];
		for(int i = 0 ; i < N ; i++) {
			int n = Integer.parseInt(br.readLine()); //접시 번호
			
			belt[i] = n;
		}
		
		int num = 1;
		Queue<Integer> q = new LinkedList<Integer>();
		//첫 번떄 시행 시 (큐가 다 비어있을 때)
		for(int i = 0 ; i < k ; i++) {
			if(i != 0 && containCnt[belt[i]] == 0) {
				num++;  //종류 개수 카운트
			}
			q.add(belt[i]);
			containCnt[belt[i]] += 1;
		}
		//두 번째 시행부터는 앞에꺼 빼고 뒤에꺼 추가하면서 확인
		for(int i = 1 ; i < N ; i++) {
			int coupon = 0;
			int poll = q.poll();
			containCnt[poll]--;
			if(containCnt[poll] == 0) num--;
			
			int end = i+k-1;
			if(i>N-k) end -= N;	// 마지막 인덱스가 범위를 넘어갈 때
		
			if(containCnt[belt[end]] == 0) num++;
			q.add(belt[end]);
			containCnt[belt[end]]++;
			
			if(containCnt[c] == 0) coupon = 1; //쿠폰이 포함되지 않은 경우일 때
	
			if(num+coupon > MAX) {
				MAX = num+coupon;
			}
		}
		
		System.out.println(MAX);
		
	}
}