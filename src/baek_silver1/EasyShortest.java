package baek_silver1;

import java.io.*;
import java.util.*;

public class EasyShortest {

    static int n, m;
    static int[][] map;
    static int[][] answer;
    static boolean[][] isVisited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void bfs(int startX, int startY) {

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(startX, startY));
        isVisited[startX][startY] = true;

        while (!queue.isEmpty()) {
            List<Integer> points = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = points.get(0) + dx[i];
                int nextY = points.get(1) + dy[i];

                if (0 <= nextX && nextX < n && 0 <= nextY && nextY < m && !isVisited[nextX][nextY] && map[nextX][nextY] == 1) {
                    isVisited[nextX][nextY] = true;
                    answer[nextX][nextY] = answer[points.get(0)][points.get(1)] + 1;
                    queue.add(List.of(nextX, nextY));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        answer = new int[n][m];
        isVisited = new boolean[n][m];

        int goalX = 0;
        int goalY = 0;

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 2) {
                    goalX = i;
                    goalY = j;
                }

                if (map[i][j] == 0) {
                    isVisited[i][j] = true;
                }
            }
        }
        bfs(goalX, goalY);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisited[i][j]) {
                    answer[i][j] = -1;
                }
                bw.write(answer[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
