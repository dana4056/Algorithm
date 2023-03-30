import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main
{
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int Max = 0;

        String str1 = br.readLine();
        String str2 = br.readLine();

        // 입력 문자열 -> 문자형 배열로
        char[] arr1 = new char[str1.length() + 1];
        char[] arr2 = new char[str2.length() + 1];

        for(int i = 1; i <= str1.length() ; i++){
            arr1[i] = str1.charAt(i-1);
        }
        for(int i = 1; i <= str2.length() ; i++){
            arr2[i] = str2.charAt(i-1);
        }

        // 문자열1과 문자열2를 자리별로 비교하면서 DP 테이블 갱신
        // 특정위치에서 두 문자가 같으면 이전 문자들이 몇개 같았는지 확인 -> 대각선 아래로 내려가는 방향
        int[][] DP = new int[str1.length() + 1][str2.length() + 1];

        for(int i = 1 ; i <= str1.length() ; i++){
            for(int j = 1 ; j <= str2.length() ; j++){
                if(arr1[i] == arr2[j]){
                    DP[i][j] = DP[i-1][j-1] + 1;
                    if(DP[i][j] > Max) Max = DP[i][j];
                }
            }
        }

        System.out.print(Max);
    }
}