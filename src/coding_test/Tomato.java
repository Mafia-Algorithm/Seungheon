package coding_test;

import java.io.*;
import java.util.*;

public class Tomato {

    static class TomatoInfo {
        int x;
        int y;
        int day;

        public TomatoInfo(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    static int N;
    static int M;
    static int[][] box;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static Queue<TomatoInfo> queue = new LinkedList<>();

    static void bfs() {
        int day = 0;

        while (!queue.isEmpty()) {
            TomatoInfo t = queue.poll();
            day = t.day;

            for (int i = 0; i < 4; i++) {
                int nextX = t.x + dx[i];
                int nextY = t.y + dy[i];

                if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M) {
                    if (box[nextX][nextY] == 0) {
                        box[nextX][nextY] = 1;
                        queue.add(new TomatoInfo(nextX, nextY, day + 1));
                    }
                }
            }
        }

        if (checkTomato()) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }

    static boolean checkTomato() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.offer(new TomatoInfo(i, j, 0));
                }
            }
        }

        bfs();
    }
}
