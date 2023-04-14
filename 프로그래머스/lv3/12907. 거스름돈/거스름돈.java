class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        
        int[][] DP = new int[money.length+1][n+1];
        
        for(int i = 0 ; i < money.length+1 ; i++){
            DP[i][0] = 1;
        }
        
        for(int i = 1 ; i < money.length + 1 ; i++){
            for(int j = 1 ; j < n+1 ; j++){
                // int num = j - i;
                // DP[i][j] = DP[i-1][j];
                if(j-money[i-1] >= 0){
                    DP[i][j] = DP[i-1][j] + DP[i][j-money[i-1]];
                    
                }else{
                    DP[i][j] = DP[i-1][j];
                }
                // if( num >= 0){
                //     DP[i][j] = DP[i-1][j] + DP[j][num];
                // }
            }
        }
        
        // for(int i  = 1 ; i < money.length+1 ; i++){
        //     answer += DP[i][n];
        // }
        
//         for(int i = 1 ; i < money.length+1 ; i++){
//             for(int j = 1 ; j < n+1 ; j++){
//                 System.out.print(DP[i][j]);
//             }
//             System.out.println();
//         }
        
        
//         System.out.println(DP[money.length][n]);
        
        return DP[money.length][n];
    }
}