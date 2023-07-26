import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] graph;
    static StringBuilder middle = new StringBuilder();
    static StringBuilder before = new StringBuilder();
    static StringBuilder after = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new char[N][2];

        for(int i = 0 ;i < N ; i++){
            String PC1C2 = br.readLine();
            char parent = PC1C2.charAt(0);
            char left = PC1C2.charAt(2);
            char right = PC1C2.charAt(4);

            graph[parent-65][0] = left;
            graph[parent-65][1] = right;
        }

        DFS('A');

        System.out.println(before);
        System.out.println(middle);
        System.out.print(after);
    }

    private static void DFS(char ch) {
        before.append(ch);

        char left = graph[ch-65][0];
        char right = graph[ch-65][1];

        if(left != '.'){
            DFS(left);
        }
        middle.append(ch);

        if(right != '.'){
            DFS(right);
        }
        after.append(ch);
    }
}
