package pro_sort;

import java.util.Arrays;

public class Knumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int m = 0; m < commands.length; m++) {
            int i = commands[m][0];
            int j = commands[m][1];
            int k = commands[m][2];

            int[] slice = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(slice);

            answer[m] = slice[k - 1];
        }

        return answer;
    }
}
