package pro_array;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        FindBiggestNumber findBiggestNumber = new FindBiggestNumber();
        System.out.println(Arrays.toString(findBiggestNumber.solution(new int[]{9, 10, 11, 8})));
    }
}
