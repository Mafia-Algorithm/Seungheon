package baek_silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KnightMove {

    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static boolean[][] board;
    static int[][] depth;

    static int knightX;
    static int knightY;
    static int goalX;
    static int goalY;

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{knightX, knightY});
        board[knightX][knightY] = true;

        while (!q.isEmpty()) {
            int[] nowPosition = q.poll();
            int nowX = nowPosition[0];
            int nowY = nowPosition[1];

            for (int i = 0; i < 8; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (0 <= nextX && nextX < board.length && 0 <= nextY && nextY < board.length && !board[nextX][nextY]) {
                    q.add(new int[]{nextX, nextY});
                    depth[nextX][nextY] = depth[nowX][nowY] + 1;
                    board[nextX][nextY] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            int boardLength = Integer.parseInt(br.readLine());
            int[] knightPosition = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] goalPosition = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            depth = new int[boardLength][boardLength];
            board = new boolean[boardLength][boardLength];
            knightX = knightPosition[0];
            knightY = knightPosition[1];
            goalX = goalPosition[0];
            goalY = goalPosition[1];

            bfs();
            sb.append(depth[goalX][goalY]).append("\n");
        }

        System.out.println(sb);
    }
}
