package pro_stack;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        HateSameNumber hateSameNumber = new HateSameNumber();
        System.out.println(Arrays.toString(hateSameNumber.solution(new int[]{1, 1, 3, 3, 0, 1, 1})));
    }
}
