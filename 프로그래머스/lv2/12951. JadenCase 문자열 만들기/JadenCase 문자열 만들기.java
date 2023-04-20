import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.toLowerCase());
        
        for(int i = 0 ; i < sb.length() ; i++){
            if(sb.charAt(i) == ' ') continue;
            
            if(i == 0 || sb.charAt(i - 1) == ' '){
                if(sb.charAt(i) - 0 >= 97){
                    sb.setCharAt(i,(char)(sb.charAt(i) - 32));
                }
            } 
        }
        
    
        // String[] tmp = s.split(" ");
        // System.out.println('a' - 0);
        // System.out.println('z' - 0);
        // System.out.println('A' - 0);
        // System.out.println('Z' - 0);
        // System.out.println('0' - 0);
        // System.out.println('9' - 0);
//         StringBuilder tmpSb = new StringBuilder();
//         for(String str : tmp){
//             tmpSb.setLength(0);
//             tmpSb.append(str.toLowerCase());
            
//             if(tmpSb.length() > 0){
//                 char first = tmpSb.charAt(0);
//                 if(first - 0 >= 97 && first - 0 <= 122){
//                     tmpSb.setCharAt(0, (char)(tmpSb.charAt(0) - 32));
//                 }

//                 sb.append(tmpSb).append(" ");
//             }
//         }
//         sb.deleteCharAt(sb.length()-1);
        
        return sb.toString();
    }
}