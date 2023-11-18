package pro_array;

import java.util.ArrayList;
import java.util.Arrays;

public class MockTest {
    public int[] solution(int[] answers) {
        int[][] patterns = {
                {1, 2, 3, 4, 5}, // first student's pattern
                {2, 1, 2, 3, 2, 4, 2, 5}, // second student's pattern
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5} // third student's pattern
        };

        int[] score = new int[patterns.length];
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < patterns.length; j++) {
                if (answers[i] == patterns[j][i % patterns[j].length]) {
                    score[j]++;
                }
            }
        }

        int maxScore = Arrays.stream(score).max().getAsInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (score[i] == maxScore) {
                list.add(i + 1);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
