import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);    // 첫 번째 수 넣어놓기
        
        // 스택에 맨 위 값 확인하고 다르면 push
        for(int i = 1 ; i < arr.length ; i++){
            if(!st.peek().equals(arr[i])) st.push(arr[i]);
        }
        
        // 스택 사이즈와 같은 배열에 넣기
        int[] answer = new int[st.size()];
        for(int i = st.size() - 1 ; i >= 0 ; i--){
            answer[i] = st.pop();
        }

        return answer;
    }
}