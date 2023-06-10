import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] arr = new int[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = 0;
        while(true){
            String line = br.readLine();
            if(line == null || line.equals("")) break;
            arr[idx++] = Integer.parseInt(line);
        }
        after(0, idx-1);

        System.out.print(sb);
    }

    static void after(int start, int end) {
        if (start > end)
            return;

        int mid = start + 1;
        while (mid <= end && arr[mid] < arr[start]){
            mid++;
        }
        after(start + 1, mid - 1);
        after(mid, end);
        sb.append(arr[start]).append("\n");
    }
}

