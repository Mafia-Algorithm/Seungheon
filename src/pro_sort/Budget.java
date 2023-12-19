package pro_sort;

import java.util.Arrays;

public class Budget {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);

        for (int j : d) {
            budget -= j;
            if (budget < 0) break;
            answer++;
        }
        return answer;
    }
}
