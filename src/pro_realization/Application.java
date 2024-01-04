package pro_realization;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
       CharacterPoint characterPoint = new CharacterPoint();
        System.out.println(Arrays.toString(characterPoint.solution(
                new String[]{"left", "right", "up", "right", "right"},
                new int[]{11, 11}
        )));
    }
}
