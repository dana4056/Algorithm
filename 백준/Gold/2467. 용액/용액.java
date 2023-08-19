import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String[] line = br.readLine().split(" ");
        for(int i = 0 ;i < N ; i++){
            arr[i] = Integer.parseInt(line[i]);
        }

        int MIN = Integer.MAX_VALUE;
        int gap = 0;
        int num1 = 0, num2 = 0;

        for(int i = 0 ; i  < N ; i++){
            int idx = Arrays.binarySearch(arr, arr[i] * -1);
            if(idx < 0){
                idx = (idx + 1) * -1;
                if(idx >= N) idx = N-1;

                if(idx == i){
                    // 찾은 인덱스 - 1
                    if(idx - 1 != i && idx - 1 >= 0) {
                        gap = Math.abs(arr[i] + arr[idx - 1]);
                        if(gap < MIN){
                            MIN = gap;
                            num1 = arr[i] < arr[idx - 1] ? arr[i] : arr[idx - 1];
                            num2 = arr[i] < arr[idx - 1] ? arr[idx - 1] : arr[i];
                        }
                    }
                    // 찾은 인덱스 +1
                    if(idx + 1 != i && idx + 1 < N){
                        gap = Math.abs(arr[i] + arr[idx+1]);
                        if(gap < MIN){
                            MIN = gap;
                            num1 = arr[i] < arr[idx+1] ? arr[i] : arr[idx+1];
                            num2 = arr[i] < arr[idx+1] ? arr[idx+1] : arr[i];
                        }
                    }
                }else{
                    // 찾은 인덱스
                    gap = Math.abs(arr[i] + arr[idx]);
                    if(gap < MIN){
                        MIN = gap;
                        num1 = arr[i] < arr[idx] ? arr[i] : arr[idx];
                        num2 = arr[i] < arr[idx] ? arr[idx] : arr[i];
                    }
                    // 찾은 인덱스 - 1
                    if(idx - 1 != i && idx - 1 >= 0) {
                        gap = Math.abs(arr[i] + arr[idx - 1]);
                        if(gap < MIN){
                            MIN = gap;
                            num1 = arr[i] < arr[idx - 1] ? arr[i] : arr[idx - 1];
                            num2 = arr[i] < arr[idx - 1] ? arr[idx - 1] : arr[i];
                        }
                    }
                }

            }else{
                num1 = arr[i] < arr[idx] ? arr[i] : arr[idx];
                num2 = arr[i] < arr[idx] ? arr[idx] : arr[i];
                break;
            }
        }

        System.out.println(num1 + " " + num2);
    }
}
