import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] abcdef = br.readLine().split(" ");
        int a = Integer.parseInt(abcdef[0]);
        int b = Integer.parseInt(abcdef[1]);
        int c = Integer.parseInt(abcdef[2]);
        int d = Integer.parseInt(abcdef[3]);
        int e = Integer.parseInt(abcdef[4]);
        int f = Integer.parseInt(abcdef[5]);

        int x = (c * e - b * f) / (a * e - b * d);
        int y = (c * d - a * f) / (b * d - a * e);
        sb.append(x).append(" ").append(y);

        System.out.println(sb);
    }
}
