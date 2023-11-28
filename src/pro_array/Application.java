package pro_array;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        BestAlbum bestAlbum = new BestAlbum();
        System.out.println(Arrays.toString(bestAlbum.solution(
                new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500}
        )));
    }
}
