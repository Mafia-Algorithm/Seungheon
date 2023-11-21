package pro_array;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        RowColumnPlus rowColumnPlus = new RowColumnPlus();
        System.out.println(Arrays.deepToString(rowColumnPlus.solution(
                new int[][] {{1, 2}, {2, 3}},
                new int[][] {{3, 4}, {5, 6}}
        )));
    }
}
