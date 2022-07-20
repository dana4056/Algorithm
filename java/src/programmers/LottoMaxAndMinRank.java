package programmers;  //로또의 최고 순위와 최저 순위
import java.util.*;

public class LottoMaxAndMinRank {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 0};
        int win_cnt = 0, zero_cnt = 0;

        // 당첨 번호 개수 계산
        for (int lotto: lottos){
            if(lotto == 0){
                zero_cnt += 1;
            }
            else if(Arrays.stream(win_nums).anyMatch(x -> x == lotto)){
                win_cnt += 1;
            }
        }

        int min_rank = 7 - win_cnt;
        int max_rank = 7 - (win_cnt + zero_cnt);

        if(min_rank == 7) min_rank = 6;
        if(max_rank == 7) max_rank = 6;


        answer = new int[]{max_rank, min_rank};

        return answer;
    }
}
