package pro_array;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        MockTest mockTest = new MockTest();
        System.out.println(Arrays.toString(mockTest.solution(new int[]{1, 2, 3, 4, 5})));
    }
}
