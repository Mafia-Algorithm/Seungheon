package pro_park;

import java.util.Arrays;

public class Park {

    public static int[] solution(String[] park, String[] routes) {
        int startX = 0;
        int startY = 0;

        // 공원 2차원 배열로 변경
        String[][] parkMap = new String[park.length][park[0].length()];
        for (int i = 0; i < park.length; i++) {
            parkMap[i] = park[i].split("");
            for (int j = 0; j < parkMap[i].length; j++) {
                if (parkMap[i][j].equals("S")) {
                    startX = i;
                    startY = j;
                }
            }
        }

        // 이동 시작
        for (String route : routes) {
            String direction = route.split(" ")[0];
            int distance = Integer.parseInt(route.split(" ")[1]);
            boolean canMove = true;

            switch (direction) {
                case "E":
                    // 공원을 벗어날 때
                    if (startY + distance >= parkMap[0].length) {
                        break;
                    }

                    // 장애물이 있을 때
                    for (int i = 1; i <= distance; i++) {
                        if (parkMap[startX][startY + i].equals("X")) {
                            canMove = false;
                            break;
                        }
                    }

                    if (!canMove) {
                        break;
                    }

                    // 이동
                    startY += distance;
                    break;
                case "W":
                    // 공원을 벗어날 때
                    if (startY - distance < 0) {
                        break;
                    }

                    // 장애물이 있을 때
                    for (int i = 1; i <= distance; i++) {
                        if (parkMap[startX][startY - i].equals("X")) {
                            canMove = false;
                            break;
                        }
                    }

                    if (!canMove) {
                        break;
                    }

                    // 이동
                    startY -= distance;
                    break;
                case "S":
                    // 공원을 벗어날 때
                    if (startX + distance >= parkMap[0].length) {
                        break;
                    }

                    // 장애물이 있을 때
                    for (int i = 1; i <= distance; i++) {
                        if (parkMap[startX + i][startY].equals("X")) {
                            canMove = false;
                            break;
                        }
                    }

                    if (!canMove) {
                        break;
                    }

                    // 이동
                    startX += distance;
                    break;
                case "N":
                    // 공원을 벗어날 때
                    if (startX - distance < 0) {
                        break;
                    }

                    // 장애물이 있을 때
                    for (int i = 1; i <= distance; i++) {
                        if (parkMap[startX - i][startY].equals("X")) {
                            canMove = false;
                            break;
                        }
                    }

                    if (!canMove) {
                        break;
                    }

                    // 이동
                    startX -= distance;
                    break;
            }
        }

        return new int[]{startX, startY};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[]{"OSO","OOO","OXO","OOO"},
                new String[]{"E 2","S 3","W 1"}
        )));
    }
}
