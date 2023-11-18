package pro_realization;

import pro_array.MakeTwoDimension;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        MakeTwoDimension makeTwoDimension = new MakeTwoDimension();
        System.out.println(Arrays.deepToString(makeTwoDimension.solution(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8},
                2
        )));
    }
}
