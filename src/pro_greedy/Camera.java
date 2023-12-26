package pro_greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Camera {
    public int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));

        int max = routes[0][1];

        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] <= max && routes[i][1] >= max) {
                continue;
            }

            max = routes[i][1];
            answer++;
        }

        return answer;
    }
}
