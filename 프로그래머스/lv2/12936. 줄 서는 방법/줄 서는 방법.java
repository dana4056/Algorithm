import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        
		ArrayList<Integer> nums = new ArrayList<>();
		int[] answer = new int[n];
        
		for(int i = 0 ; i < n ; i++){
			nums.add(i+1);
		}

		for(int i = n ; i > 0 ; i--) {
			int idx = 0;
			int num = nums.get(idx);
			long frontNum = fact(i-1);

			while(k - frontNum > 0){
				k -= frontNum;
				idx += 1;
				num = nums.get(idx);
			}
			nums.remove(new Integer(num));
			answer[Math.abs(n-i)] = num;
		}

        return answer;
    }
    
	static long fact(int num){
		long fact = 1;

		for(int i = num ; i>0 ; i--){
			fact *= i;
		}
		return fact;
	}
}