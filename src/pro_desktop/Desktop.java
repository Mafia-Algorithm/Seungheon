package pro_desktop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Desktop {

    public static int[] solution(String[] wallpaper) {
        ArrayList<Integer> xPoint = new ArrayList<>();
        ArrayList<Integer> yPoint = new ArrayList<>();

        String[][] desktop = new String[wallpaper.length][wallpaper[0].length()];
        for (int i = 0; i < wallpaper.length; i++) {
            desktop[i] = wallpaper[i].split("");
        }

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                // 파일인 경우
                if (desktop[i][j].equals("#")) {
                    xPoint.add(j);
                    yPoint.add(i);
                }
            }
        }

        int minX = Collections.min(xPoint);
        int minY = Collections.min(yPoint);
        int maxX = Collections.max(xPoint);
        int maxY = Collections.max(yPoint);

        return new int[]{minY, minX, maxY + 1, maxX + 1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."})));
    }
}
