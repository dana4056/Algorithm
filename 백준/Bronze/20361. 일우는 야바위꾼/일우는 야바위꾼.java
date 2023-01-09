import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 냐옹이의 야바위게임
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {   
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // 입력받기 위한 객체 생성(버퍼 사용)
		StringBuilder sb = new StringBuilder();		// 출력을 메모리 낭비 없이 하기 위한 객체 생성
				
		
        StringTokenizer st = new StringTokenizer(in.readLine());	// 입력을 공백 기준으로 나눠 받기

        int N = Integer.parseInt(st.nextToken());		// 종이컵 개수
        int X = Integer.parseInt(st.nextToken());		// 간식 위치
        int K = Integer.parseInt(st.nextToken());		// 컵 이동 횟수

        int A, B;						// 이동할 컵 위치 담을 변수 생성
        for(int k = 0 ; k < K ; k++) {  // 컵 이동 횟수(K)만큼 반복
            st = new StringTokenizer(in.readLine());	// 입력을 공백 기준으로 나눠 받기

            A = Integer.parseInt(st.nextToken());		// 컵 위치 1
            B = Integer.parseInt(st.nextToken());		// 컵 위치 2

            if(A != X && B != X) continue;  // 입력받은 두 컵의 위치에 간식이 없으면 아무일 X

            if(A == X) X = B;				// 두 컵 중 A에 간식이 있다면 간식 위치 B로 업데이트
            else if(B == X) X = A;			// 두 컵 중 B에 간식이 있다면 간식 위치 A로 업데이트
        }

		System.out.println(X);  // 정답 String 출력
	}
}
