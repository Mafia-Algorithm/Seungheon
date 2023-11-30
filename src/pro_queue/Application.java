package pro_queue;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        TurnArray turnArray = new TurnArray();
        System.out.println(Arrays.toString(turnArray.solution(new int[]{4, 455, 6, 4, -1, 45, 6}, "left")));
    }
}
