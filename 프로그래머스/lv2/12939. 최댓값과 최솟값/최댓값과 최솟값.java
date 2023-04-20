class Solution {
    public String solution(String s) {
        int MAX = Integer.MIN_VALUE;
        int MIN = Integer.MAX_VALUE; 
        
        String[] arr = s.split(" ");
        
        for(String n: arr){
            int num = Integer.parseInt(n);
            MAX = Math.max(num, MAX);
            MIN = Math.min(num, MIN);
        }
        
        
        return MIN+" "+ MAX;
    }
}