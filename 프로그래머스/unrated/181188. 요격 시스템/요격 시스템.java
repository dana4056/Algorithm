import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        ArrayList<Missile> missiles = new ArrayList<>();
        
        for(int i = 0; i < targets.length ; i++){
            missiles.add(new Missile(targets[i][0], targets[i][1]));
        }
        
        Collections.sort(missiles);
        
        int start = -1, end = -1;
        for(Missile m : missiles){
            if(m.start >= end ){
                // start = m.start;
                end = m.end;
                answer += 1;
            }
            else if(m.end < end){
                end = m.end;
            }
            start = m.start;
        }
        
        // System.out.println(missiles);
        
        return answer;
    }
    
    static public class Missile implements Comparable<Missile>{
        int start;
        int end;
        
        Missile(int s, int e){
            start = s;
            end = e;
        }
        
        public int compareTo(Missile m){
            return this.start - m.start;
        }
        
        public String toString(){
            return "["+start+","+end+"]";
        }
        
    }
}