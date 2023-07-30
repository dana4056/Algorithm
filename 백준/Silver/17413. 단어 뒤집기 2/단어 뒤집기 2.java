import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();

		boolean tagMode = false;
		StringBuilder tmp = new StringBuilder();
		for(int i = 0 ; i < str.length() ; i++){
			char ch = str.charAt(i);
			if(ch == '<'){
				sb.append(tmp.reverse());
				tmp.delete(0, tmp.length());

				tagMode = true;
				sb.append(ch);
			}else if(ch == '>'){
				sb.append(ch);
				tagMode = false;
			}else{
				if(tagMode){
					sb.append(ch);
				}else{
					if(ch != ' ' && i != str.length() -1){
						tmp.append(ch);
					}else{
						if(i == str.length() -1){
							tmp.append(ch);
							sb.append(tmp.reverse());
						}else{
							sb.append(tmp.reverse()).append(' ');
						}
						tmp.delete(0, tmp.length());
					}
				}
			}
		}

		System.out.println(sb);
	}
}
