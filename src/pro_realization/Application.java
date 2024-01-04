package pro_realization;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
       ParkWalk parkWalk = new ParkWalk();
        System.out.println(Arrays.toString(parkWalk.solution(
                new String[]{"OSO","OOO","OXO","OOO"},
                new String[]{"E 2","S 3","W 1"}
        )));
    }
}
