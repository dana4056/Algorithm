import java.io.*;
import java.util.*;

public class Main {
    static HashSet<Integer>[] graph;
    static Queue<Change> change =new LinkedList<>();
    static Queue<Tomato> q = new LinkedList<>();
    static int[] days;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NMKQ = br.readLine().split(" ");
        N = Integer.parseInt(NMKQ[0]);  // 토마토
        int M = Integer.parseInt(NMKQ[1]);  // 연결 쌍
        int K = Integer.parseInt(NMKQ[2]);  // 익은 토마토
        int Q = Integer.parseInt(NMKQ[3]);  // 상태변화 수

        graph = new HashSet[N+1];
        days = new int[N+1];
        for(int i = 1 ; i <= N ; i++){
            graph[i] = new HashSet<>();
            days[i] = -1;
        }

        for(int i = 0 ; i < M ; i++){
            String[] AB = br.readLine().split(" ");
            int A = Integer.parseInt(AB[0]);
            int B = Integer.parseInt(AB[1]);

            graph[A].add(B);
            graph[B].add(A);
        }

        // 익은 토마토 표시 및 큐에 넣어
        String[] ik = br.readLine().split(" ");
        for(String t: ik){
            int tomato = Integer.parseInt(t);
            days[tomato] = 0;
            q.add(new Tomato(tomato, 0));
        }


        // 연결 상태 변화 정보
        for(int i = 0; i < Q ; i++){
            String[] TXY = br.readLine().split(" ");
            int T = Integer.parseInt(TXY[0]);
            int X = Integer.parseInt(TXY[1]);
            int Y = Integer.parseInt(TXY[2]);
            change.add(new Change(T, X, Y));
        }

        int now = 0;
        while(!q.isEmpty()){
            Tomato poll = q.poll();
            if(poll.time > now){
                now = poll.time;
                updateGraph(now);
            }

            for(int next: graph[poll.num]){
                if(days[next] == -1){
                    days[next] = poll.time + 1;
                    q.add(new Tomato(next, poll.time+1));
                }
            }

            if(q.isEmpty()){
                while(!change.isEmpty() && q.isEmpty()){
                    updateGraph(change.peek().day);
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 1 ; i <= N ; i++){
            bw.write(days[i]+" ");
        }
        bw.flush();   //남아있는 데이터를 모두 출력시킴
        bw.close();   //스트림을 닫음
    }

    private static void updateGraph(int day) {
       HashSet<Integer> check = new HashSet<>();
        while(true){
            if(!change.isEmpty() && change.peek().day == day){
                Change poll = change.poll();
                Integer a = poll.a;
                Integer b = poll.b;

                if(graph[a].contains(b) || graph[b].contains(a)){   //연결 해제
                    graph[a].remove(b);
                    graph[b].remove(a);
                }
                else{      // 연결
                    if(days[a] != -1 && days[b] == -1){
                        check.add(b);
                        q.add(new Tomato(b, day+1));
                    }else if(days[b] != -1 && days[a] == -1){
                        check.add(a);
                        q.add(new Tomato(a, day+1));
                    }
                    graph[a].add(b);
                    graph[b].add(a);
                }
            }else{
                break;
            }
        }

        for(int n : check){
            days[n] = day + 1;
        }
    }


    static class Tomato{
        int num;
        int time;

        Tomato(int n, int t){
            this.num = n;
            this.time = t;
        }
    }

    static class Change{
        int day;
        int a;
        int b;

        Change(int d, int a, int b){
            this.day = d;
            this.a = a;
            this.b = b;
        }
    }
}
