package pro_heap;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        HallOfFame hallOfFame = new HallOfFame();
        System.out.println(Arrays.toString(hallOfFame.solution(
                3,
                new int[]{10, 100, 20, 150, 1, 100, 200}
        )));
    }
}
