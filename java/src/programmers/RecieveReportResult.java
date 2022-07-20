package programmers;  // 신고 결과 받기
import java.util.*;

public class RecieveReportResult {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 배열 생성 (0으로 자동 초기화)
        int[] answer = new int[id_list.length];


        // HashMap 생성 (user: 신고당한 횟수)
        HashMap<String, Integer> reports = new HashMap<>(id_list.length);

        for(int i = 0;i < id_list.length;i++){
            reports.put(id_list[i],0);
        }

        // 신고 중복 제거(배열->리스트->해시셋)
        HashSet<String> report1 = new HashSet<>(Arrays.asList(report));
        String[] report2 = report1.toArray(new String[0]);

        for(int i = 0; i< report2.length;i++){
            String[] users = report2[i].split(" ");
            reports.put(users[1], reports.get(users[1]) + 1);
        }

        for(int i = 0; i< report2.length;i++){
            String[] users = report2[i].split(" ");
            if (reports.get(users[1]) >= k){
                answer[Arrays.asList(id_list).indexOf(users[0])] += 1;
            }
        }
        return answer;
    }
}
