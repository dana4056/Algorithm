import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		List<String> dict = new ArrayList<>();
		String word = br.readLine();
		while(!word.equals("-")) {
			dict.add(word);
			word = br.readLine();
		}

		List<String> arr = new ArrayList<>();
		String str = br.readLine();
		while(!str.equals("#")) {
			arr.add(str);
			str = br.readLine();
		}

		int cnt = 0;
		int[] boardCnt = new int[26];
		int[] totalCnt = new int[26];
		int[] wordCnt = new int[26];

		for(String board : arr){
			char[] chars = board.toCharArray();
			Arrays.sort(chars);
			board = new String(chars);

			Arrays.fill(boardCnt, 0);
			Arrays.fill(totalCnt, 0);

			for(int i = 0 ; i < board.length(); i++){
				boardCnt[board.charAt(i) - 65] += 1;
			}
			for(String w : dict){
				Arrays.fill(wordCnt, 0);
				boolean stop = false;
				for(int i = 0 ; i < w.length() ; i++){
					wordCnt[w.charAt(i) - 65] += 1;
					if(boardCnt[w.charAt(i) - 65] < wordCnt[w.charAt(i) - 65]){
						stop = true;
					}
				}
				if(!stop){
					for(int i = 0 ; i < 26 ; i++){
						if(wordCnt[i]>0){
							totalCnt[i] += 1;
						}
					}
				}
			}
			StringBuilder maxSB = new StringBuilder();
			StringBuilder minSB = new StringBuilder();
			int max = -1;
			int min = Integer.MAX_VALUE;

			for(int i = 0 ; i < board.length() ; i++){
				if(totalCnt[board.charAt(i)-65] > max){
					maxSB.delete(0, maxSB.length());
					if(maxSB.indexOf(board.charAt(i)+"") == -1){
						maxSB.append(board.charAt(i));
					}
					max = totalCnt[board.charAt(i)-65];
				}
				else if(totalCnt[board.charAt(i)-65] == max){
					if(maxSB.indexOf(board.charAt(i)+"") == -1){
						maxSB.append(board.charAt(i));
					}
				}

				if(totalCnt[board.charAt(i)-65] < min){
					minSB.delete(0, minSB.length());
					if(minSB.indexOf(board.charAt(i)+"") == -1){
						minSB.append(board.charAt(i));
					}
					min = totalCnt[board.charAt(i)-65];
				}
				else if(totalCnt[board.charAt(i)-65] == min){
					if(minSB.indexOf(board.charAt(i)+"") == -1){
						minSB.append(board.charAt(i));
					}
				}
			}
			sb.append(minSB).append(" ").append(min).append(" ").append(maxSB).append(" ").append(max).append("\n");
		}
		System.out.print(sb);
	}
}
