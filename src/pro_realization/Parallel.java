package pro_realization;

import java.util.Arrays;
import java.util.Comparator;

public class Parallel {

    static float calculateSlope(int[] x, int[] y) {
        return (float) (x[1] - y[1]) / (x[0] - y[0]);
    }

    public int solution(int[][] dots) {
        int answer = 0;

        float[] leftSlope = new float[2];
        float[] rightSlope = new float[2];
        Arrays.sort(dots, Comparator.comparingInt(a -> a[0]));

        leftSlope[0] = calculateSlope(dots[0], dots[1]);
        leftSlope[1] = calculateSlope(dots[0], dots[2]);
        rightSlope[0] = calculateSlope(dots[3], dots[1]);
        rightSlope[1] = calculateSlope(dots[3], dots[2]);

       if (leftSlope[0] == rightSlope[1] || leftSlope[1] == rightSlope[0]) return 1;

        return answer;
    }
}
