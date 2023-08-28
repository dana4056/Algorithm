import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    static int row = 3, col = 3;
    static int nRow, nCol;
    static int[][] arr = new int[100][100];
    static Map<Integer, Integer> map = new HashMap<>();
    static PriorityQueue<Number> q = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] RCK = br.readLine().split(" ");
        int R = Integer.parseInt(RCK[0]) - 1;
        int C = Integer.parseInt(RCK[1]) - 1;
        int K = Integer.parseInt(RCK[2]);

        for(int i = 0 ; i < row ; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0 ; j < col ; j++){
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }


        int time = 0;
        while(arr[R][C] != K && time <= 100) {
            // 행개수 열개수 비교
            if(row >= col) rOperation();
            else cOperation();
            time++;
        }

        System.out.println(time > 100 ? -1 : time);

    }

    private static void rOperation() {
        nCol = col;
        for(int i = 0 ; i < row ; i++){
            // 등장 횟수 카운트 -> map에 put
            for(int j = 0 ; j < col ; j++){
                int num = arr[i][j];
                if(num == 0) continue;
                if(map.containsKey(num)){
                    int cnt = map.get(num);
                    map.put(num, cnt + 1);
                }else{
                    map.put(num, 1);
                }
            }
            // Q에 add
            map.forEach((key, value) ->{
                q.add(new Number(key, value));
            });

            // 배열 삽입
            insertArr('R', i);
            map.clear();
        }
        col = nCol;
    }

    private static void cOperation() {
        nRow = row;
        for(int i = 0 ; i < col ; i++){
            // 등장 횟수 카운트 -> map에 put
            for(int j = 0 ; j < row ; j++){
                int num = arr[j][i];
                if(num == 0) continue;
                if(map.containsKey(num)){
                    int cnt = map.get(num);
                    map.put(num, cnt + 1);
                }else{
                    map.put(num, 1);
                }
            }
            // Q에 add
            map.forEach((key, value) ->{
                q.add(new Number(key, value));
            });

            // 배열 삽입
            insertArr('C', i);
            map.clear();
        }
        row = nRow;
    }

    private static void insertArr(char ch, int n) {
        int idx = map.size() * 2;
        if(idx > 100) idx = 100;

        Number poll = null;
        if(ch == 'R'){
            for(int c = 0 ; c < Math.max(idx, col) ; c++){
                if(c % 2 == 0) {
                    if(!q.isEmpty()){
                        poll = q.poll();
                        arr[n][c] = poll.num;
                    }else{
                        poll = null;
                        arr[n][c] = 0;
                    }
                }else{
                    arr[n][c] = poll != null ? poll.cnt : 0;
                }
            }
            nCol = Math.max(nCol, idx);
        }else{
            for(int r = 0 ; r < Math.max(idx, row) ; r++){
                if(r % 2 == 0) {
                    if(!q.isEmpty()){
                        poll = q.poll();
                        arr[r][n] = poll.num;
                    }else{
                        poll = null;
                        arr[r][n] = 0;
                    }
                }else{
                    arr[r][n] = poll != null ? poll.cnt : 0;
                }
            }
            nRow = Math.max(nRow, idx);
        }
    }

    static class Number implements Comparable<Number>{
        int num;
        int cnt;

        Number(int n, int c){
            this.num = n;
            this.cnt = c;
        }

        @Override
        public int compareTo(Number n){
            if(this.cnt == n.cnt){
                return this.num - n.num;
            }
            return this.cnt - n.cnt;
        }
    }
}
