package pro_interception;

import java.util.Arrays;
import java.util.Comparator;

public class Interception {

    public static int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));

        int last = -1;
        for (int[] target : targets) {

            // 첫 번째 미사일은 무조건 가장 뒤에서 쏜다
            if (last == -1) {
                answer++;
                last = target[1] - 1;
                continue;
            }

            // 만약 이미 쏜 범위에 포함 되어 있다면 격추된 것으로 가정
            if (last >= target[0] && last <= target[1]) continue;

            answer++;
            last = target[1] - 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(
                new int[][]{
                        {4, 5},
                        {4, 8},
                        {10, 14},
                        {11, 13},
                        {5, 12},
                        {3, 7},
                        {1, 4}
                }
        ));
    }
}
