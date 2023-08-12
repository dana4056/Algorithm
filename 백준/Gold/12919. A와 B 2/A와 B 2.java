import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int sLen, tLen;
    static String s, t;
    static boolean find;
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();
        tLen = t.length();
        sLen = s.length();

        checkString(t, tLen);

        if(find){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }

    static void checkString(String str, int len) {
        if(str.length() == sLen) {
            if(str.equals(s)) {
                find = true;
            }
            return;
        }

        if(str.charAt(len-1) == 'A') {
            checkString(str.substring(0, len - 1), len - 1);
        }

        if(str.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(str.substring(1, len));
            checkString(sb.reverse().toString(), len - 1);
        }
    }
}
