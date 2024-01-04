package pro_realization;

import java.util.Arrays;

public class PaintOver {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        boolean[] isPaintOver = new boolean[n];
        Arrays.fill(isPaintOver, true);
        for (int s : section) {
            isPaintOver[s - 1] = false;
        }

        for (int i = 0; i < n; i++) {
            if (isPaintOver[i]) continue;
            for (int j = 0; j < m; j++) {
                if (i + j >= n) break;
                isPaintOver[i + j] = true;
            }
            answer++;
        }

        return answer;
    }
}
