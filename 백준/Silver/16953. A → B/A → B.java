import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] AB = br.readLine().split(" ");

        long A = Long.parseLong(AB[0]);
        long B = Long.parseLong(AB[1]);
        int ans = -1;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(A, 1));

        while (!q.isEmpty()){
            Node now = q.poll();
            long nv = now.value;
            int nh = now.height;

            if(nv == B){
                ans = nh;
                break;
            }

            if(nv * 2 <= B){
                q.add(new Node(nv * 2, nh + 1));
            }
            if(nv * 10 + 1 <= B){
                q.add(new Node(nv * 10 + 1, nh + 1));
            }
        }
        System.out.println(ans);


    }
    static class Node {
        long value;
        int height;

        Node(long v, int h){
            value = v;
            height = h;
        }
    }
}
