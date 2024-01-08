package pro_realization;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        BestSet bestSet = new BestSet();
        System.out.println(Arrays.toString(bestSet.solution(2, 9)));
    }
}
