package pro_dfs;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        TravelRoutine travelRoutine = new TravelRoutine();
        System.out.println(Arrays.toString(travelRoutine.solution(
                new String[][]{{"ICN", "AAA"},{"ICN", "CCC"},{"CCC", "DDD"},{"AAA", "BBB"},{"AAA", "BBB"},{"DDD", "ICN"},{"BBB", "AAA"}}
        )));
    }
}
