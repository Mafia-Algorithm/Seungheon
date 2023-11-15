package pro_realization;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        ContinuousNumber continuousNumber = new ContinuousNumber();
        System.out.println(Arrays.toString(continuousNumber.solution(5, 15)));
    }
}
