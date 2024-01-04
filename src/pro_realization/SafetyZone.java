package pro_realization;

import java.util.Arrays;

public class SafetyZone {


    static int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};

    public int solution(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < 8; k++) {
                        int nextX = i + dx[k];
                        int nextY = j + dy[k];
                        System.out.println(nextX + " " + nextY);
                        if (0 <= nextX && nextX < board.length && 0 <= nextY && nextY < board.length && board[nextX][nextY] != 1) {
                            board[nextX][nextY] = -1;
                        }
                    }
                }
            }
        }

        int safetyZoneCount = 0;
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    safetyZoneCount++;
                }
            }
        }

        return safetyZoneCount;
    }
}
