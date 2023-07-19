import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        List<Integer> arr = new ArrayList<>();

        for(int tc = 0  ; tc < TC ; tc++){
            String cmds = br.readLine();
            int N = Integer.parseInt(br.readLine());
            int dir = 1;
            boolean error = false;

            String arrStr = br.readLine();
            String[] el = arrStr.substring(1, arrStr.length() - 1).split(",");

            arr.clear();

            for(int i = 0 ; i < N ; i++){
                arr.add(Integer.parseInt(el[i]));
            }

            for(int i = 0 ; i<cmds.length() ; i++){
                char cmd = cmds.charAt(i);

                if(cmd == 'R'){
                    dir *= -1;
                }else{
                    if(arr.size() > 0){
                        if(dir > 0){    //앞에서 하나 삭제
                            arr.remove(0);
                        }else{          //뒤에서 하나 삭제
                            arr.remove(arr.size()-1);
                        }
                    }else{
                        error = true;
                        sb.append("error\n");
                        break;
                    }
                }
            }

            if(!error){
                sb.append("[");
                if(arr.size() > 0){
                    if(dir == -1){
                        for(int i = arr.size()-1 ; i >= 0 ; i--){
                            sb.append(arr.get(i));
                            if(i != 0){
                                sb.append(",");
                            }
                        }
                    }else{
                        for(int i = 0 ; i < arr.size() ; i++){
                            sb.append(arr.get(i));
                            if(i != arr.size()-1){
                                sb.append(",");
                            }
                        }
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.print(sb);
    }
}
