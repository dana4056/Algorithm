import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int MIN = Integer.MAX_VALUE, MAX = Integer.MIN_VALUE;
    static int[] num;
    static boolean[] visited;
    static StringBuilder operStr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        num = new int[N];
        visited = new boolean[N-1];

        String[] nums = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++){
            num[i] = Integer.parseInt(nums[i]);
        }
        operStr = new StringBuilder();
        String[] opers = br.readLine().split(" ");
        for(int i = 0 ; i < Integer.parseInt(opers[0]) ; i++){
            operStr.append("+");
        }
        for(int i = 0 ; i < Integer.parseInt(opers[1]) ; i++){
            operStr.append("-");
        }
        for(int i = 0 ; i < Integer.parseInt(opers[2]) ; i++){
            operStr.append("*");
        }
        for(int i = 0 ; i < Integer.parseInt(opers[3]) ; i++){
            operStr.append("/");
        }

        perm(1, num[0]);

        sb.append(MAX).append("\n").append(MIN);
        System.out.println(sb);
    }

    private static void perm(int cnt, int num) {
        if(cnt == N){
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        char latest = ' ';
        for(int i = 0 ; i < operStr.length() ; i++){
            char oper = operStr.charAt(i);
            if(!visited[i] && oper != latest){
                visited[i] = true;
                latest = operStr.charAt(i);

                perm(cnt+1, calculation(oper, cnt, num));
                visited[i] = false;
            }
        }
    }

    private static int calculation(char oper, int cnt, int n) {
        int cal = 0;
        switch (oper){
            case '+':
                cal =  n + num[cnt];
                break;
            case '-':
                cal =  n - num[cnt];
                break;
            case '*':
                cal =  n * num[cnt];
                break;
            case '/':
                if(n < 0){
                    cal =  -1 * ((-1 * n) / num[cnt]);
                }else{
                    cal =  n / num[cnt];
                }
                break;
        }
        return cal;
    }
}
