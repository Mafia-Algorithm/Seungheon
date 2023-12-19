package pro_sort;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        FailPercent failPercent = new FailPercent();
        System.out.println(Arrays.toString(failPercent.solution(
                5,
                new int[]{2, 1, 2, 6, 2, 4, 3, 3}
        )));
    }
}
