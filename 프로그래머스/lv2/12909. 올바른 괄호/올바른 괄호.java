import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
   
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()) {
                    answer = false;
                    break;
                }
                stack.pop();
            }
        }
        
        if(!stack.isEmpty()) answer = false;

        return answer;
    }
}